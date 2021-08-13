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

    private String name;
    private int points;

    Rate(String name, int points) {
        this.name = name;
        this.points = points;
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
}
