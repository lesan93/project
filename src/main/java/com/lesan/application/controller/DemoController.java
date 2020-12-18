package com.lesan.application.controller;

import com.lesan.application.bean.Person;
import com.lesan.application.bean.User;
import com.lesan.application.dao.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/hello")
@Api(value = "desc of class")
public class DemoController implements ApplicationContextAware {
    @Autowired
    private UserMapper userMapper;

    private ApplicationContext applicationContext;

    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(value = "/nihao",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public User hello(String name){
        System.out.println(applicationContext);
        User user = userMapper.getUser(1);
        System.out.println(user.getPersonList());
        return user;
    }

    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(User user, MultipartFile file) {
        System.out.println(user.toString());
        if (file!=null) {
            System.out.println(file.getOriginalFilename());
        }
        /*String name = user.getPersonList().get(0).getName();
        System.out.println(user.getPersonList().size());*/
        //System.out.println(user.getPersonList().get(0).getName());
        return user;
    }

    @ApiOperation(value = "desc of method", notes = "")
    @RequestMapping(value = "/demo",method = RequestMethod.POST)
    @ResponseBody
    public User demo(@RequestBody User user) {
        System.out.println( user.toString());
        /*String name = user.getPersonList().get(0).getName();
        System.out.println(user.getPersonList().size());*/
        return user;
    }

    @PostMapping(path = "/demo1")
    @ResponseBody
    public String demo1(Person person,String id) {
        System.out.println(person);
        System.out.println(id);
        return "hello demo";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
