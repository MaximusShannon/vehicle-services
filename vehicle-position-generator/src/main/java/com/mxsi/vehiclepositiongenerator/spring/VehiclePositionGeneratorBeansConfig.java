package com.mxsi.vehiclepositiongenerator.spring;

import com.mxsi.vehiclepositiongenerator.api.cache.VehicleCache;
import com.mxsi.vehiclepositiongenerator.service.VehicleGenerationService;
import com.mxsi.vehiclepositiongenerator.service.VehiclePositionUpdaterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehiclePositionGeneratorBeansConfig {

    @Bean(name = "vehicleCache")
    public VehicleCache vehicleCache() {
        return new VehicleCache();
    }

    @Bean(name = "vehicleGenerationService")
    public VehicleGenerationService vehicleGenerationService() {
        return new VehicleGenerationService();
    }

    @Bean(name = "vehiclePositionUpdaterService")
    public VehiclePositionUpdaterService vehiclePositionUpdaterService(){
        return new VehiclePositionUpdaterService();
    }
}
