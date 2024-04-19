package com.lyphuc.eCommerce.provider;

import com.lyphuc.eCommerce.provider.ProviderDto;

import java.util.List;

public interface ProviderService {
    List<ProviderDto> findAll();
    ProviderDto findById(int id);
    void save(ProviderDto providerDto);
    void deleteById(int id);
}
