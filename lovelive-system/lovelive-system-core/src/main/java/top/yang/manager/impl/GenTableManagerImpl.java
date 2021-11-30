package top.yang.manager.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import top.yang.component.GenTableColumnComponent;
import top.yang.component.GenTableComponent;
import top.yang.constants.GenConstants;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;
import top.yang.domain.query.GenTableQuery;
import top.yang.manager.GenTableManager;
import top.yang.reflect.ObjectUtils;
import top.yang.string.StringUtils;

@Component
@DubboService
@Slf4j
public class GenTableManagerImpl extends BaseManager<GenTableComponent, GenTable, Long> implements GenTableManager {

    @Autowired
    private GenTableComponent genTableComponent;
    @Autowired
    private GenTableColumnComponent genTableColumnComponent;


    /**
     * 查询业务信息
     *
     * @param id 业务ID
     * @return 业务信息
     */

    public GenTable findGenTableById(Long id) {
        GenTable genTable = genTableComponent.findGenTableById(id);
        setTableFromOptions(genTable);
        return genTable;
    }

    /**
     * 查询业务列表
     *
     * @param genTable 业务信息
     * @return 业务集合
     */

    public PageResult<GenTable> findGenTableList(GenTableQuery genTable) {
        List<GenTable> genTableList = genTableComponent.findGenTableList(genTable);
        Long count = genTableComponent.countGenTableList(genTable);
        return new PageResult<GenTable>((int) (count / genTable.getPageSize()), count, genTableList, genTable.getPage());
    }

    /**
     * 查询据库列表
     *
     * @param genTable 业务信息
     * @return 数据库表集合
     */

    public List<GenTable> findDbTableList(GenTableQuery genTable) {
        return genTableComponent.findDbTableList(genTable);
    }

    /**
     * 查询据库列表
     *
     * @param tableNames 表名称组
     * @return 数据库表集合
     */

    public List<GenTable> findDbTableListByNames(List<String> tableNames) {
        return genTableComponent.findDbTableListByNames(tableNames);
    }

    /**
     * 查询所有表信息
     *
     * @return 表信息集合
     */

    public List<GenTable> findGenTableAll() {
        return genTableComponent.findGenTableAll();
    }


    /**
     * 修改业务
     *
     * @param genTable 业务信息
     * @return 结果
     */

    @Transactional
    public void updateGenTable(GenTable genTable) {
        GenTable row = genTableComponent.update(genTable);
        if (ObjectUtils.isNotNull(row)) {
            for (GenTableColumn cenTableColumn : genTable.getColumns()) {
                genTableColumnComponent.update(cenTableColumn);
            }
        }
    }

    @Transactional
    public void saveGenTable(GenTable genTable) {
        GenTable row = genTableComponent.update(genTable);
        if (ObjectUtils.isNotNull(row)) {
            for (GenTableColumn cenTableColumn : genTable.getColumns()) {
                genTableColumnComponent.update(cenTableColumn);
            }
        }
    }

    /**
     * 删除业务对象
     *
     * @param tableIds 需要删除的数据ID
     * @return 结果
     */

    @Transactional
    public void deleteGenTableByIds(List<Long> tableIds) {
        genTableComponent.deleteByIds(tableIds);
        genTableColumnComponent.deleteByIds(tableIds);
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
            table.setSubTable(genTableComponent.findGenTableByName(subTableName));
        }
    }

    /**
     * 设置代码生成其他选项值
     *
     * @param genTable 设置后的生成对象
     */
    public void setTableFromOptions(GenTable genTable) {

        if (ObjectUtils.isNotNull(genTable)) {
            String treeCode = genTable.getTreeCode();
            String treeParentCode = genTable.getTreeParentCode();
            String treeName = genTable.getTreeName();
            String parentMenuId = genTable.getParentMenuId();
            String parentMenuName = genTable.getParentMenuName();

            genTable.setTreeCode(treeCode);
            genTable.setTreeParentCode(treeParentCode);
            genTable.setTreeName(treeName);
            genTable.setParentMenuId(parentMenuId);
            genTable.setParentMenuName(parentMenuName);
        }
    }

    public GenTable findGenTableByName(String tableName) {
        return genTableComponent.findGenTableByName(tableName);
    }

    public void selectDbTableList(GenTableQuery genTableQuery) {
        List<GenTable> dbTableList = genTableComponent.findDbTableList(genTableQuery);
        genTableComponent.countGenTableList()
    }
}
