package hiring_process.edu.thi.hipro;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQuery(name=Customer.searchCustomer,
            query="SELECT c FROM Customer c WHERE c.email LIKE ?1")
@Table(name="customer")
public class Customer implements Serializable {
    public final static String searchCustomer = "Customer.searchCustomer";

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerid;
    private String firstname;
    private String lastname;
    private String email;
    private Integer yearOfBirth;
    
    public Long getCustomerid() {
        return customerid;
    }
    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    @Override
    public String toString() {
        return "Id: " + customerid + "; Firstname: " + firstname + "; Lastname: " + lastname + "; Email: " + email + "; Year of Birth: " + yearOfBirth;
    }

}
