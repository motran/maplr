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
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "coach")
    private String coach;

    @Column(name = "year", unique = true)
    private long year;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "composition",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<PlayerEntity> playerEntities;

    public TeamEntity() {
        //init entity
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public List<PlayerEntity> getPlayers() {
        return playerEntities;
    }

    public void setPlayers(List<PlayerEntity> playerEntities) {
        this.playerEntities = playerEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity teamEntity = (TeamEntity) o;
        return year == teamEntity.year && Objects.equals(coach, teamEntity.coach) && Objects.equals(playerEntities, teamEntity.playerEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coach, playerEntities, year);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", coach='" + coach + '\'' +
                ", players=" + playerEntities +
                ", year=" + year +
                '}';
    }
}
