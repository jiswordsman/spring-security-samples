-- 用户表
CREATE TABLE `spring_security`.`t_user`  (
   `id` bigint unsigned NOT NULL COMMENT '主键',
   `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
   `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
   `enable` bit(1) NULL DEFAULT NULL COMMENT '用户是否可用',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- 角色表
CREATE TABLE `spring_security`.`t_role`  (
    `id` bigint unsigned NOT NULL COMMENT '主键',
    `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色名称',
    `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色编码',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- 用户角色表
CREATE TABLE `spring_security`.`t_user_role`  (
   `id` bigint unsigned NOT NULL COMMENT '主键',
   `user_id` bigint(0) NULL DEFAULT NULL COMMENT '用户id',
   `role_id` bigint(0) NULL DEFAULT NULL COMMENT '角色id',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;