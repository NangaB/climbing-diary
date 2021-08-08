package com.beatex.climbingDiary.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rate;

    @Enumerated(EnumType.STRING)
    private Region region;

    // tego nie było w pierwszej wersji


    // w 3-ciej też nie będzie
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "climber_rout",
//    joinColumns = @JoinColumn(name = "rout_id"),
//    inverseJoinColumns = @JoinColumn(name = "climber_id"))
//    private List<Climber> climbers = new ArrayList<>();

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

//    public List<Climber> getClimbers() {
//        return climbers;
//    }
//
//    public void setClimbers(List<Climber> climbers) {
//        this.climbers = climbers;
//    }
}
