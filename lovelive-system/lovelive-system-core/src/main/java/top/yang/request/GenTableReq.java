package top.yang.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.yang.web.domain.request.PageReq;

/**
 * @author pride
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GenTableReq extends PageReq {

  /**
   * 表名称
   */

  private String tableName;

  /**
   * 表描述
   */

  private String tableComment;
}
