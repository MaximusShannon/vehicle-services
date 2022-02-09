package com.mxsi.vehiclepositiongenerator.api.controller;

import com.mxsi.vehiclepositiongenerator.api.model.Response;
import com.mxsi.vehiclepositiongenerator.api.model.Status;
import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;
import com.mxsi.vehiclepositiongenerator.api.utils.RequestValidator;
import com.mxsi.vehiclepositiongenerator.service.VehicleGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleGeneratorController {

    @Autowired
    private VehicleGenerationService vehicleGenerationService;

    /**
     * Generates a number of vehicles based on the request. It will then cache them in memory.
     *
     * @param request request params: countOfVehicleToGenerate, countOfDistrictsToDistributeVehicles
     *
     * @return response OK, FAIL, ERROR or INVALID_REQUEST
     */
    @PostMapping("/generateVehicles")
    public Response generateVehicles(final @RequestBody VehicleGenerationRequest request) {
        if (RequestValidator.requestValidates(request)) {
            //TODO: Wrap in try catch in-case of future dev.
            vehicleGenerationService.generateVehicles(request);
        } else {
            return new Response(Status.INVALID_REQUEST);
        }

        return new Response(Status.OK);
    }
}
