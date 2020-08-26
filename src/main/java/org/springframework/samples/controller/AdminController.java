package org.springframework.samples.controller;

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

    @GetMapping("/hello")
    public String hello() {
        return "管理员请求";
    }
}
