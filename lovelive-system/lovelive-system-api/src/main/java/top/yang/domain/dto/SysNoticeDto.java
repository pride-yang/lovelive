package top.yang.domain.dto;

import java.util.Date;
import lombok.Data;

@Data
public class SysNoticeDto extends BaseDto {


    /**
     * 公告ID
     **/
    private Long noticeId;
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