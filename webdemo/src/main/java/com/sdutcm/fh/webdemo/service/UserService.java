package com.sdutcm.fh.webdemo.service;


import com.sdutcm.fh.webdemo.entities.Employee;
import com.sdutcm.fh.webdemo.entities.User;
import com.sdutcm.fh.webdemo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<Employee> findAllemp() {
        return userMapper.findAllemp();
    }

    public int deleteByID(int id) {
        return userMapper.deleteByID(id);
    }

    public User findByID(String username) {
        return userMapper.findUserByID(username);
    }


    public int addUser(Employee employee) {
        return userMapper.addUser(employee);
    }

    public User findByiP(String username, String password) {
        return userMapper.findByiP(username, password);
    }


    public int addinsert(String username, String password) {
        return userMapper.addinsert(username, password);
    }
/*
    public Employee findEmployeeByID(Integer id) {
        return userMapper.findEmployeeByID(id);
    }
*/

}
