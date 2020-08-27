package org.springframework.samples.controller;

import org.springframework.web.bind.annotation.*;

/**
 * <h2>app请求</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/25 14:04
 */
@RestController
@RequestMapping("/app/api")
public class AppController {
    @GetMapping("/hello")
    public String hello() {
        return "app公开请求";
    }

}
