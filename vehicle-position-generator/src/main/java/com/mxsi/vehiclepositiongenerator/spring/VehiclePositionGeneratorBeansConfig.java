package com.mxsi.vehiclepositiongenerator.spring;

import com.mxsi.vehiclepositiongenerator.api.cache.VehicleCache;
import com.mxsi.vehiclepositiongenerator.service.VehicleGenerationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehiclePositionGeneratorBeansConfig {

    @Bean(name = "vehicleCache")
    public VehicleCache vehicleCache() {
        return new VehicleCache();
    }

    @Bean
    public VehicleGenerationService vehicleGenerationService() {
        return new VehicleGenerationService();
    }
}
