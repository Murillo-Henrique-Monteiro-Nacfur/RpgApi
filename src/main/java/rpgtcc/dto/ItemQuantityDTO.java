package rpgtcc.dto;

public class ItemQuantityDTO {
    Integer quantity;
    String item;

    public ItemQuantityDTO(Integer quantity, String item) {
        this.quantity = quantity;
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }
}