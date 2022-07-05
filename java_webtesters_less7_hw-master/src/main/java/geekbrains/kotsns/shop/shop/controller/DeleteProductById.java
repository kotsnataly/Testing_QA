package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductById {

    @Autowired
    private ProductsRepository productsRepository;
//удаляем товар по Id
    @PostMapping("/deleteProduct")
    private void deleteProductById(@RequestBody String productId) {
        productsRepository.delete(productsRepository.getOne(Long.parseLong(productId)));
    }
}
