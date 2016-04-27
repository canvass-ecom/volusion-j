/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.volusion.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Naga Srinivas @Canvass
 */
public class Customer extends BaseModel {

    @SerializedName(value = "CustomerID")
    private long id;
    @SerializedName(value = "FirstName")
    private String firstName;
    @SerializedName(value = "LastName")
    private String lastName;
    @SerializedName(value = "EmailAddress")
    private String email;
    @SerializedName(value = "PhoneNumber")
    private String phone;
    @SerializedName(value = "FirstDateVisited")
    private Date registeredDate;
    @SerializedName(value = "last_order_id")
    private long lastOrderId = -1;
    @SerializedName(value = "store_credit")
    private Float totalSpent;
    @SerializedName(value = "orders_count")
    private int totalOrders = 0;

    public String getFullName() {
        return (firstName != null ? firstName : "") + (lastName != null ? " " + lastName : "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", lastOrderId=" + lastOrderId + ", totalSpent=" + totalSpent + ", totalOrders=" + totalOrders + ", registeredDate=" + registeredDate + '}';
    }
}
