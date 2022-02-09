package com.mxsi.vehiclepositiongenerator.api.cache;

import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class VehicleCache {

    private Map<Integer, List<Vehicle>> districtIdToVehicleMap;

    /**
     * Cache vehicles into map of district-id to list of vehicles.
     *
     * @param vehicleToCache list of vehicles created
     */
    public void cacheVehicles(final List<Vehicle> vehicleToCache) {
        districtIdToVehicleMap = vehicleToCache
                .stream()
                .collect(Collectors.groupingBy(Vehicle::getDistrictId));
    }

    /**
     * @return pre-created map, or empty map in the case it is null.
     */
    public Map<Integer, List<Vehicle>> getDistrictIdToVehicleMap() {
        return Objects.requireNonNullElseGet(districtIdToVehicleMap, HashMap::new);
    }

    /**
     * Clear cache
     */
    public void clear() {
        districtIdToVehicleMap = new HashMap<>();
    }
}
