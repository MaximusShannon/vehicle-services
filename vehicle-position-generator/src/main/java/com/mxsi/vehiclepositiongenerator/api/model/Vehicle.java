package com.mxsi.vehiclepositiongenerator.api.model;

public class Vehicle {

    private Integer districtId;

    private Integer vehicleId;

    private Double vehicleLat;

    private Double vehicleLong;

    public Vehicle(final Integer districtId, final Integer vehicleId) {
        this.districtId = districtId;
        this.vehicleId = vehicleId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(final Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Double getVehicleLat() {
        return vehicleLat;
    }

    public void setVehicleLat(final Double vehicleLat) {
        this.vehicleLat = vehicleLat;
    }

    public Double getVehicleLong() {
        return vehicleLong;
    }

    public void setVehicleLong(final Double vehicleLong) {
        this.vehicleLong = vehicleLong;
    }
}
