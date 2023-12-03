package atanas.ba.exam_project.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "holiday_dates")
public class HolidayDateEntity{

    @Id
    @Column(name = "local_holiday_names", nullable = false)
    private String localName;
    @NotNull
    private LocalDate date;

    @Column(name = "english_holiday_name", nullable = false)
    private String name;
    @Column(name = "country_code", nullable = false)
    private String countryCode;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
