package com.mxsi.vehiclepositiongenerator.api.cache;

import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VehicleCacheTest {

    @Autowired
    private VehicleCache vehicleCache;

    @BeforeEach
    public void beforeEach() {
        vehicleCache.clear();
    }

    @Test
    public void testCacheVehicles_emptyListPassed() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleCache.cacheVehicles(vehicles);

        assertNotNull(vehicleCache.getDistrictIdToVehicleMap());
        assertTrue(vehicleCache.getDistrictIdToVehicleMap().isEmpty());
    }

    @Test
    public void testCacheVehicles_singleDistrictId() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, 1));
        vehicles.add(new Vehicle(1, 2));
        vehicles.add(new Vehicle(1, 3));

        vehicleCache.cacheVehicles(vehicles);

        Map<Integer, List<Vehicle>> districtIdVehicleMap = vehicleCache.getDistrictIdToVehicleMap();
        assertNotNull(districtIdVehicleMap);
        assertEquals(1, districtIdVehicleMap.size());

        assertEquals(3, districtIdVehicleMap.get(1).size());
    }

    @Test
    public void testCacheVehicles_multipleDistrictId() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, 1));
        vehicles.add(new Vehicle(2, 2));
        vehicles.add(new Vehicle(3, 3));

        vehicleCache.cacheVehicles(vehicles);

        Map<Integer, List<Vehicle>> districtIdVehicleMap = vehicleCache.getDistrictIdToVehicleMap();
        assertNotNull(districtIdVehicleMap);
        assertEquals(3, districtIdVehicleMap.size());

        districtIdVehicleMap.forEach((key, value) -> assertEquals(1, value.size()));
    }
}
