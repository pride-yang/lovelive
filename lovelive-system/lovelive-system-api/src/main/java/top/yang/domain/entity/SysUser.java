package top.yang.domain.entity;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import top.yang.domain.pojo.BaseEntity;

@Data
@Table("sys_user")
public class SysUser extends BaseEntity {


    /**
     * 用户ID
     **/
    @Id
    private Long userId;
    /**
     * 部门ID
     **/
    private Long deptId;
    /**
     * 用户账号
     **/
    private String userName;
    /**
     * 用户昵称
     **/
    private String nickName;
    /**
     * 用户类型（00系统用户）
     **/
    private String userType;
    /**
     * 用户邮箱
     **/
    private String email;
    /**
     * 手机号码
     **/
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     **/
    private String sex;
    /**
     * 头像地址
     **/
    private String avatar;
    /**
     * 密码
     **/
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     **/
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     **/
    private String delFlag;
    /**
     * 最后登录IP
     **/
    private String loginIp;
    /**
     * 最后登录时间
     **/
    private LocalDateTime loginDate;
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