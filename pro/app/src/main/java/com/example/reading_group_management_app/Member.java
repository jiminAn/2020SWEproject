package com.example.reading_group_management_app;

import java.util.HashMap;
import java.util.Map;

public class Member {
    private String name;
    private int sex;
    private int age;
    private String id;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Member(){

    }

    public Member(String name, int sex, int age, String id, String pwd) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.id = id;
        this.pwd = pwd;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();

        result.put("name",this.getName());
        result.put("pwd",this.getPwd());
        result.put("sex",this.getSex());
        result.put("age",this.getAge());

        return result;
    }



}
