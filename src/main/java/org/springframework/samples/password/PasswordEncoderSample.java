package org.springframework.samples.password;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <h2>密码编码示例</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/20 18:26
 */
public class PasswordEncoderSample {
    public static void main(String[] args) {
        String password = "123456";

        encodeWithDefaultEncoder(password);

        usePasswordEncoderFactories(password);

        useBCrytPasswordEncoder(password);

    }

    private static void encodeWithDefaultEncoder(String password) {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("zhangsan")
                .password(password)
                .roles("USER")
                .build();
        System.out.println(userDetails.getPassword());
    }

    private static void usePasswordEncoderFactories(String password) {
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = delegatingPasswordEncoder.encode(password);
        System.out.println(encodedPassword);
        if (delegatingPasswordEncoder.matches(password, "{bcrypt}$2a$10$K.DqKDHXcAKVcqjVq2O9EuLB0xH1nH5BWK4v.gdZoDKIw.Pul3gmy")) {
            System.out.println(password + "是正确密码");
        }

        password = "123789";
        if (delegatingPasswordEncoder.matches(password, encodedPassword)) {
            System.out.println(password + "是正确密码");
        }
    }

    private static void useBCrytPasswordEncoder(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encodedPw = encoder.encode(password);

        System.out.println(encodedPw);
        System.out.println(encoder.matches(password, encodedPw));
    }

}
