package com.beatex.climbingDiary.model;


public enum Region {
    SLONECZNE_SKALY("Słoneczne_skały"),
    DOLINA_BOLECHOWICE("Dolina_Bolechowicka"),
    DOLINA_KOBYLANSKA("Dolina_Kobylańska"),
    DOLINA_BEDKOWSKA("Dolina_Będkowska");

    private String regionName;

    Region(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
