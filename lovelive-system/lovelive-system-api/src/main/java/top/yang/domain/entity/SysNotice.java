package top.yang.domain.entity;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;
@Data
@Table("sys_notice")
public class SysNotice extends BaseEntity {


  /**
   * 公告ID
  **/
  @Id
  private Integer noticeId;
  /**
   * 公告标题
  **/
  private String noticeTitle;
  /**
   * 公告类型（1通知 2公告）
  **/
  private String noticeType;
  /**
   * 公告内容
  **/
  private String noticeContent;
  /**
   * 公告状态（0正常 1关闭）
  **/
  private String status;
  /**
   * 创建者
  **/
  private String createBy;
  /**
   * 更新者
  **/
  private String updateBy;
  /**
   * 备注
  **/
  private String remark;
}