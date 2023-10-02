package bts.sio.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="titre")
    private String titre;

    @Column(name="contenu")
    private String contenu;

    @Column(name="auteur")
    private String auteur;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;

}
