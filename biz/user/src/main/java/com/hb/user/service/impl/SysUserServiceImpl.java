package com.hb.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.user.mapper.SysUserMapper;
import com.hb.user.model.SysUser;
import com.hb.user.service.SysUserService;
/**
 * 
 * @description 
 * @author zhaochengshui
 * @date 2023/4/2 
 */

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

}
