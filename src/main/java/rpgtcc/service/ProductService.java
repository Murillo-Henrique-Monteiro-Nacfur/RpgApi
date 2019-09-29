package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import rpgtcc.dto.InventoryDTO;
import rpgtcc.model.Item;
import rpgtcc.model.Product;
import rpgtcc.repository.ItemRepository;
import rpgtcc.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product readByFlag(String flag){
        return this.productRepository.findByFlag(flag).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("Product", flag,
                "Opa! Nãp conseguimos achar o item desejado!"));
    }
}