package com.yama.encurtador_url.server;

import com.yama.encurtador_url.model.Url;
import com.yama.encurtador_url.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;
    @Value("${app.url.base}")
    private String baseUrl;

    public String encurtarUrl(String urlOriginal){
        Url url = new Url();
        url.setOriginalUrl(urlOriginal);
        repository.save(url);

        //gera Identificador curto
        String codigo = Base62.encode(url.getId());
        url.setEncurtaUrl(codigo);
        repository.save(url);

        return baseUrl + codigo;
    }

    public String buscarUrlOriginal(String codigo){
        Url url = repository.findByEncurtaUrl(codigo)
                .orElseThrow(() -> new RuntimeException("Link nao encontrado"));
        return url.getOriginalUrl();
    }

    public List<Url> buscarTodas() {
        return repository.findAll();
    }
}
