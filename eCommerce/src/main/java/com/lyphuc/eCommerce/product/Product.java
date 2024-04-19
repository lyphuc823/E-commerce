package com.lyphuc.eCommerce.product;

import com.lyphuc.eCommerce.category.Category;
import com.lyphuc.eCommerce.comment.Comment;
import com.lyphuc.eCommerce.productImage.ProductImage;
import com.lyphuc.eCommerce.provider.Provider;
import com.lyphuc.eCommerce.purchaseOrderDetail.PurchaseOrderDetail;
import com.lyphuc.eCommerce.specification.Specification;
import com.lyphuc.eCommerce.orderDetail.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String  productName;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "stockQuantity")
    private int stockQuantity;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @Column(name = "brand")
    private String brand;
    @Column(name = "overall_rating")
    private String overallRating;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<ProductImage> productImages;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Specification> specifications;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Comment> comments;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<PurchaseOrderDetail> purchaseOrderDetails;

    //////////////////////////////////

    public Product(String productName, String description, int price, int stockQuantity, String brand, String overallRating) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
        this.overallRating = overallRating;
    }


    ///////////////////
    public void addProductImage(ProductImage productImage){
        if(productImages == null){
            productImages = new ArrayList<>();
        }
        productImages.add(productImage);
    }
    ///////////////////
    public void addSpecification(Specification specification){
        if(specifications == null){
            specifications = new ArrayList<>();
        }
        specifications.add(specification);
    }
    ///////////////////
    public void addComment(Comment comment){
        if(comments == null){
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }
    ///////////////////
    public void addOrderDetail(OrderDetail orderDetail){
        if(orderDetails == null){
            orderDetails = new ArrayList<>();
        }
        orderDetails.add(orderDetail);
    }
    ///////////////////
    public void addPurchaseOrderDetail(PurchaseOrderDetail purchaseOrderDetail){
        if(purchaseOrderDetails == null){
            purchaseOrderDetails = new ArrayList<>();
        }
        purchaseOrderDetails.add(purchaseOrderDetail);
    }
}
