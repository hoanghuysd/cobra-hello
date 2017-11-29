SELECT new org.cobra.persistence.dto.ArticleDto(art.articleId, art.category)
FROM Article as art
WHERE art.articleId IN :articleId
ORDER BY art.articleId