package com.hb.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@Data
public class UserDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 1=启用 0=禁用
     */
    private Integer isEnable;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;


}
