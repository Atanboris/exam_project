package atanas.ba.exam_project.models.entities;

import atanas.ba.exam_project.models.enums.PropertyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity(name = "properties")
public class PropertyEntity extends BaseEntity {

    //TODO (Validations)

    @Column(name = "price")
    private long price;
    @Column(name = "property_address")
    private  String propertyAddress;
    @Enumerated(EnumType.STRING)
    private PropertyType propertyType;
    @Column(name = "bedroom_amount", nullable = false)
    private int BedroomAmount;
    @Column(name = "bathroom_amount", nullable = false)
    private int BathroomAmount;
    @Column(name = "area_size", nullable = false)
    private int areaSize;
    @Column(name = "parking_spots", nullable = false)
    private int parkingSpots;
    @Column(name = "property_image")
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


    public int getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(int parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
