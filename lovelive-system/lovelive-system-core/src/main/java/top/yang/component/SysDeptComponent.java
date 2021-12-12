package top.yang.component;

import org.springframework.beans.factory.annotation.Autowired;
import top.yang.domain.entity.SysDept;
import org.springframework.stereotype.Component;
import top.yang.mapper.SysDeptMapper;

/**
 * @author PrideYang
 */
@Component
public class SysDeptComponent extends BaseJdbcComponent<SysDeptMapper, SysDept, Long>{

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    protected SysDeptMapper getRepository() {
        return sysDeptMapper;    }
}