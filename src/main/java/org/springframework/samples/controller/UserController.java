package org.springframework.samples.controller;

import org.springframework.web.bind.annotation.*;

/**
 * <h2>用户请求</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/25 14:04
 */
@RestController
@RequestMapping("/user/api")
public class UserController {
    @GetMapping("/hello")
    public String hello() {
        return "普通用户请求";
    }

}
