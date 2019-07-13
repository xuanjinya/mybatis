package cn.huang.mybatis.bean;

/**
 * @Author: Yaking
 * @Date: 2019-07-13 9:47
 * @Describe:
 */
public class Person {
    private Integer id;
    private String username;
    private String email;
    private String gender;

    public Person(String username, String email, String gender) {
        this.username = username;
        this.email = email;
        this.gender = gender;
    }

    private Dept dept;

    public Person() {
    }

    public Person(Integer id, String username, String email, String gender, Dept dept) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

    /*两个参数的构造方法*/

    public Person(String username, String gender) {
        this.username = username;
        this.gender = gender;
    }
}
