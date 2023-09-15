package com.kxuer.datagenerator.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kxuer.datagenerator.demo.mapper.UserMapper;
import com.kxuer.datagenerator.demo.model.User;
import com.kxuer.datagenerator.demo.service.UserService;
import org.springframework.stereotype.Service;

@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 类上 {@code @DS("master")} 代表默认主库，在方法上写 {@code @DS("slave")} 代表使用从库
     *
     * @param user 用户
     */
    @DS("slave")
    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }
}
