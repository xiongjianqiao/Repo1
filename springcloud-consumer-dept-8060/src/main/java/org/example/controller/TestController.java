package org.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    //   若使用/{}来携带参数,则必须加@PathVariable
    @RequestMapping("/a/{param1}")
    public String test(@PathVariable("param1") Integer param1){
        return "param1=>"+param1;
    }
}
