package com.mxsi.vehiclepositiongenerator.service;

import com.mxsi.vehiclepositiongenerator.api.model.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class VehiclePositionUpdaterService {

    private static final Logger LOG = LoggerFactory.getLogger(VehiclePositionUpdaterService.class);

    private final double MIN_LATITUDE = -90.0;

    private final double MAX_LATITUDE = 90.0;

    private final double MIN_LONGITUDE = -180.0;

    private final double MAX_LONGITUDE = 180.0;

    private AtomicInteger atomicInt = new AtomicInteger(0);

    /**
     * In this use case we want to update all vehicle positions
     *
     * @param vehicleList list of vehicles for a district
     * @return updatedVehicleList
     */
    public void updateAllVehiclePositions(final List<Vehicle> vehicleList) {
        Random r = new Random();
        vehicleList.forEach(vehicle -> {
            double randomLatitude = MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * r.nextDouble();
            double randomLongitude = MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * r.nextDouble();

            updateVehiclePositions(vehicle, randomLatitude, randomLongitude);
        });
    }


    /**
     * In this case we want to update random vehicle positions to mimic a real API.
     * In this application we would only be full load testing.
     *
     * @param vehicleList list of vehicles for a district
     * @return updatedVehicleList
     */
    public void updateRandomVehiclePositions(final List<Vehicle> vehicleList) {
        Random r = new Random();
        vehicleList.forEach(vehicle -> {
            if (coinFlip(r)) {
                double randomLatitude = MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * r.nextDouble();
                double randomLongitude = MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * r.nextDouble();

                updateVehiclePositions(vehicle, randomLatitude, randomLongitude);
            }
        });
    }

    private boolean coinFlip(Random random) {
        return random.nextInt(10) > 3;
    }

    private void updateVehiclePositions(final Vehicle vehicle, final double randomLatitude, final double randomLongitude) {
        LOG.info("vehicle={} updated. totalUpdates={}", vehicle, atomicInt.incrementAndGet());
        vehicle.setVersion(vehicle.getVersion() + 1);
        vehicle.setVehicleLat(randomLatitude);
        vehicle.setVehicleLong(randomLongitude);
        vehicle.setLastUpdatedTime(new Date());
    }
}
