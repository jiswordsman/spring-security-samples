package org.springframework.samples.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.model.Role;
import org.springframework.samples.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h2>用户信息mapper</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/27 17:32
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return 用户
     */
    @Select("select * from t_user where username = #{username}")
    User loadUserByUsername(String username);

    /**
     * 根据用户id查询用户拥有的角色
     * @param userId 用户id
     * @return 用户拥有的角色
     */
    @Select("SELECT r.*  FROM t_user_role ur LEFT JOIN t_role r ON r.id = ur.role_id  WHERE ur.user_id = #{userId}")
    List<Role> loadRolesByUserId(Long userId);

    /**
     * 保存用户
     * @param user 用户
     */
    @Insert("insert into t_user(username, password, enable) values(#{username}, #{password}, 1)")
    void insertUser(User user);

}
