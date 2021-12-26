package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysDictData;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysDictDataMapper;

/**
 * @author PrideYang
 */
@Component
public class SysDictDataComponent extends BaseJdbcComponent<SysDictDataMapper, SysDictData, Long>{

}