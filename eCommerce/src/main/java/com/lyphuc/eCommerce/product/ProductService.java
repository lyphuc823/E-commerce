package com.lyphuc.eCommerce.product;

import com.lyphuc.eCommerce.comment.CommentDto;
import com.lyphuc.eCommerce.product.ProductDto;
import com.lyphuc.eCommerce.productImage.ProductImageDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(int id);
    void save(ProductDto productDto);
    void deleteById(int id);
    List<ProductImageDto> getProductImagesByProductId(int id);
    List<CommentDto> getCommentsByProductId(int id);
    Page<ProductDto> findPaginated(int pageNo,int pageSize,String sortField,String sortDirection);
}
