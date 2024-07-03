package com.korea.testBack.service;

import com.korea.testBack.dto.request.article.PostArticleRequestDto;
import com.korea.testBack.dto.response.article.DeleteArticleResponseDto;
import com.korea.testBack.dto.response.article.GetAllArticleResponseDto;
import com.korea.testBack.dto.response.article.GetArticleResponseDto;
import com.korea.testBack.dto.response.article.PostArticleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    ResponseEntity<? super GetArticleResponseDto> getArticle(Long ArticleId);
    ResponseEntity<? super PostArticleResponseDto> postArticle(PostArticleRequestDto dto);
    ResponseEntity<? super DeleteArticleResponseDto> deleteArticle(Long ArticleId);
    ResponseEntity<? super GetAllArticleResponseDto> getAllArticle();
}
