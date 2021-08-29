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

    private int points;

    @OneToMany(mappedBy = "climber", cascade = CascadeType.ALL)
    private List<RoutClimber> routs = new ArrayList<>();

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<RoutClimber> getRouts() {
        return routs;
    }

    public void setRouts(List<RoutClimber> routs) {
        this.routs = routs;
    }

    public void addRout(RoutClimber rout){
        routs.add(rout);
        rout.setClimber(this);
    }
}
