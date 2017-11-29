package org.cobra.persistence.service;



import org.cobra.persistence.dto.ArticleDto;
import org.cobra.web.error.exception.CbIOFileException;
import org.cobra.persistence.model.Article;

import java.util.List;

public interface IArticleService {
    List<ArticleDto> getAllArticles() throws CbIOFileException;
    Article getArticleById(int articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(int articleId);
}
