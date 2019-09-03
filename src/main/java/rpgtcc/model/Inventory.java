package rpgtcc.model;

import javax.persistence.Entity;

@Entity
public class Inventory extends AbstractEntity {

    private Long ownerId;
    private String itemName;

}
