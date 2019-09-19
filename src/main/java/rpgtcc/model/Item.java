package rpgtcc.model;

import javax.persistence.Entity;

@Entity
public class Item extends AbstractEntity {
    private Long ownerId;
    private String name;

    public Long getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }
}
