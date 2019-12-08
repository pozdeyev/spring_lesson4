package com.geekbrains.bootdata.filters;

import com.geekbrains.bootdata.entities.Item;
import com.geekbrains.bootdata.repositories.ItemSpecifications;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

@Getter
public class ItemFilter {
    private Specification<Item> spec;
    private StringBuilder filterDefinition;

    public ItemFilter(Map<String, String> map) {
        this.spec = Specification.where(null);
        this.filterDefinition = new StringBuilder();

        if (map.containsKey("min_price") && !map.get("min_price").isEmpty()) {
            int minPrice = Integer.parseInt(map.get("min_price"));
            spec = spec.and(ItemSpecifications.priceGreaterThanOrEq(minPrice));
            filterDefinition.append("&min_price=").append(minPrice);
        }
        if (map.containsKey("max_price") && !map.get("max_price").isEmpty()) {
            int maxPrice = Integer.parseInt(map.get("max_price"));
            spec = spec.and(ItemSpecifications.priceLesserThanOrEq(maxPrice));
            filterDefinition.append("&max_price=").append(maxPrice);
        }
    }
}
