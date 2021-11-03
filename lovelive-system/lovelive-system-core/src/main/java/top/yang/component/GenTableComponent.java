package top.yang.component;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;
import top.yang.domain.query.GenTableQuery;
import top.yang.mapper.GenTableColumnMapper;
import top.yang.mapper.GenTableMapper;
import top.yang.repository.BaseJdbcRepository;

@Component
public class GenTableComponent extends BaseJdbcComponent<GenTableMapper, GenTable,Long> {

  @Autowired
  private GenTableMapper genTableMapper;


  protected GenTableMapper getRepository() {
    return genTableMapper;
  }

  public GenTable findGenTableByName(String tableName) {
    return genTableMapper.findGenTableByName(tableName);
  }

  public GenTable findGenTableById(Long tableId) {
    return genTableMapper.findGenTableById(tableId);
  }

  public List<GenTable> findGenTableAll() {
    return genTableMapper.findGenTableAll();
  }

  public List<GenTable> findDbTableListByNames(List<String> tableNames) {
    return genTableMapper.findDbTableListByNames(tableNames);
  }

  public List<GenTable> findDbTableList(GenTable genTable) {
    return genTableMapper.findDbTableList(genTable);
  }

  public List<GenTable> findGenTableList(GenTableQuery genTable) {
    return genTableMapper.findGenTableList(genTable);
  }

  public Long countGenTableList(GenTableQuery genTable) {
    return genTableMapper.countGenTableList(genTable);
  }
}
