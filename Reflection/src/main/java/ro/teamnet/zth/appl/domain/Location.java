package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by user on 7/7/2016.
 */
@Table(name = "LOCATIONS")
public class Location {


    @Id(name = "LOCATION_ID")
    private Long id;

    @Column(name = "STREET_ADRESS")
    private String streetAdress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    public void setStreetAdress(String streetAdress) {

        this.streetAdress = streetAdress;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getStateProvince() {

        return stateProvince;
    }

    public String getCity() {

        return city;
    }

    public String getPostalCode() {

        return postalCode;
    }


    public String getStreetAdress() {

        return streetAdress;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAdress='" + streetAdress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (getId() != location.getId()) return false;
        if (!getStreetAdress().equals(location.getStreetAdress())) return false;
        if (!getPostalCode().equals(location.getPostalCode())) return false;
        if (!getCity().equals(location.getCity())) return false;
        return getStateProvince().equals(location.getStateProvince());

    }


}
