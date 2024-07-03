package com.korea.testBack.dto.response.article;

import com.korea.testBack.common.ResponseCode;
import com.korea.testBack.common.ResponseMessage;
import com.korea.testBack.dto.response.ResponseDto;
import com.korea.testBack.entity.ArticleEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetAllArticleResponseDto extends ResponseDto {
    private List<ArticleEntity> articles;

    public GetAllArticleResponseDto(List<ArticleEntity> articles){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.articles = articles;
    }

    public static ResponseEntity<GetAllArticleResponseDto> success(List<ArticleEntity> articles){
        GetAllArticleResponseDto responseBody = new GetAllArticleResponseDto(articles);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
