package atanas.ba.exam_project.models.entities;

import atanas.ba.exam_project.models.enums.PropertyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity(name = "properties")
public class PropertyEntity extends BaseEntity {


    @Column(name = "price")
    @Positive
    private BigDecimal price;
    @Column(name = "property_address",nullable = false)
    @Size(min = 2, max = 50)
    private  String propertyAddress;
    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false)
    private PropertyType propertyType;
    @Column(name = "bedroom_amount", nullable = false)
    @Positive
    private int bedroomAmount;
    @Column(name = "bathroom_amount", nullable = false)
    @Positive
    private int bathroomAmount;
    @Column(name = "area_size", nullable = false)
    @Positive
    private int areaSize;
    @Column(name = "parking_spots", nullable = false)
    @Positive
    private int parkingSpots;
    @Column(name = "property_image", nullable = false)
    private String propertyImage;

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public int getBedroomAmount() {
        return bedroomAmount;
    }

    public void setBedroomAmount(int bedroomAmount) {
        this.bedroomAmount = bedroomAmount;
    }

    public int getBathroomAmount() {
        return bathroomAmount;
    }

    public void setBathroomAmount(int bathroomAmount) {
        this.bathroomAmount = bathroomAmount;
    }

    public int getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(int areaSize) {
        this.areaSize = areaSize;
    }


    public int getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(int parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
