package com.beatex.climbingDiary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RoutClimber{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String rate;

    @Enumerated(EnumType.STRING)
    private Region region;

    private String info;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "climber_rout",
            joinColumns = @JoinColumn(name = "routClimber_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id"))
    private List<Climber> climber = new ArrayList<>();

    public RoutClimber() {
    }

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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
