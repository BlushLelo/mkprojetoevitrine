package com.projeto.catalog.gateway;

import com.projeto.catalog.commons.Translator;
import com.projeto.catalog.domain.Image;
import com.projeto.catalog.domain.Product;
import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import com.projeto.catalog.gateway.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RegisterProductGatewayImpl implements RegisterProductGateway {

    private final ProductRepository productRepository;

    @Override
    public ProductDatabaseDomain execute(int sellerId, Product product) {
        List<String> listaDeImagens = product.getImages().stream().map(Image::getLink).collect(Collectors.toList());
        ProductDatabaseDomain productDb = Translator.translate(product, ProductDatabaseDomain.class);
        productDb.setImages(listaDeImagens);
        productDb.setSellerId(sellerId);
        return productRepository.save(productDb);
    }
}
