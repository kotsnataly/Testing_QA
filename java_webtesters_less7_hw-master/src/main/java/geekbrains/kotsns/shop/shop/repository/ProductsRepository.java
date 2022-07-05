package geekbrains.kotsns.shop.shop.repository;

import geekbrains.kotsns.shop.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
