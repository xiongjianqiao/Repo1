package org.example.service;


import org.example.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Component
@FeignClient(value="springcloud-provider-dept",fallbackFactory = DeptClientServiceFallBack.class)
public interface DeptClientService {
    @GetMapping("/queryById/{deptno}")
    public Dept queryById(@PathVariable("deptno") Integer deptno);
    @GetMapping("/queryAll")
    public List<Dept> queryAll();
    @GetMapping("/add")
    public void addDept(Dept dept);
}
