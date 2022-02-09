package com.mxsi.vehiclepositiongenerator.service;

import com.mxsi.vehiclepositiongenerator.api.cache.VehicleCache;
import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;
import com.mxsi.vehiclepositiongenerator.api.model.VehicleGenerationRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class VehicleGenerationServiceTest {

    @Autowired
    private VehicleCache vehicleCache;

    @Autowired
    private VehicleGenerationService vehicleGenerationService;

    @BeforeEach
    public void beforeAll() {
        vehicleCache.clear();
    }

    @Test
    public void testGenerateVehicles_failedToValidateRequest() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(0);
        request.setCountOfDistrictsToDistributeVehicles(0);

        vehicleGenerationService.generateVehicles(request);
        assertTrue(vehicleCache.getDistrictIdToVehicleMap().isEmpty());
    }

    @Test
    public void testGenerateVehicles_failedToValidateRequest_moreDistrictsThanVehicles() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(1);
        request.setCountOfDistrictsToDistributeVehicles(5);

        vehicleGenerationService.generateVehicles(request);
        assertTrue(vehicleCache.getDistrictIdToVehicleMap().isEmpty());
    }

    @Test
    public void testGenerateVehicles_1_vehicle_1_contractor() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(1);
        request.setCountOfDistrictsToDistributeVehicles(1);

        vehicleGenerationService.generateVehicles(request);
        assertFalse(vehicleCache.getDistrictIdToVehicleMap().isEmpty());

        Map<Integer, List<Vehicle>> districtIdToVehicleCache = vehicleCache.getDistrictIdToVehicleMap();
        List<Vehicle> vehiclesForDistrict = districtIdToVehicleCache.get(1);
        assertNotNull(vehiclesForDistrict);
        assertEquals(1, vehiclesForDistrict.size());

        Vehicle vehicle = vehiclesForDistrict.get(0);
        assertEquals(1, vehicle.getVehicleId());
    }

    @Test
    public void testGenerateVehicles_5_vehicle_1_contractor() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(5);
        request.setCountOfDistrictsToDistributeVehicles(1);

        vehicleGenerationService.generateVehicles(request);
        assertFalse(vehicleCache.getDistrictIdToVehicleMap().isEmpty());

        Map<Integer, List<Vehicle>> districtIdToVehicleCache = vehicleCache.getDistrictIdToVehicleMap();
        List<Vehicle> vehiclesForDistrict = districtIdToVehicleCache.get(1);
        assertNotNull(vehiclesForDistrict);
        assertEquals(5, vehiclesForDistrict.size());
        for (int i = 0; i < vehiclesForDistrict.size(); i++) {
            Vehicle vehicle = vehiclesForDistrict.get(i);
            assertEquals(i + 1, vehicle.getVehicleId());
            assertEquals(1, vehicle.getDistrictId());
        }
    }

    @Test
    public void testGenerateVehicles_5_vehicle_5_contractors() {
        VehicleGenerationRequest request = new VehicleGenerationRequest();
        request.setCountOfVehicleToGenerate(5);
        request.setCountOfDistrictsToDistributeVehicles(5);

        vehicleGenerationService.generateVehicles(request);
        assertFalse(vehicleCache.getDistrictIdToVehicleMap().isEmpty());

        Map<Integer, List<Vehicle>> districtIdToVehicleCache = vehicleCache.getDistrictIdToVehicleMap();
        // we can't guarantee the size or order of the map here, so we will have to check the ranges.
        assertTrue(districtIdToVehicleCache.size() <= 5);
        assertTrue(districtIdToVehicleCache.size() >= 1);
    }
}
