package org.example.service;

import feign.hystrix.FallbackFactory;
import org.example.pojo.Dept;
import org.springframework.stereotype.Component;

import java.util.List;
//服务降级
@Component
public class DeptClientServiceFallBack implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Integer deptno) {
                Dept dept=new Dept();
                dept.setDeptno(deptno);
                dept.setName("deptno=>"+deptno+"没有对应的信息,客户端提供了降级的信息,这个服务已经被关闭");
                dept.setDb_source("no this database in MySql");
                return dept;
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public void addDept(Dept dept) {

            }
        };
    }
}
