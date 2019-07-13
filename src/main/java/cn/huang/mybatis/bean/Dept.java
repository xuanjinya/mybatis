package cn.huang.mybatis.bean;

import java.util.List;

/**
 * @Author: Yaking
 * @Date: 2019-07-13 9:46
 * @Describe:
 */
public class Dept {

    private Integer id;
    private String departmentName;
    private List<Person> emps;

    public Dept(Integer id) {
        super();
        this.id = id;
    }

    public Dept() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Person> getEmps() {
        return emps;
    }

    public void setEmps(List<Person> emps) {
        this.emps = emps;
    }
}
