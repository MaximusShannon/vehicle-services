package com.mxsi.vehiclepositiongenerator.api.model;

import java.util.Date;

public class Vehicle {

    private Long version = 0L;

    private Integer districtId;

    private Integer vehicleId;

    private Double vehicleLat = -90.0;

    private Double vehicleLong = 90.0;

    private Date lastUpdatedTime;

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(final Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
