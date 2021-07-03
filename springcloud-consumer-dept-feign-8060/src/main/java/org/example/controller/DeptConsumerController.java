package org.example.controller;

import org.example.pojo.Dept;
import org.example.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;
//    //Ribon,这里的地址应该是一个变量,通过服务名来访问
//    private static final String REST_URL_PREFIX="http://springcloud-provider-dept/";
//    @RequestMapping("/consumer/dept/add")
//    public void add(Dept dept){
//        restTemplate.getForObject(REST_URL_PREFIX+"add",null,dept);
//    }
//    @RequestMapping("/consumer/dept/get/{deptno}")
//    public Dept get(@PathVariable("deptno") Integer deptno){
//        return restTemplate.getForObject(REST_URL_PREFIX+"queryById/"+deptno,Dept.class);
//    }
//    @RequestMapping("/consumer/dept/queryAll")
//    public List<Dept> list(){
//        return restTemplate.getForObject(REST_URL_PREFIX+"queryAll",List.class);
//    }
    @Autowired
    private DeptClientService service=null;
    @RequestMapping("/consumer/dept/add")
    public void add(Dept dept){
        this.service.addDept(dept);
    }
    @RequestMapping("/consumer/dept/get/{deptno}")
    public Dept get(@PathVariable("deptno")Integer deptno){
        return this.service.queryById(deptno);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.service.queryAll();
    }
}
