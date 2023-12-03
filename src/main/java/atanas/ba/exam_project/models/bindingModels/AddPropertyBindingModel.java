package atanas.ba.exam_project.models.bindingModels;

import atanas.ba.exam_project.models.enums.PropertyType;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

public class AddPropertyBindingModel {

    @Positive(message = "Price must be above zero")
    private long price;
    @NotNull(message = "Please select a type")
    private PropertyType propertyType;
    @Size(min = 2, max = 50, message = "Address must be between 2 and 50 characters")
    private String propertyAddress;

    @Positive(message = "Amount must be above zero")
    private int bedroomAmount;

    @Positive(message = "Amount must be above zero")
    private int bathroomAmount;

    @Positive(message = "Size must be above zero")
    private int areaSize;

    @Min(value = 0,message = "Parking spots cannot be negative")
    private int parkingSpots;
    @NotBlank(message = "Image field cannot be empty")
    @URL
    private String propertyImage;

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

    public int getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(int parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public String getPropertyImage() {
        return propertyImage;
    }

    public void setPropertyImage(String propertyImage) {
        this.propertyImage = propertyImage;
    }
}
