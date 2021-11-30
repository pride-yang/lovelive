package top.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.GenTable;
import top.yang.request.GenTableReq;
import top.yang.service.GenTableService;
import top.yang.web.controller.BaseController;

@Controller("tool/gen")
public class GenController extends BaseController {

    @Autowired
    private GenTableService genTableService;

    /**
     * 查询代码生成列表
     */
    @GetMapping("/list")
    public PageResult<GenTable> genList(GenTableReq genTable) {
        return genTableService.findGenTableList(genTable);
    }

//  /**
//   * 修改代码生成业务
//   */
//  @GetMapping(value = "/{talbleId}")
//  public AjaxResult getInfo(@PathVariable Long talbleId) {
//    GenTable table = genTableService.findGenTableById(talbleId);
//    List<GenTable> tables = genTableService.selectGenTableAll();
//    List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(talbleId);
//    Map<String, Object> map = new HashMap<String, Object>();
//    map.put("info", table);
//    map.put("rows", list);
//    map.put("tables", tables);
//    return AjaxResult.success(map);
//  }

    /**
     * 查询数据库列表
     */

    @GetMapping("/db/list")
    public PageResult<GenTable> dataList(GenTableReq genTable) {
        return genTableService.selectDbTableList(genTable);
    }
//
//  /**
//   * 查询数据表字段列表
//   */
//
//  @GetMapping(value = "/column/{talbleId}")
//  public TableDataInfo columnList(Long tableId) {
//    TableDataInfo dataInfo = new TableDataInfo();
//    List<GenTableColumn> list = genTableColumnService.selectGenTableColumnListByTableId(tableId);
//    dataInfo.setRows(list);
//    dataInfo.setTotal(list.size());
//    return dataInfo;
//  }
//
//  /**
//   * 导入表结构（保存）
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.IMPORT)
//  @PostMapping("/importTable")
//  public AjaxResult importTableSave(String tables) {
//    String[] tableNames = Convert.toStrArray(tables);
//    // 查询表信息
//    List<GenTable> tableList = genTableService.selectDbTableListByNames(tableNames);
//    genTableService.importGenTable(tableList);
//    return AjaxResult.success();
//  }
//
//  /**
//   * 修改保存代码生成业务
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.UPDATE)
//  @PutMapping
//  public AjaxResult editSave(@Validated @RequestBody GenTable genTable) {
//    genTableService.validateEdit(genTable);
//    genTableService.updateGenTable(genTable);
//    return AjaxResult.success();
//  }
//
//  /**
//   * 删除代码生成
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.DELETE)
//  @DeleteMapping("/{tableIds}")
//  public AjaxResult remove(@PathVariable Long[] tableIds) {
//    genTableService.deleteGenTableByIds(tableIds);
//    return AjaxResult.success();
//  }
//
//  /**
//   * 预览代码
//   */
//
//  @GetMapping("/preview/{tableId}")
//  public AjaxResult preview(@PathVariable("tableId") Long tableId) throws IOException {
//    Map<String, String> dataMap = genTableService.previewCode(tableId);
//    return AjaxResult.success(dataMap);
//  }
//
//  /**
//   * 生成代码（下载方式）
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.GENCODE)
//  @GetMapping("/download/{tableName}")
//  public void download(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException {
//    byte[] data = genTableService.downloadCode(tableName);
//    genCode(response, data);
//  }
//
//  /**
//   * 生成代码（自定义路径）
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.GENCODE)
//  @GetMapping("/genCode/{tableName}")
//  public AjaxResult genCode(@PathVariable("tableName") String tableName) {
//    genTableService.generatorCode(tableName);
//    return AjaxResult.success();
//  }
//
//  /**
//   * 批量生成代码
//   */
//
//  @ControllerLog(title = "代码生成", businessType = BusinessType.GENCODE)
//  @GetMapping("/batchGenCode")
//  public void batchGenCode(HttpServletResponse response, String tables) throws IOException {
//    String[] tableNames = Convert.toStrArray(tables);
//    byte[] data = genTableService.downloadCode(tableNames);
//    genCode(response, data);
//  }
//
//  /**
//   * 生成zip文件
//   */
//  private void genCode(HttpServletResponse response, byte[] data) throws IOException {
//    response.reset();
//    response.addHeader("Access-Control-Allow-Origin", "*");
//    response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
//    response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");
//    response.addHeader("Content-Length", "" + data.length);
//    response.setContentType("application/octet-stream; charset=UTF-8");
//    IOUtils.write(data, response.getOutputStream());
//  }
}
