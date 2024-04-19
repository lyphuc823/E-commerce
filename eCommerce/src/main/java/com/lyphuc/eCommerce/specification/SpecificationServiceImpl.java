package com.lyphuc.eCommerce.specification;

import com.lyphuc.eCommerce.specification.SpecificationRepository;
import com.lyphuc.eCommerce.specification.SpecificationDto;
import com.lyphuc.eCommerce.specification.Specification;
import com.lyphuc.eCommerce.specification.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.specification.SpecificationMapper.mapToSpecification;
import static com.lyphuc.eCommerce.specification.SpecificationMapper.mapToSpecificationDto;

@Service
public class SpecificationServiceImpl implements SpecificationService {
    private SpecificationRepository specificationRepository;
    @Autowired
    public SpecificationServiceImpl(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    @Override
    public List<SpecificationDto> findAll() {
        List<Specification> specifications = specificationRepository.findAll();
        return getSpecificationDtoList(specifications);
    }

    private static List<SpecificationDto> getSpecificationDtoList(List<Specification> specifications) {
        return specifications.stream().map(specification -> mapToSpecificationDto(specification)).collect(Collectors.toList());
    }

    @Override
    public SpecificationDto findById(int id) {
        Optional<Specification> result = specificationRepository.findById(id);
        Specification specification = null;
        if(result.isPresent()){
            specification = result.get();
        }else {
            throw new RuntimeException("Did not find specification id: "+id);
        }
        return mapToSpecificationDto(specification);
    }

    @Override
    public void save(SpecificationDto specificationDto) {
        Specification specification = mapToSpecification(specificationDto);
        specificationRepository.save(specification);
    }

    @Override
    public void deleteById(int id) {
        specificationRepository.deleteById(id);
    }

}
