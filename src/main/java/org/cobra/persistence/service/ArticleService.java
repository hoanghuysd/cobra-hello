package org.cobra.persistence.service;

import org.cobra.app.common.jdbc.CbEntityManager;
import org.cobra.persistence.dto.ArticleDto;
import org.cobra.web.error.exception.CbIOFileException;
import org.cobra.persistence.model.Article;
import org.cobra.persistence.repository.ArticleDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ArticleService implements IArticleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleDAO articleDAO;

    @Autowired
    private CbEntityManager cbEntityManager;

    @Override
    public Article getArticleById(int articleId) {
        Article obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    @Override
    public List<ArticleDto> getAllArticles() throws CbIOFileException {;
        List<ArticleDto>  list = articleDAO.getAllArticles();
        return list;
    }

    @Override
    public synchronized boolean addArticle(Article article) {
        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            articleDAO.addArticle(article);
            return true;
        }
    }

    @Override
    public void updateArticle(Article article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}