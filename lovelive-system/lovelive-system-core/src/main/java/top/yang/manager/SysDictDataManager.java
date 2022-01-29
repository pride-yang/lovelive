package top.yang.manager;

import org.springframework.stereotype.Component;
import top.yang.domain.entity.SysDictData;
import top.yang.manager.BaseManager;
import top.yang.mapper.SysDictDataRepository;

@Component
public class SysDictDataManager extends BaseManager<SysDictDataRepository, SysDictData, Long> {

}