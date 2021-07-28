package com.beatex.climbingDiary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Climber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int age;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rout> routList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Rout> getRoutList() {
        return routList;
    }

    public void setRoutList(List<Rout> routList) {
        this.routList = routList;
    }
}
