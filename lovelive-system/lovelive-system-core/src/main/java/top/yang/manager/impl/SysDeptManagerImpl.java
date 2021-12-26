package top.yang.manager.impl;

import top.yang.component.SysDeptComponent;
import top.yang.domain.dto.SysDeptDto;
import top.yang.manager.SysDeptManager;
import top.yang.domain.entity.SysDept;
import org.springframework.stereotype.Component;

/**
 * @author PrideYang
 */
@Component
public class SysDeptManagerImpl extends BaseManagerImpl<SysDeptComponent, SysDeptDto, Long> implements SysDeptManager {

    @Override
    public Class getEntityClass() {
        return SysDept.class;
    }
}