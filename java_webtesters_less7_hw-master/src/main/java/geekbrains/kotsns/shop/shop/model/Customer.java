package geekbrains.kotsns.shop.shop.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //fields
    private String firstName;
    private String secondName;


    @OneToMany
    private List<Product> orderList;

    //constructors
    public Customer(String name) {
        String[] fullName = name.split(" ");
        this.firstName = fullName[0];
        this.secondName = fullName[1];
    }

    public Customer() {

    }


    //getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", orderList=" + orderList +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    //add product to field 'orderList'
    public boolean addProductToOrder(Product product) {
        return this.orderList.add(product);
    }

    //get order list
    public List<Product> getOrderList() {
        return orderList;
    }
}
