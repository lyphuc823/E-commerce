package com.lyphuc.eCommerce.provider;

import com.lyphuc.eCommerce.provider.ProviderDto;
import com.lyphuc.eCommerce.provider.Provider;

public class ProviderMapper {
    public static ProviderDto mapToProviderDto(Provider provider){
        ProviderDto providerDto = ProviderDto.builder()
                .providerID(provider.getProviderID())
                .providerName(provider.getProviderName())
                .isActive(provider.getIsActive())
                .contactPerson(provider.getContactPerson())
                .contactEmail(provider.getContactEmail())
                .address(provider.getAddress())
                .contactNumberPhone(provider.getContactNumberPhone())
                .build();
        return providerDto;
    }
    public static Provider mapToProvider(ProviderDto providerDto){
        Provider provider = Provider.builder()
                .providerID(providerDto.getProviderID())
                .providerName(providerDto.getProviderName())
                .isActive(providerDto.getIsActive())
                .contactPerson(providerDto.getContactPerson())
                .contactEmail(providerDto.getContactEmail())
                .address(providerDto.getAddress())
                .contactNumberPhone(providerDto.getContactNumberPhone())
                .build();
        return provider;
    }
}
