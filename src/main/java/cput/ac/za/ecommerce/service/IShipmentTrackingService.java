package cput.ac.za.ecommerce.service;
/*
 Service for Shipment tracking
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */

import cput.ac.za.ecommerce.domain.ShipmentTracking;

import java.util.List;

public interface IShipmentTrackingService {

    ShipmentTracking create(ShipmentTracking shipmentTracking);

    ShipmentTracking read(String trackingId);

    ShipmentTracking update(ShipmentTracking shipmentTracking);

    boolean delete(String trackingId);

    List<ShipmentTracking> getAll();
}
