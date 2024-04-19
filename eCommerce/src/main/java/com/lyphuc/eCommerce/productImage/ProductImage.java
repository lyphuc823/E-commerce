package com.lyphuc.eCommerce.productImage;

import com.lyphuc.eCommerce.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int imageId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "is_primary")
    private int isPrimary;

    ////////////////////

    public ProductImage(String imageUrl, int isPrimary) {
        this.imageUrl = imageUrl;
        this.isPrimary = isPrimary;
    }

}
