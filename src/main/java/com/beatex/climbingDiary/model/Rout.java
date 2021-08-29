package com.beatex.climbingDiary.model;

import javax.persistence.*;

@Entity
public class Rout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Enumerated(EnumType.STRING)
    private Rate rate;

    public Rout() {
    }

    private Rout(Builder builder){
        name = builder.name;
        region = builder.region;
        rate = Rate.valueOf(builder.rateName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public static class Builder{

        private String name;
        private Region region;
        private String rateName;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder region(Region region){
            this.region = region;
            return this;
        }

        public Builder rateName(String rate){
            this.rateName = rate;
            return this;
        }

        public Rout build(){
            return new Rout(this);
        }


    }
}
