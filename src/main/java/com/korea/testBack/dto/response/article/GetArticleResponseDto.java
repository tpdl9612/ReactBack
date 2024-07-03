package com.korea.testBack.dto.response.article;

import com.korea.testBack.common.ResponseCode;
import com.korea.testBack.common.ResponseMessage;
import com.korea.testBack.dto.response.ResponseDto;
import com.korea.testBack.entity.ArticleEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Getter
public class GetArticleResponseDto extends ResponseDto {
    private Long articleId;
    private String title;
    private String content;
    private LocalDate createdAt;

    public GetArticleResponseDto(ArticleEntity articleEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.articleId = articleEntity.getArticleId();
        this.title= articleEntity.getTitle();;
        this.content= articleEntity.getContent();
        this.createdAt=articleEntity.getCreatedAt();
    }

    public static ResponseEntity<GetArticleResponseDto> success(ArticleEntity articleEntity){
        GetArticleResponseDto responseBody = new GetArticleResponseDto(articleEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistArticle(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_ARTICLE,ResponseMessage.NOT_EXISTED_ARTICLE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
