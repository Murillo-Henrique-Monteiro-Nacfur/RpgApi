package rpgtcc.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rpgtcc.dto.InventoryDTO;
import rpgtcc.model.Item;
import rpgtcc.service.ItemService;

@RestController
@RequestMapping("inventory")
public class InventoryEndPoint {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public InventoryDTO postItem(@RequestBody Item item){
        return this.itemService.create(item);
    }

    @GetMapping("/{id}")
    public InventoryDTO readInventory(@PathVariable("id") Long id){
        return this.itemService.readInventory(id);
    }

    @DeleteMapping("/{id}")
    public InventoryDTO deleteItem(@PathVariable("id") Long id, @RequestParam String name){
        return this.itemService.delete(id, name);
    }
}
