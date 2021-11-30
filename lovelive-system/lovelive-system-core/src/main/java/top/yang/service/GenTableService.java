package top.yang.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yang.constants.GenConstants;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;
import top.yang.domain.query.GenTableQuery;
import top.yang.exception.SystemCode;
import top.yang.manager.impl.GenTableManagerImpl;
import top.yang.reflect.ObjectUtils;
import top.yang.request.GenTableReq;
import top.yang.string.StringUtils;
import top.yang.utils.GenUtils;
import top.yang.utils.VelocityInitializer;
import top.yang.utils.VelocityUtils;
import top.yang.web.exception.BusinessException;

@Service
public class GenTableService {

    private static final Logger log = LoggerFactory.getLogger(GenTableService.class);

    private final GenTableManagerImpl genTableManager;

    public GenTableService(GenTableManagerImpl genTableManager) {
        this.genTableManager = genTableManager;
    }

    /**
     * 导入表结构
     *
     * @param tableList 导入表列表
     */

    @Transactional(rollbackFor = Exception.class)
    public void importGenTable(List<GenTable> tableList) {
        try {
            for (GenTable table : tableList) {
                String tableName = table.getTableName();
                GenUtils.initTable(table);
                genTableManager.saveGenTable(table);
            }
        } catch (Exception e) {
            throw new BusinessException(SystemCode.IMPORT_FAILURE);
        }
    }

    /**
     * 预览代码
     *
     * @param tableId 表编号
     * @return 预览数据列表
     */

