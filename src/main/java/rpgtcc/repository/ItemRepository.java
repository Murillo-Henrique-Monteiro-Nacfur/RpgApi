package rpgtcc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rpgtcc.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findAllByOwnerId(Long id);
    List<Item> findAllByOwnerIdAndName(Long id, String name);
}
