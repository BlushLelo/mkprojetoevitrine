package com.projeto.catalog.gateway;

import com.projeto.catalog.gateway.domain.ProductDatabaseDomain;
import com.projeto.catalog.gateway.repository.ProductExtentedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FindProductsBySellerIdGatewayImpl implements FindProductsBySellerIdGateway {

    private final ProductExtentedRepository productRepository;

    @Override
    public List<ProductDatabaseDomain> execute(int sellerId) {

        return productRepository.findBySellerId(sellerId);
        
    }
}
