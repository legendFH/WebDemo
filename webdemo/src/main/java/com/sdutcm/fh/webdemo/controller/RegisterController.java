package com.sdutcm.fh.webdemo.controller;


import com.sdutcm.fh.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    /*    //进入注册页面，使用Get请求，REST风格的URL能更优雅的处理问题
        @GetMapping(value = "/register")
        public String re() {
            return "register";
        }*/
//跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @GetMapping(value = "/register")

    public String reg(
            String username,
            String password, String confirmpassword,
            ModelMap modelMap) throws IOException {
        if (password != null && !password.equals(confirmpassword)) {
            modelMap.addAttribute("msg1", "not the same password");
            return "register";
        } else if (userService.findByID(username) == null) {
            int i = userService.addinsert(username, password);
            if (i > 0) {
                modelMap.addAttribute("msg3", "good boy~  register success!");
                System.out.println("success");

            }
            return "register";
        } else {
            modelMap.addAttribute("msg2", "this id was already been used");
            return "register";
        }

    }


}