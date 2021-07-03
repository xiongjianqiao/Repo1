package org.example.service;

import org.example.mapper.DeptMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;
    public void addDept(Dept dept){
        deptMapper.addDept(dept);
    }
    public Dept queryById(Integer deptno){
        return deptMapper.queryById(deptno);
    }
    public List<Dept> queryAll(){
        return deptMapper.queryAll();
    }
}
