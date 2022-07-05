package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.model.Customer;
import geekbrains.kotsns.shop.shop.model.Product;
import geekbrains.kotsns.shop.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetOrderListByUserId {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/getUserOrder")
    @ResponseBody
    private List<Product> getOrderList(@RequestBody String userId) {
        Customer customer = customerRepository.getOne(Long.parseLong(userId));
        return customer.getOrderList();
    }
}
