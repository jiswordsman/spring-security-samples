package org.springframework.samples.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <h2>用户对象</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/27 17:33
 */
@Data
public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private Boolean enable;
    /** 用户拥有的权限 */
    private List<GrantedAuthority> authorities;

    @Override
    public boolean isEnabled() {
        return enable;
    }

    /** 以下方法暂时用不到，全部设置为true */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
