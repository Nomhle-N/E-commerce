package cput.ac.za.ecommerce.service;
/*
 DeliveryService.java
 Service for Delivery
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */

import cput.ac.za.ecommerce.domain.Delivery;

import java.util.List;

public interface DeliveryService {

    Delivery create(Delivery delivery);

    Delivery read(String deliveryId);

    Delivery update(Delivery delivery);

    boolean delete(String deliveryId);

    List<Delivery> getAll();
}






