package com.hb.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @description 
 * @author zhaochengshui
 * @date 2023/4/2 
 */

@Data
@Accessors(chain = true)
@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    private String password;

    /**
     * 1=启用 0=禁用
     */
    @TableField(value = "is_enable")
    private Integer isEnable;

    /**
     * 真实姓名
     */
    @TableField(value = "real_name")
    private String realName;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 修改者
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 逻辑删除 1=是 0=否
     */
    @TableField(value = "is_deleted")
    private Boolean isDeleted;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
}
