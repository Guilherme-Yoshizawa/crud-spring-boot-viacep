package com.example.crud.service;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate;
    private final ProductRepository productRepository;

public ViaCepService(RestTemplate restTemplate, ProductRepository ProductRepository){
    this.restTemplate = restTemplate;
    this.productRepository = ProductRepository;
}

public Boolean checkDistribution(String cep, String productId){
    String url = "https://viacep.com.br/ws/" + cep + "/json/";

    Map response = restTemplate.getForObject(url, Map.class);
    String cidade = (String) response.get("localidade");
    Optional<Product> optionalProduct = productRepository.findById(productId);

    if (optionalProduct.isEmpty()){
        return false;
    }
    Product product = optionalProduct.get();
    return cidade.equalsIgnoreCase(product.getDistributionCenter());
    }
}
