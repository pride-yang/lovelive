package top.yang.manager;

import org.springframework.stereotype.Component;
import top.yang.domain.dto.PageResult;
import top.yang.domain.entity.SysDictType;
import top.yang.manager.BaseManager;
import top.yang.mapper.SysDictTypeRepository;

/**
 * @author pride
 */
@Component
public class SysDictTypeManager extends BaseManager<SysDictTypeRepository, SysDictType, Long> {

    public PageResult<SysDictType> findByQuery() {
        return null;
    }
}