-- `spring-boot-demo`.multi_user definition

CREATE TABLE `multi_user` (
                              `id` bigint NOT NULL,
                              `uuid` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                              `name` varchar(50) DEFAULT NULL,
                              `age` int DEFAULT NULL,
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;