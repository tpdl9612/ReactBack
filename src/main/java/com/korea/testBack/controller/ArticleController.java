package com.korea.testBack.controller;

import com.korea.testBack.dto.request.article.PatchArticleRequestDto;
import com.korea.testBack.dto.request.article.PostArticleRequestDto;
import com.korea.testBack.dto.response.article.*;
import com.korea.testBack.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/article/write")
    public ResponseEntity<? super PostArticleResponseDto> postArticle(
            @RequestBody @Valid PostArticleRequestDto requestBody
    ) {
        ResponseEntity<? super PostArticleResponseDto> response = articleService.postArticle(requestBody);
        return response;
    }

    @GetMapping("/")
    public ResponseEntity<? super GetAllArticleResponseDto> getAllArticle() {
        ResponseEntity<? super GetAllArticleResponseDto> response = articleService.getAllArticle();
        return response;
    }

    @GetMapping("/article/detail/{articleId}")
    public ResponseEntity<? super GetArticleResponseDto> getArticle(
            @PathVariable("articleId") Long articleId
    ) {
        ResponseEntity<? super GetArticleResponseDto> response = articleService.getArticle(articleId);
        return response;
    }

    @DeleteMapping("/article/delete/{articleId}")
    public ResponseEntity<? super DeleteArticleResponseDto> deleteArticle(
            @PathVariable("articleId") Long articleId
    ) {
        ResponseEntity<? super DeleteArticleResponseDto> response = articleService.deleteArticle(articleId);
        return response;
    }

    @PatchMapping("/article/update/{articleId}")
    public ResponseEntity<? super PatchArticleResponseDto> updateArticle (
            @RequestBody @Valid PatchArticleRequestDto requestBody,
            @PathVariable("articleId") Long articleId
    ) {
        ResponseEntity<? super PatchArticleResponseDto> response = articleService.patchArticle(requestBody, articleId);
        return response;
    }
}
