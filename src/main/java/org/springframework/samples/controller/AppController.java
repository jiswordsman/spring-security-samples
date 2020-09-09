package org.springframework.samples.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @GetMapping("/captcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response)
                // 表示生成中文算法类型的验证码
                .type(CaptchaType.ARITHMETIC_ZH)
                .build()
                .finish();
    }
}
