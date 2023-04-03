package com.hb.user.service.impl;

import com.hb.api.UserApi;
import com.hb.dto.UserDTO;
import com.hb.user.mapper.SysUserMapper;
import com.hb.user.model.SysUser;

import javax.annotation.Resource;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
public class UserApiImpl implements UserApi {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserDTO findById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        return null;
    }
}
