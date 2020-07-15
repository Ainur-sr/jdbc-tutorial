package entity;

import java.sql.Date;
import java.util.Objects;

public class Emloyee {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private Long addressId;

    public Emloyee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emloyee emloyee = (Emloyee) o;
        return Objects.equals(id, emloyee.id) &&
                Objects.equals(firstName, emloyee.firstName) &&
                Objects.equals(lastName, emloyee.lastName) &&
                Objects.equals(birthDay, emloyee.birthDay) &&
                Objects.equals(addressId, emloyee.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDay, addressId);
    }

    @Override
    public String toString() {
        return "Emloyee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", addressId=" + addressId +
                '}';
    }

}
