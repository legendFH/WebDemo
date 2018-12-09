package com.sdutcm.fh.webdemo.controller;

import com.sdutcm.fh.webdemo.entities.User;
import com.sdutcm.fh.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String main(ModelMap modelMap) {
        modelMap.addAttribute("emp", userService.findAllemp());
        return "dashboard";
    }


    /* @RequestParam必须带有参数,也就是说你直接输入localhost:8080/list 会报错 不会执行方法 只能输入localhost:8080/list?parentId=? 才能执行相应的方法*/
    @GetMapping(value = "/login")
    public String login(User user,
                        String username,
                        String password,
                        ModelMap modelMap, HttpSession session/*, ModelAndView modelAndView*/) {


        System.out.println(userService.findAllemp());
        username = user.getUsername();
        password = user.getPassword();
        User u1 = userService.findByiP(username, password);
        if (u1 != null) {
            session.setAttribute("loginUser", u1);
            return "redirect:/main";

        } else {
            modelMap.addAttribute("msg", "用户名密码错误");
            return "login";
        }


    }

   /* @RequestMapping("/testTH")
    @ResponseBody
    public int testTh(int i) {
        System.out.println(i);
        return i;
    }*/

}