    public Map<String, String> previewCode(Long tableId) {
        Map<String, String> dataMap = new LinkedHashMap<>();
        // 查询表信息
        GenTable table = genTableManager.findGenTableById(tableId);
        // 设置主子表信息
        setSubTable(table);
        // 设置主键列信息
        setPkColumn(table);
        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, StringUtils.UTF_8);
            tpl.merge(context, sw);
            dataMap.put(template, sw.toString());
        }
        return dataMap;
    }

    /**
     * 生成代码（下载方式）
     *
     * @param tableName 表名称
     * @return 数据
     */

    public byte[] downloadCode(String tableName) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        generatorCode(tableName, zip);
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 生成代码（自定义路径）
     *
     * @param tableName 表名称
     */

    public void generatorCode(String tableName) {
        // 查询表信息
        GenTable table = genTableManager.findGenTableByName(tableName);
        // 设置主子表信息
        setSubTable(table);
        // 设置主键列信息
        setPkColumn(table);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates) {
            if (!StringUtils.containsAny(template, "sql.vm", "api.js.vm", "index.vue.vm", "index-tree.vue.vm")) {
                // 渲染模板
                StringWriter sw = new StringWriter();
                Template tpl = Velocity.getTemplate(template, StringUtils.UTF_8);
                tpl.merge(context, sw);
                try {
                    String path = getGenPath(table, template);
                    FileUtils.writeStringToFile(new File(path), sw.toString(), StringUtils.UTF_8);
                } catch (IOException e) {
                    throw new BusinessException(SystemCode.TEMPLATE_RENDERING_IS_FALL);
                }
            }
        }
    }


    /**
     * 批量生成代码（下载方式）
     *
     * @param tableNames 表数组
     * @return 数据
     */

    public byte[] downloadCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);
        for (String tableName : tableNames) {
            generatorCode(tableName, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }

    /**
     * 查询表信息并生成代码
     */
    private void generatorCode(String tableName, ZipOutputStream zip) {
        // 查询表信息
        GenTable table = genTableManager.findGenTableByName(tableName);
        // 设置主子表信息
        setSubTable(table);
        // 设置主键列信息
        setPkColumn(table);

        VelocityInitializer.initVelocity();

        VelocityContext context = VelocityUtils.prepareContext(table);

        // 获取模板列表
        List<String> templates = VelocityUtils.getTemplateList(table.getTplCategory());
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, StringUtils.UTF_8);
            tpl.merge(context, sw);
            try {
                // 添加到zip
                zip.putNextEntry(new ZipEntry(VelocityUtils.getFileName(template, table)));
                IOUtils.write(sw.toString(), zip, StringUtils.UTF_8);
                IOUtils.closeQuietly(sw);
                zip.flush();
                zip.closeEntry();
            } catch (IOException e) {
                log.error("渲染模板失败，表名：" + table.getTableName(), e);
            }
        }
    }

    /**
     * 修改保存参数校验
     *
     * @param genTable 业务信息
     */

    public void validateEdit(GenTable genTable) {
        if (GenConstants.TPL_TREE.equals(genTable.getTplCategory())) {
            if (StringUtils.isEmpty(genTable.getTreeCode())) {
                throw new BusinessException(SystemCode.TREE_CODE_IS_NOT_NULL);
            } else if (StringUtils.isEmpty(genTable.getTreeParentCode())) {
                throw new BusinessException(SystemCode.TREE_PARENT_CODE_IS_NOT_NULL);
            } else if (StringUtils.isEmpty(genTable.getTreeName())) {
                throw new BusinessException(SystemCode.TREE_NAME_IS_NOT_NULL);
            } else if (GenConstants.TPL_SUB.equals(genTable.getTplCategory())) {
                if (StringUtils.isEmpty(genTable.getSubTableName())) {
                    throw new BusinessException(SystemCode.SUB_TABLE_NAME_IS_NOT_NULL);
                } else if (StringUtils.isEmpty(genTable.getSubTableFkName())) {
                    throw new BusinessException(SystemCode.SUB_TABLE_FK_NAME_IS_NOT_NULL);
                }
            }
        }
    }

    /**
     * 设置主键列信息
     *
     * @param table 业务表信息
     */
    public void setPkColumn(GenTable table) {
        for (GenTableColumn column : table.getColumns()) {
            if (column.isPk()) {
                table.setPkColumn(column);
                break;
            }
        }
        if (ObjectUtils.isNull(table.getPkColumn())) {
            table.setPkColumn(table.getColumns().get(0));
        }
        if (GenConstants.TPL_SUB.equals(table.getTplCategory())) {
            for (GenTableColumn column : table.getSubTable().getColumns()) {
                if (column.isPk()) {
                    table.getSubTable().setPkColumn(column);
                    break;
                }
            }
            if (ObjectUtils.isEmpty(table.getSubTable().getPkColumn())) {
                table.getSubTable().setPkColumn(table.getSubTable().getColumns().get(0));
            }
        }
    }

    /**
     * 设置主子表信息
     *
     * @param table 业务表信息
     */
    public void setSubTable(GenTable table) {
        String subTableName = table.getSubTableName();
        if (StringUtils.isNotEmpty(subTableName)) {
            table.setSubTable(genTableManager.findGenTableByName(subTableName));
        }
    }

    /**
     * 获取代码生成地址
     *
     * @param table    业务表信息
     * @param template 模板文件路径
     * @return 生成地址
     */
    public static String getGenPath(GenTable table, String template) {
        String genPath = table.getGenPath();
        if (StringUtils.equals(genPath, "/")) {
            return System.getProperty("user.dir") + File.separator + "src" + File.separator + VelocityUtils.getFileName(template, table);
        }
        return genPath + File.separator + VelocityUtils.getFileName(template, table);
    }

    public PageResult<GenTable> findGenTableList(GenTableReq genTable) {
        GenTableQuery genTableQuery = new GenTableQuery();
        BeanUtils.copyProperties(genTable, genTableQuery);
        return genTableManager.findGenTableList(genTableQuery);
    }

    public PageResult<GenTable> selectDbTableList(GenTableReq genTable) {
        GenTableQuery genTableQuery = new GenTableQuery();
        BeanUtils.copyProperties(genTable, genTableQuery);
        genTableManager.selectDbTableList(genTableQuery);

        return null;
    }
}
