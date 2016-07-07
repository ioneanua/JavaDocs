package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by user on 7/7/2016.
 */

@Table(name = "DEPARTMENTS")
public class Department {

    @Id(name = "DEPARTMENT_ID")
    private long id;

    @Column(name = "DEPARTMENT_NAME")
    private String depatmentName;

    @Column(name = "LOCATION_ID")
    private String location;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepatmentName() {
        return depatmentName;
    }

    public void setDepatmentName(String depatmentName) {
        this.depatmentName = depatmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depatmentName='" + depatmentName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        if (getId() != that.getId()) return false;
        if (!getDepatmentName().equals(that.getDepatmentName())) return false;
        return getLocation().equals(that.getLocation());

    }

}
