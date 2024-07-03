package com.korea.testBack.dto.response.article;

import com.korea.testBack.common.ResponseCode;
import com.korea.testBack.common.ResponseMessage;
import com.korea.testBack.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class DeleteArticleResponseDto extends ResponseDto{
    private DeleteArticleResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}

    public static ResponseEntity<DeleteArticleResponseDto> success(){
        DeleteArticleResponseDto result = new DeleteArticleResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistedQuestion(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_ARTICLE,ResponseMessage.NOT_EXISTED_ARTICLE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
