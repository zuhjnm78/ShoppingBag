package ru.skypro.shoppingbag;

import java.util.HashSet;
import java.util.Set;

public class ShoppingBag {
    private Set<Long> itemIds;

    public ShoppingBag() {
        this.itemIds = new HashSet<>();
    }

    public Set<Long> getItemIds() {
        return itemIds;
    }

}
