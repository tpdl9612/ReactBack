package com.korea.testBack.entity;


import com.korea.testBack.dto.request.article.PatchArticleRequestDto;
import com.korea.testBack.dto.request.article.PostArticleRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="article")
@Table(name="article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    @CreationTimestamp
    private LocalDate createdAt;


    public ArticleEntity(PostArticleRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.createdAt = LocalDate.now();

    }
    public void patchArticle(PatchArticleRequestDto dto){
        this.title= dto.getTitle();
        this.content = dto.getContent();
    }
}
