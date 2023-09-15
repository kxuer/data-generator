package com.kxuer.datagenerator.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kxuer.datagenerator.demo.model.User;

public interface UserService extends IService<User> {
    void addUser(User user);
}
