package com.lyphuc.eCommerce.specification;

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
@Table(name = "specifications")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spec_id")
    private int specId;
//    @Column(name = "product_id")
//    private int productId;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "spec_name")
    private String specName;
    @Column(name = "spec_value")
    private String specValue;

    ////////////////////////

    public Specification(String specName, String specValue) {
        this.specName = specName;
        this.specValue = specValue;
    }

}
