package com.korea.testBack.dto.request.article;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
