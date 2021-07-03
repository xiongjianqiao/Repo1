package org.example.controller;

import org.example.pojo.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    //获取一些配置的信息
    @Autowired
    private DiscoveryClient client;
    @GetMapping("/add")
    public void add(Dept dept){
         deptService.addDept(dept);
    }
    @GetMapping("/queryById/{deptno}")
    public Dept queryById(@PathVariable("deptno")String deptno){
        return deptService.queryById(Integer.parseInt(deptno));
    }
    @GetMapping("/queryAll")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
    //注册进来的微服务,获取一些消息
    @RequestMapping("/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services=client.getServices();
        System.out.println("discovery=>services:"+services);
        //得到一个具体的微服务信息,通过具体的微服务id
        List<ServiceInstance> instances=client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance:instances){
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()

            );
        }
        return this.client;
    }
}
