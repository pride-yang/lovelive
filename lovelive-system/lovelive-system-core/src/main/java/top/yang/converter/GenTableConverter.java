package top.yang.converter;

import org.mapstruct.Mapper;

import top.yang.domain.query.GenTableQuery;
import top.yang.request.GenTableReq;

@Mapper(componentModel = "spring")
public interface GenTableConverter {

  GenTableQuery reqToQuery(GenTableReq req);
}
