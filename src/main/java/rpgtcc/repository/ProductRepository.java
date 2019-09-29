package rpgtcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rpgtcc.model.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Optional<Product> findByFlag(String flag);
}
