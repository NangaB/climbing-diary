package com.beatex.climbingDiary.model;

public enum Region {

    SLONECZNE_SKALY("Słoneczne_skały"),
    DOLINA_BOLECHOWICKA("Dolina_Bolechowicka"),
    DOLINA_BRZOSKWINI("Dolina_Brzoskwini");

    private String name;

    Region(String name) {
        this.name = name;
    }
}
