package org.cobra.persistence.repository;



import org.cobra.persistence.model.Article;

import java.util.List;

public interface IArticleDAO {
     <T> List<T> getAllArticles(Class<T> clazz) ;
    Article getArticleById(int articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
}
