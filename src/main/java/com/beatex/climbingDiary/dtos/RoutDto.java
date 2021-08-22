package com.beatex.climbingDiary.dtos;
import com.beatex.climbingDiary.model.Region;


public class RoutDto {

    private String name;
    private Region region;
    private String rateName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    private RoutDto(Builder builder){
        name = builder.name;
        region = builder.region;
        rateName = builder.rateName;

    }

    public RoutDto() {
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

        public Builder rateName(String rateName){
            this.rateName = rateName;
            return this;
        }

        public RoutDto build(){
            return new RoutDto(this);
        }
    }
}
