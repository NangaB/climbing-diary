package com.beatex.climbingDiary.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role")
public enum Role {

    USER(1, "USER"),
    ADMIN(2,"ADMIN"),
    MODERATOR(3,"MODERATOR");

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;
    private String role;


    Role(int roleId, String role) {
        this.roleId = roleId;
        this.role = role;
    }

    Role() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
