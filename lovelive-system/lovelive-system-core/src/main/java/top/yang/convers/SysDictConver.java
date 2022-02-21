package top.yang.convers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.yang.domain.dto.PageResult;
import top.yang.domain.dto.SysDictDataDto;
import top.yang.domain.dto.SysDictTypeDto;
import top.yang.request.SysDictDataReq;
import top.yang.request.SysDictTypeReq;
import top.yang.response.SysDictDataRes;
import top.yang.response.SysDictTypeRes;

/**
 * @author pride
 */
@Mapper
public interface SysDictConver {

    SysDictConver INSTANCE = Mappers.getMapper(SysDictConver.class);


    SysDictDataRes dataDtoToRes(SysDictDataDto sysDictDataDto);

    SysDictTypeRes typeDtoToRes(SysDictTypeDto sysDictTypeDto);

    PageResult<SysDictDataRes> dataDtoToResPage(PageResult<SysDictDataDto> sysDictDataDtoPageResult);

    PageResult<SysDictTypeRes> typeDtoToResPage(PageResult<SysDictTypeDto> list);

    SysDictDataDto dataReqToDto(SysDictDataReq sysDictDataReq);


    SysDictTypeDto typeReqToDto(SysDictTypeReq dictTypeReq);
}
