package org.springframework.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.model.User;
import org.springframework.samples.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * <h2>管理员请求控制器</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/25 14:02
 */
@RestController
@RequestMapping("/admin/api")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "管理员请求";
    }

    @PostMapping("/createUser")
    public String createUser(User user) {
        userService.insertUser(user);
        return "成功";
    }
}
