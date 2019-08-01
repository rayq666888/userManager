package com.bjsxt.pojo;


import java.util.Objects;

/**
 * @author Administrator
 * @date 2019/7/28 09:41:34
 * @description
 */
public class User {
    private int uid;
    private String uname;
    private String pwd;
    private String  sex ;
    private int  age;
    private String birth;

    public User() {
    }

    public User(int uid, String uname, String pwd, String sex, int age, String birth) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getUid() {
        return uid;
    }

    public String getUname() {
        return uname;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){ return true;}
        if (o == null || getClass() != o.getClass()){ return false;}
        User user = (User) o;
        return uid == user.uid &&
                age == user.age &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(pwd, user.pwd) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(birth, user.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, pwd, sex, age, birth);
    }
}
