package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre")
    private String titre;

    @Column(name = "soustitre", columnDefinition = "TEXT")
    private String soustitre;

    @Column(name="contenu")
    private String contenu;

    @Column(name = "image")
    private String image;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "heure")
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;
}
