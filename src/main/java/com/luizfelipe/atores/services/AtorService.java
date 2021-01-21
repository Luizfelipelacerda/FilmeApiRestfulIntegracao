package com.luizfelipe.atores.services;

import com.luizfelipe.atores.model.DTO.AtorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private WebClient webClient;

    public List<AtorDTO> getAtores() {
/*
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<AtorDTO>> exchange = restTemplate.exchange("http://localhost:8080/api/v1/filme/",
                HttpMethod.GET,null, new ParameterizedTypeReference<>() {});
        return exchange.getBody();
*/
        Flux<AtorDTO> fluxAtores = this.webClient
                .get()
                .uri("/api/v1/filme")
                .retrieve()
                .bodyToFlux(AtorDTO.class);

        //BLOCKING
        return fluxAtores.collectList().block();

    }

    public void addAtor(AtorDTO atorDto) {
        AtorDTO block = this.webClient
                .post()
                .uri("/api/v1/filme")
                .body(Mono.just(atorDto), AtorDTO.class)
                .retrieve()
                .bodyToMono(AtorDTO.class)
                .block();

        if(block != null){
            return;
        }
    }

    public void editAtor(AtorDTO atorDTO) {
        this.webClient
                .put()
                .uri("/api/v1/filme/"+atorDTO.getId())
                .body(Mono.just(atorDTO), AtorDTO.class)
                .retrieve()
                .bodyToMono(AtorDTO.class).block();
    }

    public void deleteAtorById(Integer idAtor) {
        this.webClient
                .delete()
                .uri("/api/v1/filme/"+idAtor)
                .retrieve()
                .bodyToMono(void.class)
                .block();
    }
}
