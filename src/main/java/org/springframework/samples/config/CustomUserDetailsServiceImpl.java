package org.springframework.samples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mapper.UserMapper;
import org.springframework.samples.model.Role;
import org.springframework.samples.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <h2>自定义用户信息查询服务</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/27 17:47
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中查询用户
        User user = userMapper.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        // 查询用户的角色
        List<Role> roles = userMapper.loadRolesByUserId(user.getId());
        // 把角色转换成数组
        String[] roleCodes = roles.stream()
                .map(Role::getCode)
                .collect(Collectors.toList())
                .toArray(new String[0]);
        List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList(roleCodes);
        // 设置用户的权限
        user.setAuthorities(authorityList);
        return user;
    }

}
