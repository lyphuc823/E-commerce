package com.lyphuc.eCommerce.provider;

import com.lyphuc.eCommerce.provider.ProviderRepository;
import com.lyphuc.eCommerce.provider.ProviderDto;
import com.lyphuc.eCommerce.provider.Provider;
import com.lyphuc.eCommerce.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProvider;
import static com.lyphuc.eCommerce.provider.ProviderMapper.mapToProviderDto;

@Service
public class ProviderServiceImpl implements ProviderService {
    private ProviderRepository providerRepository;
    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<ProviderDto> findAll() {
        List<Provider> providers = providerRepository.findAll();
        return getProviderDtoList(providers);
    }

    private static List<ProviderDto> getProviderDtoList(List<Provider> providers) {
        return providers.stream().map(provider -> mapToProviderDto(provider)).collect(Collectors.toList());
    }

    @Override
    public ProviderDto findById(int id) {
        Optional<Provider> result = providerRepository.findById(id);
        Provider provider = null;
        if(result.isPresent()){
            provider = result.get();
        }else {
            throw new RuntimeException("Did not find provider id: "+id);
        }
        return mapToProviderDto(provider);
    }

    @Override
    public void save(ProviderDto providerDto) {
        Provider provider = mapToProvider(providerDto);
        providerRepository.save(provider);
    }

    @Override
    public void deleteById(int id) {
        providerRepository.deleteById(id);
    }

}
