package cput.ac.za.ecommerce.service.impl;
/*
 Service Impl for Shipment tracking
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */
import cput.ac.za.ecommerce.domain.ShipmentTracking;
import cput.ac.za.ecommerce.repository.ShipmentTrackingRepository;
import cput.ac.za.ecommerce.service.IShipmentTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentTrackingServiceImpl implements IShipmentTrackingService {

    private final ShipmentTrackingRepository repository;

    @Autowired
    public ShipmentTrackingServiceImpl(ShipmentTrackingRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShipmentTracking create(ShipmentTracking shipmentTracking) {
        return repository.save(shipmentTracking);
    }

    @Override
    public ShipmentTracking read(String trackingId) {
        return repository.findById(trackingId).orElse(null);
    }

    @Override
    public ShipmentTracking update(ShipmentTracking shipmentTracking) {
        return repository.save(shipmentTracking);
    }

    @Override
    public boolean delete(String trackingId) {
        if (repository.existsById(trackingId)) {
            repository.deleteById(trackingId);
            return true;
        }
        return false;
    }

    @Override
    public List<ShipmentTracking> getAll() {
        return repository.findAll();
    }
}
