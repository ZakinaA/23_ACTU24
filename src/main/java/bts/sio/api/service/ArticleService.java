package bts.sio.api.service;

import bts.sio.api.model.Article;
import bts.sio.api.model.Athlete;
import bts.sio.api.repository.ArticleRepository;
import bts.sio.api.repository.AthleteRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Optional<Article> getArticle(final Long id) {
        return articleRepository.findById(id);
    }

    public Iterable<Article> getArticles() {
        return articleRepository.findAll();
    }

    public void deleteArticle(final Long id) {
        articleRepository.deleteById(id);
    }

    public Article saveArticle(Article article) {
        Article savedArticle = articleRepository.save(article);
        return savedArticle;
    }
}
