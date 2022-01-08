package top.yang.manager.impl;
import top.yang.component.SysDictDataComponent;
import top.yang.manager.SysDictDataManager;
import top.yang.domain.entity.SysDictData;
import top.yang.domain.entity.SysDictData;
import org.springframework.stereotype.Component;
@Component
public class SysDictDataManagerImpl extends BaseManagerImpl<SysDictDataComponent, SysDictData, Long> implements SysDictDataManager {
    @Override
    public Class getEntityClass() {
        return SysDictData.class;
    }
}