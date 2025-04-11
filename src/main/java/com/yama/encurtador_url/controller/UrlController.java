package com.yama.encurtador_url.controller;

import com.yama.encurtador_url.dto.UrlDto;
import com.yama.encurtador_url.model.Url;
import com.yama.encurtador_url.server.UrlService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<String> encurtar(@RequestBody UrlDto dto){
        String urlCurta = urlService.encurtarUrl(dto.originalUrl());
        return ResponseEntity.ok(urlCurta);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Void> urlOriginal (@PathVariable String codigo, HttpServletResponse response) throws IOException {
        String urlOriginal = urlService.buscarUrlOriginal(codigo);
        response.sendRedirect(urlOriginal);
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).build();
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Url>> listarTodosUrl(){
        return ResponseEntity.ok(urlService.buscarTodas());
    }
}
