package com.korea.testBack.dto.response.article;

import com.korea.testBack.common.ResponseCode;
import com.korea.testBack.common.ResponseMessage;
import com.korea.testBack.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostArticleResponseDto extends ResponseDto{
    private PostArticleResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<PostArticleResponseDto> success(){
        PostArticleResponseDto responseBody = new PostArticleResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
