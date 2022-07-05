package geekbrains.kotsns.shop.shop.repository;

import geekbrains.kotsns.shop.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
