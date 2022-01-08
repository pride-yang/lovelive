package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysDictType;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysDictTypeMapper;
@Component
public class SysDictTypeComponent extends BaseJdbcComponent<SysDictTypeMapper, SysDictType, Long>{

    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;


}