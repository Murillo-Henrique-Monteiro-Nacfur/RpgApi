package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpgtcc.dto.InventoryDTO;
import rpgtcc.model.Item;
import rpgtcc.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public InventoryDTO create(Item item){
        this.itemRepository.save(item);
        return new InventoryDTO(
             this.itemRepository.findAllByOwnerId(item.getOwnerId())
             .stream()
             .collect(Collectors.groupingBy(Item::getName))
        );
    }

    public InventoryDTO readInventory(Long id){
        return new InventoryDTO(
                this.itemRepository.findAllByOwnerId(id)
                        .stream()
                        .collect(Collectors.groupingBy(Item::getName))
        );
    }

    public InventoryDTO delete(Long id, String name){
        List<Item> stored = this.itemRepository.findAllByOwnerIdAndName(id, name);

        if(stored.size() != 0){
            this.itemRepository.delete(stored.get(0));
        }

        return new InventoryDTO(
                this.itemRepository.findAllByOwnerId(id)
                        .stream()
                        .collect(Collectors.groupingBy(Item::getName))
        );
    }
}