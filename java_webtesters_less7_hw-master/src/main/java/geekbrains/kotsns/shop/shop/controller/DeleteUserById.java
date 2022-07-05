package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteUserById {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/deleteUserById")
    private void deleteUser(@RequestBody String userId) {
        customerRepository.delete(customerRepository.getOne(Long.parseLong(userId)));
    }
}
