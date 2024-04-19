package com.lyphuc.eCommerce.specification;

import com.lyphuc.eCommerce.specification.SpecificationDto;
import com.lyphuc.eCommerce.specification.Specification;

import static com.lyphuc.eCommerce.product.ProductMapper.mapToProduct;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProductDto;

public class SpecificationMapper {
    public static SpecificationDto mapToSpecificationDto(Specification specification){
        SpecificationDto specificationDto = SpecificationDto.builder()
                .specId(specification.getSpecId())
                .specValue(specification.getSpecValue())
                .specName(specification.getSpecName())
                .product(mapToProductDto(specification.getProduct()))
                .build();
        return specificationDto;
    }
    public static Specification mapToSpecification(SpecificationDto specificationDto){
        Specification specification = Specification.builder()
                .specId(specificationDto.getSpecId())
                .specValue(specificationDto.getSpecValue())
                .specName(specificationDto.getSpecName())
                .product(mapToProduct(specificationDto.getProduct()))
                .build();
        return specification;
    }
}
