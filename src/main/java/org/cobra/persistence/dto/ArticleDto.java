package org.cobra.persistence.dto;

/**
 * Created by Hoang Huy on 11/8/2017.
 */
public class ArticleDto {
    private Integer id;
    private String category;

    public ArticleDto(Integer id, String category) {
        this.id = id;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
