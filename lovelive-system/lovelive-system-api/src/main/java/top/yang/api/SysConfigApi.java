package top.yang.api;

import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.query.SysConfigQuery;

public interface SysConfigApi {

    PageResult<SysConfigDto> search(SysConfigQuery sysConfig);
}
