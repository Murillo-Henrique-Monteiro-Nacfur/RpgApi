package rpgtcc.dto;

import rpgtcc.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryDTO {
    List<ItemQuantityDTO> items = new ArrayList<>();

    public InventoryDTO(Map<String, List<Item>> itemsMap) {
        itemsMap.forEach((k,i) -> this.items.add(new ItemQuantityDTO( i.size(), k)));
    }

    public List<ItemQuantityDTO> getItems() {
        return items;
    }
}