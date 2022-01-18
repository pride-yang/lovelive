package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysDictData;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysDictDataRepository;

@Component
public class SysDictDataComponent extends BaseJdbcComponent<SysDictDataRepository, SysDictData, Long>{



}