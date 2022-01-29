package top.yang.convers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysConfigDto;
import top.yang.domain.entity.SysConfig;
import top.yang.response.SysConfigRes;

/**
 * @author pride
 */
@Mapper
public interface SysConfigConver {

    SysConfigConver INSTANCE = Mappers.getMapper(SysConfigConver.class);

    SysConfigDto entityToDto(SysConfig sysConfig);

    SysConfigRes dtoToRes(SysConfigDto sysConfigDto);

    List<SysConfigDto> entityToDtoList(List<SysConfig> configList);

    List<SysConfigRes> dtoToResList(List<SysConfigDto> list);

    PageResult<SysConfigDto> entityToDtoPage(PageResult<SysConfig> pageResult);

    PageResult<SysConfigRes> dtoToResPage(PageResult<SysConfigDto> pageResult);


}
