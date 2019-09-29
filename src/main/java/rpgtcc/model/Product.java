package rpgtcc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flag;
    private String name;
    private Integer price;
    private Integer unit;

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getUnit() {
        return unit;
    }
}
