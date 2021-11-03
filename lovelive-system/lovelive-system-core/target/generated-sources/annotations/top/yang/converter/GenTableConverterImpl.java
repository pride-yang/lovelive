package top.yang.converter;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import top.yang.domain.query.GenTableQuery;
import top.yang.request.GenTableReq;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-31T11:03:46+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Eclipse Foundation)"
)
@Component
public class GenTableConverterImpl implements GenTableConverter {

    @Override
    public GenTableQuery reqToQuery(GenTableReq req) {
        if ( req == null ) {
            return null;
        }

        GenTableQuery genTableQuery = new GenTableQuery();

        genTableQuery.setTableName( req.getTableName() );
        genTableQuery.setTableComment( req.getTableComment() );

        return genTableQuery;
    }
}
