package com.korea.testBack.dto.response.article;

import com.korea.testBack.common.ResponseCode;
import com.korea.testBack.common.ResponseMessage;
import com.korea.testBack.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PatchArticleResponseDto extends ResponseDto {
    private PatchArticleResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<PatchArticleResponseDto> success(){
        PatchArticleResponseDto responseBody = new PatchArticleResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistArticle(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_ARTICLE,ResponseMessage.NOT_EXISTED_ARTICLE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
