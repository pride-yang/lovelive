package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysDictType;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysDictTypeRepository;

@Component
public class SysDictTypeComponent extends BaseJdbcComponent<SysDictTypeRepository, SysDictType, Long>{

    @Autowired
    private SysDictTypeRepository sysDictTypeRepository;


}