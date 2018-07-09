package com.byx.xiuxiu.mytest;

/**
 * Created by ASUS on 2018/7/5.
 */

public class Bean {
    private String name;
    private String sex;
    private Integer img;

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", img=" + img +
                '}';
    }

    public Bean() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public Bean(String name, String sex, Integer img) {
        this.name = name;
        this.sex = sex;
        this.img = img;
    }
}
