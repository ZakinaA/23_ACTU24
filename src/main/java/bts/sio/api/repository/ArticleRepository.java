package bts.sio.api.repository;

import bts.sio.api.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTitreContaining(String motCle);
}
