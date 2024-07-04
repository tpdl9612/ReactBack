package com.korea.testBack.service.implement;

import com.korea.testBack.dto.request.article.PatchArticleRequestDto;
import com.korea.testBack.dto.request.article.PostArticleRequestDto;
import com.korea.testBack.dto.response.ResponseDto;
import com.korea.testBack.dto.response.article.*;
import com.korea.testBack.entity.ArticleEntity;
import com.korea.testBack.repository.ArticleRepository;
import com.korea.testBack.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImplement implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ResponseEntity<? super GetArticleResponseDto> getArticle(Long ArticleId) {
        ArticleEntity articleEntity = null;
        try {
            articleEntity = articleRepository.getArticle(ArticleId);
            if (articleEntity == null) return GetArticleResponseDto.notExistArticle();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetArticleResponseDto.success(articleEntity);
    }

    @Override
    public ResponseEntity<? super PostArticleResponseDto> postArticle(PostArticleRequestDto dto) {
        try {
            ArticleEntity articleEntity = new ArticleEntity(dto);

            articleRepository.save(articleEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostArticleResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteArticleResponseDto> deleteArticle(Long ArticleId) {
        try {
            ArticleEntity articleEntity = articleRepository.findByArticleId(ArticleId);
            if (articleEntity == null) return DeleteArticleResponseDto.notExistedQuestion();

            articleRepository.delete(articleEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteArticleResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAllArticleResponseDto> getAllArticle() {
        List<ArticleEntity> articles = null;
        try {
            articles = articleRepository.findAll();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetAllArticleResponseDto.success(articles);
    }
    @Override
    public ResponseEntity<? super PatchArticleResponseDto> patchArticle(PatchArticleRequestDto dto, Long ArticleId) {
        try {
            ArticleEntity articleEntity = articleRepository.findByArticleId(ArticleId);
            if (articleEntity == null) return PatchArticleResponseDto.notExistArticle();

            articleEntity.patchArticle(dto);
            articleRepository.save(articleEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchArticleResponseDto.success();
    }
}
