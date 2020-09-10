package org.springframework.samples.config;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * <h2>验证码校验</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/9/10 9:43
 */
public class CaptchaFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 非登录请求，不需要校验验证码
        if (!"/loginUrl".equals(request.getRequestURI())) {
            // 传递给过滤器链上的下一个Filter
            filterChain.doFilter(request, response);
            return;
        }

        // 获取用户输入的验证码
        String captchaCode = request.getParameter("captcha");
        boolean verification = HappyCaptcha.verification(request, captchaCode, true);
        // 验证后清除验证码
        HappyCaptcha.remove(request);
        if (verification) {
            // 验证通过，传递给过滤器链上的下一个Filter
            filterChain.doFilter(request, response);
        } else {
            // 验证不通过，重定向到登录错误页面
            response.sendRedirect("/login-error?msg=" + URLEncoder.encode("验证码不正确", "UTF-8"));
        }
    }

}
