package org.cobra.persistence.repository;

import org.cobra.app.common.fileloader.CommonFileLoader;
import org.cobra.app.common.jdbc.CbEntityManager;
import org.cobra.persistence.dto.ArticleDto;
import org.cobra.persistence.model.Article;
import org.cobra.web.error.exception.CbIOFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.*;

@Transactional
@Repository
public class ArticleDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDAO.class);

    @Autowired
    private CbEntityManager cbEntityManager;

    @Autowired
    private CommonFileLoader commonFileLoader;

    public Article getArticleById(int articleId) {
        return cbEntityManager.find(Article.class, articleId);
    }

    public List<ArticleDto> getAllArticles() throws CbIOFileException {
        String path = "sql/selectAllArticle.sql";
        Map<String, Object> params = new HashMap<>();
        Set<Integer> param = new HashSet<Integer>();
        params.put("abc","test");
        param.add(1);
        param.add(2);
        params.put("articleId",param );
        return cbEntityManager.createQuery(ArticleDto.class,path,params).getResultList();
    }

    public void addArticle(Article article) {
        cbEntityManager.persist(article);
    }

    public void updateArticle(Article article) {
        Article artcl = getArticleById(article.getArticleId());
        artcl.setTitle(article.getTitle());
        artcl.setCategory(article.getCategory());
        cbEntityManager.flush();
    }

    public void deleteArticle(int articleId) {
        cbEntityManager.remove(getArticleById(articleId));
    }

    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = :title and atcl.category = :catelory";
        Query query = cbEntityManager.createQuery(hql);

        query.setParameter("catelory", category);
        query.setParameter("title", title);

        int count = query.getResultList().size();
        return count > 0 ? true : false;
    }
}
