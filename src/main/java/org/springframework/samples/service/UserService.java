package org.springframework.samples.service;

import org.springframework.samples.model.User;

/**
 * <h2>用户服务接口</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/9/15 14:22
 */
public interface UserService {
    /**
     * 新增用户
     * @param user 用户
     */
    void insertUser(User user);
}
