package com.luv2code.com.demo.rest;

import com.luv2code.com.demo.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class DemoRestController {


    @GetMapping("hello")
    public String sayHello(){
        return "Hello world from RestController";
    }
}
