package com.mxsi.vehiclepositiongenerator.api.utils;

import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RequestValidatorTest {

    @Test
    public void testRequestValidates_failOnCountOfDistrictsToDistributedVehicles() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfDistrictsToDistributeVehicles(0);
        assertFalse(RequestValidator.requestValidates(request));
    }

    @Test
    public void testRequestValidates_failOnCountOfVehicleToGenerate() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfDistrictsToDistributeVehicles(1);
        request.setCountOfVehicleToGenerate(0);
        assertFalse(RequestValidator.requestValidates(request));
    }


    @Test
    public void testRequestValidates_failOnCountOfDistrictsToDistributedVehiclesGreaterThanVehicles() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfDistrictsToDistributeVehicles(5);
        request.setCountOfVehicleToGenerate(1);
        assertFalse(RequestValidator.requestValidates(request));
    }

    @Test
    public void testRequestValidates_validateOnAllConditions() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfDistrictsToDistributeVehicles(1);
        request.setCountOfVehicleToGenerate(5);
        assertTrue(RequestValidator.requestValidates(request));
    }

    @Test
    public void testRequestValidates_validateOnAllConditionsExact() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfDistrictsToDistributeVehicles(1000);
        request.setCountOfVehicleToGenerate(1000);
        assertTrue(RequestValidator.requestValidates(request));
    }
}
