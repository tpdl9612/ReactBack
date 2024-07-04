package com.korea.testBack.dto.request.article;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchArticleRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
