package com.lionlemon.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Validated
@Component
@ConfigurationProperties(prefix = "person")//指定yaml中对应的部分
public class Person implements Serializable {
    private String name;
    @Max(value = 150,message = "年龄不合法")
    @Min(value = 0,message = "年龄不能小于0")
    private Integer age;
    @Value("true")
    private Boolean isHappy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> list;
    private Dog dog;


    public Person() {
    }

    public Person(String name, Integer age, Boolean isHappy, Date birth, Map<String, Object> maps, List<Object> list, Dog dog) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.birth = birth;
        this.maps = maps;
        this.list = list;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getHappy() {
        return isHappy;
    }

    public void setHappy(Boolean happy) {
        isHappy = happy;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isHappy=" + isHappy +
                ", birth=" + birth +
                ", maps=" + maps +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }
}
