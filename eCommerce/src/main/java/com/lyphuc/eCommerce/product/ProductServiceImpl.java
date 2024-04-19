package com.lyphuc.eCommerce.product;

import com.lyphuc.eCommerce.comment.Comment;
import com.lyphuc.eCommerce.comment.CommentDto;
import com.lyphuc.eCommerce.product.ProductRepository;
import com.lyphuc.eCommerce.product.ProductDto;
import com.lyphuc.eCommerce.productImage.ProductImageDto;
import com.lyphuc.eCommerce.product.Product;
import com.lyphuc.eCommerce.productImage.ProductImage;
import com.lyphuc.eCommerce.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.comment.CommentMapper.mapToCommentDto;
import static com.lyphuc.eCommerce.productImage.ProductImageMapper.mapToProductImageDto;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProduct;
import static com.lyphuc.eCommerce.product.ProductMapper.mapToProductDto;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return getProductDtoList(products);
    }

    private static List<ProductDto> getProductDtoList(List<Product> products) {
        return products.stream().map(product -> mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(int id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = null;
        if(result.isPresent()){
            product = result.get();
        }else{
            throw new RuntimeException("Did not find product id: "+id);
        }
        return mapToProductDto(product);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = mapToProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductImageDto> getProductImagesByProductId(int id) {
        Optional<Product> result = productRepository.findById(id);
        List<ProductImage> productImages = null;
        if (result.isPresent()){
            productImages = result.get().getProductImages();
        }else {
            throw new RuntimeException("Did not find product id: "+id);
        }
        return getProductImageDtoList(productImages);
    }

    @Override
    public List<CommentDto> getCommentsByProductId(int id) {
        Optional<Product> result = productRepository.findById(id);
        List<Comment> comments = null;
        if (result.isPresent()){
            comments = result.get().getComments();
        }else {
            throw new RuntimeException("can not find product id");
        }
        return getCommentDtoList(comments);
    }

    @Override
    public Page<ProductDto> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize,sort);
        return this.productRepository.findAll(pageable).map(product -> mapToProductDto(product));
    }

    private static List<CommentDto> getCommentDtoList(List<Comment> comments) {
        return comments.stream().map(comment -> mapToCommentDto(comment)).collect(Collectors.toList());
    }

    private static List<ProductImageDto> getProductImageDtoList(List<ProductImage> productImages) {
        return productImages.stream().map(productImage -> mapToProductImageDto(productImage)).collect(Collectors.toList());
    }


}
