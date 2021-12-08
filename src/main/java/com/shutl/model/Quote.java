package com.shutl.model;

public class Quote {
    String pickupPostcode;
    String deliveryPostcode;
    String vehicle;
    Long price;

    public Quote() {}

    public Quote(String pickupPostcode, String deliveryPostcode) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.price = price;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.price = price;
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    private double getMarkupPercentage(String vehicle) {
        vehicle = vehicle.toLowerCase();
        switch (vehicle) {
            case "bicycle": return 1.10;
            case "motorbike": return 1.15;
            case "parcel_car": return 1.20;
            case "small_van": return 1.30;
            case "large_van": return 1.40;
            default: 
                return 1.0;
        }
    }

    public Long calculateDeliveryCost() {
        long diff = Long.valueOf(this.pickupPostcode, 36) - Long.valueOf(this.deliveryPostcode, 36);
        diff = diff / 100000000;
        diff *= getMarkupPercentage(this.vehicle);
        return Math.abs(diff);
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
