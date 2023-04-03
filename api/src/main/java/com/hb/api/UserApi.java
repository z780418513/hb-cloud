package com.hb.api;

import com.hb.dto.UserDTO;

/**
 * @author zhaochengshui
 * @description
 * @date 2023/4/2
 */
public interface UserApi {
    UserDTO findById(Long id);
}
