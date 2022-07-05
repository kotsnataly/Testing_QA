package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.model.Customer;
import geekbrains.kotsns.shop.shop.model.Product;
import geekbrains.kotsns.shop.shop.repository.CustomerRepository;
import geekbrains.kotsns.shop.shop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddProductToOrderList {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/addToCart")
    @ResponseBody
    private boolean addToCart(@RequestBody Map<String, String> productAndCustomer) {
        //json приходит в виде {"productId":productId, "customerId": customerId}
        //получаем сущность товара из БД по Id.
        Long productId = Long.parseLong(productAndCustomer.get("productId"));
        Product product = productsRepository.getOne(productId);

        //получаем сущность пользователя по Id
        Long customerId = Long.parseLong(productAndCustomer.get("customerId"));
        Customer customer = customerRepository.getOne(customerId);
        //добавляем товар в корзину покупателя.
        boolean addedOrNot = customer.addProductToOrder(product);
        customerRepository.save(customer);
        return addedOrNot;
    }
}
