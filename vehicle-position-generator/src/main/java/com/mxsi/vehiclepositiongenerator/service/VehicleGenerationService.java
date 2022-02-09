package com.mxsi.vehiclepositiongenerator.service;

import com.mxsi.vehiclepositiongenerator.api.cache.VehicleCache;
import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;
import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;
import com.mxsi.vehiclepositiongenerator.api.utils.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleGenerationService {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleGenerationService.class);

    @Autowired
    private VehicleCache vehicleCache;

    /**
     * Generate a list of vehicles, and pass them to the vehicle cache.
     *
     * @param request params: countOfVehicleToGenerate, countOfDistrictsToDistributeVehicles
     */
    public void generateVehicles(final VehicleGenerationRequest request) {
        if (RequestValidator.requestValidates(request)) {
            LOG.info("VehicleGenerationService - generateVehicles(request={})", request);

            List<Vehicle> vehicleList = new ArrayList<>();
            Random r = new Random();
            for (int i = 1; i <= request.getCountOfVehicleToGenerate(); i++) {
                vehicleList.add(new Vehicle(evaluateDistrictId(request.getCountOfDistrictsToDistributeVehicles(), r), i));
            }

            vehicleCache.cacheVehicles(vehicleList);
        } else {
            LOG.warn("VehicleGenerationService - generateVehicles(request={}), Failed to validate", request);
        }
    }

    private Integer evaluateDistrictId(final int countOfDistrictsToDistributeVehicles, final Random r) {
        return countOfDistrictsToDistributeVehicles == 1 ? countOfDistrictsToDistributeVehicles
                : r.nextInt(countOfDistrictsToDistributeVehicles - 1) + 1;
    }
}
