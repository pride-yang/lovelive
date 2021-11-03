package top.yang.component;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.GenTableColumn;
import top.yang.mapper.GenTableColumnMapper;

@Component
public class GenTableColumnComponent extends BaseJdbcComponent<GenTableColumnMapper, GenTableColumn, Long> {

  @Autowired
  private GenTableColumnMapper genTableColumnMapper;


  protected GenTableColumnMapper getRepository() {
    return genTableColumnMapper;
  }
}
