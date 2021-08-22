package com.beatex.climbingDiary.model;

public enum Rate {

    a("III", 1),
    b("III+", 2),
    c("IV-", 3),
    d("IV", 4),
    e("IV+", 5),
    f("V-", 6),
    g("V", 7),
    h("V+", 8),
    i("VI-", 9),
    j("VI", 10),
    k("VI.1-", 11),
    l("VI.1", 12),
    m("VI.1+", 13),
    n("VI.2-", 14),
    o("VI.2", 15);

    private String rateName;
    private int points;

    Rate(String rateName, int points) {
        this.rateName = rateName;
        this.points = points;
    }

    public String getRateName() {
        return rateName;
    }

    public void setRateName(String rateName) {
        this.rateName = rateName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
