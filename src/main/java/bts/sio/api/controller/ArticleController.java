package bts.sio.api.controller;

import bts.sio.api.model.Article;
import bts.sio.api.model.Athlete;
import bts.sio.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
            String contenu = article.getContenu();
            if(contenu != null) {
                currentArticle.setContenu(contenu);;
            }
            String auteur = article.getAuteur();
            if(auteur != null) {
                currentArticle.setAuteur(auteur);;
            }
            Athlete athlete = article.getAthlete();
            if(athlete != null) {
                currentArticle.setAthlete(athlete);;
            }

            articleService.saveArticle(currentArticle);
            return currentArticle;
        } else {
            return null;
        }
    }
}
