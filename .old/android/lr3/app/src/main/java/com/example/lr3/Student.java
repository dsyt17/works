package com.example.lr3;

public class Student {

    private String name;
    private String sex;
    private String lang;
    private String ide;

    public Student(String name, String sex, String lang, String ide){
        this.name = name;
        this.sex = sex;
        this.lang = lang;
        this.ide = ide;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getLang() {
        return lang;
    }

    public String getIde() {
        return ide;
    }

}
