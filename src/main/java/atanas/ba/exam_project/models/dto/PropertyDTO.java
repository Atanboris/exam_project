package atanas.ba.exam_project.models.dto;

import atanas.ba.exam_project.models.entities.PropertyEntity;
import atanas.ba.exam_project.models.enums.PropertyType;

public class PropertyDTO {
//     <h4><a th:href="@{property-details}">18 Old Street Miami, OR 97219</a></h4>
//            <ul>
//              <li>Bedrooms: <span>8</span></li>
//              <li>Bathrooms: <span>8</span></li>
//              <li>Area: <span>545m2</span></li>
//              <li>Floor: <span>3</span></li>
//              <li>Parking: <span>6 spots</span></li>


    private long price;
    private PropertyType propertyType;
    private String propertyAddress;
    private int bedroomAmount;
    private int bathroomAmount;
    private int areaSize;
    private int floor;
    private int parkingSpots;
    private String propertyImage;

    public PropertyDTO(PropertyEntity property) {
        this.propertyAddress = property.getPropertyAddress();
        this.bedroomAmount = property.getBedroomAmount();
        this.bathroomAmount = property.getBathroomAmount();
        this.areaSize = property.getAreaSize();
        this.floor = property.getFloor();
        this.parkingSpots = property.getParkingSpots();
        this.price = property.getPrice();
        this.propertyType = property.getPropertyType();
        this.propertyImage = property.getPropertyImage();
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
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

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
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
