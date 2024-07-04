package com.nirajaky.springbootdemo.controller;

import com.nirajaky.springbootdemo.model.User;
import com.nirajaky.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {

    /*
        @ResponseBody tells the Controller that the data needs to be sent back
        as JSON or XML etc. format. It should not search for any JSP or thymeleaf
        or index file to return.

        @ResponseBody is commonly used in RESTful Web Services.
        - Returned body is serialized into desired format.
        - It is a Web Binding annotations
        - For JSON, Spring Boot uses Jackson library by default
     */

    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String getHome() {
        return "Home Controller New 2";
    }

    @GetMapping("/user")
    public User getUser() {
        return new User(1, "Niraj", "Patna");
    }

    /*
        @PathVariable is a powerful and flexible way to extract values
        from the URI in Spring Boot applications.
    */
    @GetMapping("/{id}/{id2}")
    public String getPathVariable(@PathVariable int id, @PathVariable("id2") String name) {
        return "Path Variables are = " + id + " : " + name;
    }

    /*
        @PathVariable is mandatory and @RequestParam is optional

        @RequestParams takes input as key value pair separated by & and starts with ?
    */
    @GetMapping("/data")
    public String getRequestParams(@RequestParam String id,
                                   @RequestParam(value = "email", required = false, defaultValue = "abc@xyz.com") String emailId) {
        return "Your ID is : " + id + " and email is : " + emailId;
    }
}
