package com.lionlemon.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean isHappy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> list;
    private Dog dog;
    private Cat cat;

    public Person() {
    }

    public Person(String name, Integer age, Boolean isHappy, Date birth, Map<String, Object> maps, List<Object> list, Dog dog, Cat cat) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.birth = birth;
        this.maps = maps;
        this.list = list;
        this.dog = dog;
        this.cat = cat;
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

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
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
                ", cat=" + cat +
                '}';
    }
}
