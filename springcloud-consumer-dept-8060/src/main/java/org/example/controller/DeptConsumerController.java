package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
public class DeptConsumerController {
    //Ribon,这里的地址应该是一个变量,通过服务名来访问
//    private static final String REST_URL_PREFIX="http://springcloud-provider-dept/";
//    @Autowired
//    private DeptClientService service;
//    @RequestMapping("/consumer/dept/add")
//    public void add(Dept dept){
//        this.service.addDept(dept);
//    }
//    @RequestMapping("/consumer/dept/get/{deptno}")
//    public Dept get(Integer deptno){
//        return this.service.queryById(deptno);
//    }
//    @RequestMapping("/consumer/dept/queryAll")
//    public List<Dept> list(){
//        return this.service.queryAll();
//    }
    @Autowired
    private RestTemplate restTemplate;
    //Ribon,这里的地址应该是一个变量,通过服务名来访问
    private static final String REST_URL_PREFIX="http://springcloud-provider-dept/";
    @RequestMapping("/consumer/dept/add")
    public void add(Dept dept){
        restTemplate.getForObject(REST_URL_PREFIX+"add",null,dept);
    }
    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno")String deptno){
        return restTemplate.getForObject(REST_URL_PREFIX+"queryById/"+deptno,Dept.class);
    }
    @RequestMapping("/consumer/dept/queryAll")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"queryAll",List.class);
    }
}
