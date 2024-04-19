package com.lyphuc.eCommerce.specification;

import com.lyphuc.eCommerce.specification.SpecificationDto;

import java.util.List;

public interface SpecificationService {
    List<SpecificationDto> findAll();
    SpecificationDto findById(int id);
    void save(SpecificationDto specificationDto);
    void deleteById(int id);
}
