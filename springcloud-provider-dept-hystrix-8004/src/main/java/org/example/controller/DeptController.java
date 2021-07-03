package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/queryById/{deptno}")
    public Dept get(@PathVariable("deptno") String deptno){
        System.out.println("进入控制层---");
        Dept dept=deptService.queryById(Integer.parseInt(deptno));
        System.out.println("dept:"+dept);
        if(dept==null){
            throw new RuntimeException("deptno=>"+deptno+",不存在该用户,或者信息无法找到");
        }
        return dept;
    }
    //备选方法
    public Dept hystrixGet(@PathVariable("deptno") String deptno){
        Dept dept=new Dept();
        dept.setDeptno(Integer.parseInt(deptno));
        dept.setName("deptno=>"+deptno+"没有对应的信息,null--@Hystrix");
        dept.setDb_source("no this database in MySql");
        return dept;
    }
}
