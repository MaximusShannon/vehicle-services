package com.mxsi.vehiclepositiongenerator.api.utils;

import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;

public class RequestValidator {

    /**
     * Request should always have >1 vehicles, and >1 districts to distribute vehicles to.
     *
     * @param request request params: countOfVehicleToGenerate, countOfDistrictsToDistributeVehicles
     * @return boolean true: validates, false: fails
     */
    public static boolean requestValidates(final VehicleGenerationRequest request) {
        return request.getCountOfDistrictsToDistributeVehicles() > 0
                && request.getCountOfVehicleToGenerate() > 0
                && request.getCountOfDistrictsToDistributeVehicles() <= request.getCountOfVehicleToGenerate();
    }
}
