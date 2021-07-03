package org.example.pojo;


import java.io.Serializable;
public class Dept implements Serializable {
    private int deptno;
    private String name;
    private String db_source;

    public Dept() {
    }

    public Dept(String name) {
        this.name = name;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }
}
