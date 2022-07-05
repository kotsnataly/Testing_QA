package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.model.Customer;
import geekbrains.kotsns.shop.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //добавляем в БД нового покупателя
    @PostMapping("/newCustomer")
    private String addNewCustomer(@RequestBody String name) {
        Customer newCustomer = new Customer(name);
        customerRepository.save(newCustomer);
        return newCustomer.getFullName();
    }
}
