package com.lyphuc.eCommerce.productImage;

import com.lyphuc.eCommerce.productImage.ProductImageRepository;
import com.lyphuc.eCommerce.product.ProductRepository;
import com.lyphuc.eCommerce.productImage.ProductImageDto;
import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.productImage.ProductImage;
import com.lyphuc.eCommerce.productImage.ProductImageService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.productImage.ProductImageMapper.mapToProductImage;
import static com.lyphuc.eCommerce.productImage.ProductImageMapper.mapToProductImageDto;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    private ProductImageRepository productImageRepository;
    private ProductRepository productRepository;
    @Autowired
    public ProductImageServiceImpl(ProductImageRepository productImageRepository, ProductRepository productRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductImageDto> findAll() {
        List<ProductImage> productImages = productImageRepository.findAll();
        return getListProductImageDto(productImages);
    }

    private static List<ProductImageDto> getListProductImageDto(List<ProductImage> productImages) {
        return productImages.stream().map(productImage -> mapToProductImageDto(productImage)).collect(Collectors.toList());
    }

    @Override
    public ProductImageDto findById(int id) {
        Optional<ProductImage> result = productImageRepository.findById(id);
        ProductImage productImage = null;
        if(result.isPresent()){
            productImage = result.get();
        }else{
            throw new RuntimeException("Did not find product image id: "+id);
        }
        return mapToProductImageDto(productImage);
    }


    @Override
    public void save(int productId, ProductImageDto productImageDto) {
        Product product = productRepository.findById(productId).get();
        ProductImage productImage = mapToProductImage(productImageDto);
        productImage.setProduct(product);
        productImageRepository.save(productImage);
    }

    @Override
    public void deleteById(int id) {
        productImageRepository.deleteById(id);
    }

}
