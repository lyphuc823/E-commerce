package com.lyphuc.eCommerce.provider;

import com.lyphuc.eCommerce.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private int providerID;
    @Column(name = "provider_name")
    private String providerName;
    @Column(name = "contact_person")
    private String contactPerson;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone_number")
    private String contactNumberPhone;
    @Column(name = "address")
    private String address;
    @Column(name = "is_active")
    private int isActive;
    @OneToMany(mappedBy = "provider",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Product> products;

    /////////////////////

    public Provider(String providerName, String contactPerson, String contactEmail, String contactNumberPhone, String address, int isActive) {
        this.providerName = providerName;
        this.contactPerson = contactPerson;
        this.contactEmail = contactEmail;
        this.contactNumberPhone = contactNumberPhone;
        this.address = address;
        this.isActive = isActive;
    }

}
