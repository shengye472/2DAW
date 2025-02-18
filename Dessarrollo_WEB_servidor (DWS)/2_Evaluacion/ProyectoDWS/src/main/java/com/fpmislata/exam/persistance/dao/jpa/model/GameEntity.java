package com.fpmislata.exam.persistance.dao.jpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "games")
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "game_code")
    private String gameCode;
    private String title;
    @Column(name = "release_year")
    private String releaseYear;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorEntity director;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "games_characters",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<CharacterGameEntity> characterGames;
}
