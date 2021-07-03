package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    void addDept(Dept dept);
    Dept queryById(Integer deptno);
    List<Dept> queryAll();
}
