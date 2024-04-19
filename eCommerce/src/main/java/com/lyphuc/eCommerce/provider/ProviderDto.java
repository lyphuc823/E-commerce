package com.lyphuc.eCommerce.provider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderDto {
    private int providerID;
    private String providerName;
    private String contactPerson;
    private String contactEmail;
    private String contactNumberPhone;
    private String address;
    private int isActive;
}
