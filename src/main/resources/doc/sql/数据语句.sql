INSERT INTO t_user(username, `password`, `enable`) VALUES("admin", "{noop}password", 1);
INSERT INTO t_user(username, `password`, `enable`) VALUES("user", "{noop}password", 1);

INSERT INTO t_role(name, code) VALUES("普通用户", "ROLE_USER");
INSERT INTO t_role(name, code) VALUES("管理员", "ROLE_ADMIN");

-- 用户admin拥有ADMIN和USER两个角色
INSERT INTO t_user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO t_user_role(user_id, role_id) VALUES(1, 2);
-- 用户user拥有USER一个角色
INSERT INTO t_user_role(user_id, role_id) VALUES(2, 1);