package com.kxuer.datagenerator.demo;

import cn.hutool.core.lang.generator.SnowflakeGenerator;
import com.apifan.common.random.RandomSource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kxuer.datagenerator.DataGeneratorApplicationTests;
import com.kxuer.datagenerator.demo.model.User;
import com.kxuer.datagenerator.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GeneratorTest extends DataGeneratorApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private SnowflakeGenerator snowflakeGenerator;

    /**
     * 主从库添加
     */
    @Test
    public void addUser() {
        //插入主库
        int num = 10;
        List<User> userList = new ArrayList<>(num);
        for(int i = 0; i < num; i++) {
            User userMaster = User.builder()
                    .uuid(snowflakeGenerator.next().toString()) //雪花算法生成uuid
                    .name(RandomSource.personInfoSource().randomChineseName())  //生成1个随机中文人名(性别随机)
                    .age(RandomSource.numberSource().randomInt(18, 60)) //生成1个18~60(不含)之间的随机整数
                    .build();
            userList.add(userMaster);
        }
        userService.saveBatch(userList);

        //插入从库
        User userSlave = User.builder().name(RandomSource.personInfoSource().randomChineseName()).age(RandomSource.numberSource().randomInt(18, 60)).build();
        userService.addUser(userSlave);
    }

    /**
     * 从库查询
     */
    @Test
    public void testListUser(){
        List<User> userList = userService.list(new QueryWrapper<>());
        log.info("主库查询结果：{}",userList);
    }
}
