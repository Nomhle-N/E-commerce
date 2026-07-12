package cput.ac.za.ecommerce.service.impl;
/*
 Service Impl for delivery
 Author: Sinazo Ntsimbi (222765208)
 Date: 10 July 2026
 */

import cput.ac.za.ecommerce.domain.Delivery;
import cput.ac.za.ecommerce.repository.DeliveryRepository;
import cput.ac.za.ecommerce.service.IDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

    private final DeliveryRepository repository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Delivery create(Delivery delivery) {
        return repository.save(delivery);
    }

    @Override
    public Delivery read(String deliveryId) {
        return repository.findById(deliveryId).orElse(null);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return repository.save(delivery);
    }

    @Override
    public boolean delete(String deliveryId) {
        if (repository.existsById(deliveryId)) {
            repository.deleteById(deliveryId);
            return true;
        }
        return false;
    }

    @Override
    public List<Delivery> getAll() {
        return repository.findAll();
    }
}