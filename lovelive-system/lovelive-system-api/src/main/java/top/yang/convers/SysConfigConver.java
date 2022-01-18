package top.yang.convers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;

/**
 * @author pride
 */
@Mapper
public interface SysConfigConver {

    SysConfigConver INSTANCE = Mappers.getMapper(SysConfigConver.class);

    public PageResult<SysConfigDto> entityToDtoPage(PageResult<SysConfig> pageResult);

    public SysConfigDto entityToDto(SysConfig sysConfig);

    public List<SysConfigDto> entityToDtoList(List<SysConfig> configList);
}
