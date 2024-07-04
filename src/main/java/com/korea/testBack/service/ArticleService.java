package com.korea.testBack.service;

import com.korea.testBack.dto.request.article.PatchArticleRequestDto;
import com.korea.testBack.dto.request.article.PostArticleRequestDto;
import com.korea.testBack.dto.response.article.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    ResponseEntity<? super GetArticleResponseDto> getArticle(Long ArticleId);
    ResponseEntity<? super PostArticleResponseDto> postArticle(PostArticleRequestDto dto);
    ResponseEntity<? super DeleteArticleResponseDto> deleteArticle(Long ArticleId);
    ResponseEntity<? super GetAllArticleResponseDto> getAllArticle();
    ResponseEntity<? super PatchArticleResponseDto> patchArticle(PatchArticleRequestDto dto, Long QuestionId);

}
