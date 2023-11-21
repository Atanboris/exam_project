package atanas.ba.exam_project.models.entities;

import atanas.ba.exam_project.models.enums.PropertyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity(name = "properties")
public class PropertyEntity extends BaseEntity {

    @Column
    private long price;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @Column(name = "bedroom_amount", nullable = false)
    private int BedroomAmount;
    @Column(name = "bathroom_amount", nullable = false)
    private int BathroomAmount;
    @Column(name = "bedroom_amount", nullable = false)
    private int areaSize;
    @Column(nullable = false)
    private int floor;
    @Column(name = "parking_spots", nullable = false)
    private int parkingSpots;

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public int getBedroomAmount() {
        return BedroomAmount;
    }

    public void setBedroomAmount(int bedroomAmount) {
        BedroomAmount = bedroomAmount;
    }

    public int getBathroomAmount() {
        return BathroomAmount;
    }

    public void setBathroomAmount(int bathroomAmount) {
        BathroomAmount = bathroomAmount;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(int parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
