package com.korea.testBack.repository;

import com.korea.testBack.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository <ArticleEntity, Long> {
    @Query(
            value=
                    //                            "B.question_id AS question_id, " +
//                            "B.title AS title, " +
//                            "B.content AS content, " +
//                            "B.userId AS userId, " +
                    "SELECT * " +
                            "FROM article AS B " +
                            "WHERE article_id = ?1 ",
            nativeQuery = true
    )
    ArticleEntity getArticle(Long ArticleId);

    ArticleEntity findByArticleId(Long ArticleId);

    List<ArticleEntity> findByUserId(String userId);
}
