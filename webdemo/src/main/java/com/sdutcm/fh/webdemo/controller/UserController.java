package com.sdutcm.fh.webdemo.controller;


import com.sdutcm.fh.webdemo.entities.Employee;
import com.sdutcm.fh.webdemo.entities.User;
import com.sdutcm.fh.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/more")
    public String fet() {
        return "more";
    }

    /* @GetMapping("/user")
     public List<Department> findAlldep() {

         return userService.findAlldep();
     }*/

   /* @GetMapping("/emplyee")
    public void AllEm() {
        System.out.println(1);
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("emp", userService.findAllemp());
    }*/



    /*  @GetMapping("getUser/{id}") *//*http://localhost:8080/getUser/1*//*
    @ResponseBody
    public String GetUser(@PathVariable("id") int id) {
        return userService.findByID(id).toString();

    }
*/

    @GetMapping(value = "/add")
    public String login(Employee employee) {
        System.out.println("hello");
        System.out.println(employee.toString());
        userService.addUser(employee);
        return "redirect:/main";  //转发
    }

    @GetMapping(value = "/del")
    public String del(int i) {
        userService.deleteByID(i);
        return "redirect:/main";


    }

}


