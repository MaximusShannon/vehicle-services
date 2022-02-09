package com.mxsi.vehiclepositiongenerator.controller;

import com.mxsi.vehiclepositiongenerator.api.cache.VehicleCache;
import com.mxsi.vehiclepositiongenerator.api.controller.VehicleGeneratorController;
import com.mxsi.vehiclepositiongenerator.api.model.Response;
import com.mxsi.vehiclepositiongenerator.api.model.Status;
import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;
import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class VehicleGenerationControllerTest {

    @Autowired
    private VehicleGeneratorController vehicleGeneratorController;

    @Autowired
    private VehicleCache vehicleCache;

    @BeforeEach
    public void beforeEach(){
        vehicleCache.clear();
    }

    @Test
    public void testGenerateVehicles_invalidRequest(){
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(1);
        request.setCountOfDistrictsToDistributeVehicles(0);

        Response response = vehicleGeneratorController.generateVehicles(request);
        assertNotNull(response);
        assertEquals(Status.INVALID_REQUEST, response.getStatus());
    }

    @Test
    public void testGenerateVehicles_validRequest_1_vehicle_1_district(){
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(1);
        request.setCountOfDistrictsToDistributeVehicles(1);

        Response response = vehicleGeneratorController.generateVehicles(request);
        assertNotNull(response);
        assertEquals(Status.OK, response.getStatus());

        Map<Integer, List<Vehicle>> districtIdVehicleMap = vehicleCache.getDistrictIdToVehicleMap();
        assertNotNull(districtIdVehicleMap);
        assertEquals(1, districtIdVehicleMap.size());
    }
}
