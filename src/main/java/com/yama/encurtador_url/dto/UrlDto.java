package com.yama.encurtador_url.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlDto(
        @NotBlank
        String originalUrl,
        @NotBlank
        String encurtaUrl) {

}