package com.hb.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hb.user.UserAppStart;
import com.hb.user.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
@SpringBootTest(classes = UserAppStart.class)
@RunWith(SpringRunner.class)
public class SysMenuMapperTest {
    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void test(){
        List<SysUser> sysMenus = sysUserMapper.selectList(new QueryWrapper<>());
        System.out.println("sysMenus = " + sysMenus);
    }

}
