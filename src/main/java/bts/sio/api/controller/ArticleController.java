package bts.sio.api.controller;

import bts.sio.api.model.*;
import bts.sio.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public Article createArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable("id") final Long id) {
        Optional<Article> article = articleService.getArticle(id);
        if(article.isPresent()) {
            return article.get();
        } else {
            return null;
        }
    }

    @GetMapping("/articles")
    public Iterable<Article> getArticles() {
        return articleService.getArticles();
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable("id") final Long id) {
        articleService.deleteArticle(id);
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable("id") final Long id, @RequestBody Article article) {
        Optional<Article> e = articleService.getArticle(id);
        if(e.isPresent()) {
            Article currentArticle = e.get();

            String titre = article.getTitre();
            if(titre != null) {
                currentArticle.setTitre(titre);
            }
            String soustitre = article.getSoustitre();
            if(soustitre != null) {
                currentArticle.setSoustitre(soustitre);
            }
            String contenu = article.getContenu();
            if(contenu != null) {
                currentArticle.setContenu(contenu);;
            }
            String image = article.getImage();
            if(image != null) {
                currentArticle.setImage(image);
            }
            LocalDate date = article.getDate();
            if(date != null) {
                currentArticle.setDate(date);
            }
            LocalTime heure = article.getHeure();
            if(heure != null) {
                currentArticle.setHeure(heure);;
            }
            Athlete athlete = article.getAthlete();
            if(athlete != null) {
                currentArticle.setAthlete(athlete);;
            }
            Pays pays = article.getPays();
            if(pays != null) {
                currentArticle.setPays(pays);;
            }
            Auteur auteur = article.getAuteur();
            if(auteur != null) {
                currentArticle.setAuteur(auteur);;
            }

            articleService.saveArticle(currentArticle);
            return currentArticle;
        } else {
            return null;
        }
    }
}
