package com.yama.encurtador_url.repository;

import com.yama.encurtador_url.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByEncurtaUrl(String codigo);
}
