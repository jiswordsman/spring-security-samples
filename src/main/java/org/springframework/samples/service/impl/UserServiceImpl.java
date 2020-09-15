package org.springframework.samples.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mapper.UserMapper;
import org.springframework.samples.model.User;
import org.springframework.samples.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <h2></h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/9/15 14:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insertUser(User user) {
        // 如果数据库已经存在相同用户名的用户，返回错误提示
        User existUser = userMapper.loadUserByUsername(user.getUsername());
        if (existUser != null) {
            throw new RuntimeException("用户已存在");
        }
        // 对密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 保存用户
        userMapper.insertUser(user);
    }

}
