package com.maplr.testhockeygame.domain.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private long number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "composition",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<TeamEntity> teamEntity;

    @Column(name = "is_captain")
    private boolean isCaptain;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "name")
    private String name;

    @Column(name = "position")
    private String position;

    public PlayerEntity() {
        //init
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Set<TeamEntity> getTeam() {
        if (teamEntity == null) {
            teamEntity = new HashSet<>();
        }
        return teamEntity;
    }

    public void setTeam(Set<TeamEntity> teamEntity) {
        this.teamEntity = teamEntity;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "id=" + id +
                ", number=" + number +
                ", teamEntity=" + teamEntity +
                ", isCaptain=" + isCaptain +
                ", lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
