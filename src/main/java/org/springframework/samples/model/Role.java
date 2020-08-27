package org.springframework.samples.model;

import lombok.Data;

/**
 * <h2>角色对象</h2>
 * description:
 *
 * @author yongjun.ji(yongjun.ji @ ucarinc.com)
 * @since 1.0 2020/8/27 18:40
 */
@Data
public class Role {
    private Long id;
    private String name;
    private String code;
}
