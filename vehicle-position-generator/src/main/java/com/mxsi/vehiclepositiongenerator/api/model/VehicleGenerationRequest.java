package com.mxsi.vehiclepositiongenerator.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleGenerationRequest {

    /**
     * The number of vehicles that will be generated.
     */
    @JsonProperty(value = "count_of_vehicles_to_generate")
    private int countOfVehicleToGenerate;

    /**
     * Normally vehicles in the real world would fall under different contractors or districts.
     * We cannot say that all districts will be the same, they will be distributed.
     *
     */
    @JsonProperty(value = "count_of_districts_to_distribute_vehicles")
    private int countOfDistrictsToDistributeVehicles;

    public int getCountOfVehicleToGenerate() {
        return countOfVehicleToGenerate;
    }

    public void setCountOfVehicleToGenerate(final int countOfVehicleToGenerate) {
        this.countOfVehicleToGenerate = countOfVehicleToGenerate;
    }

    public int getCountOfDistrictsToDistributeVehicles() {
        return countOfDistrictsToDistributeVehicles;
    }

    public void setCountOfDistrictsToDistributeVehicles(final int countOfDistrictsToDistributeVehicles) {
        this.countOfDistrictsToDistributeVehicles = countOfDistrictsToDistributeVehicles;
    }

    @Override
    public String toString() {
        return "VehicleGenerationRequest{" +
                "countOfVehicleToGenerate=" + countOfVehicleToGenerate +
                ", countOfDistrictsToDistributeVehicles=" + countOfDistrictsToDistributeVehicles +
                '}';
    }
}
