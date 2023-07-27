package ru.skypro.shoppingbag;

import java.util.Set;

public interface ShoppingBagService {
    void addItemToShoppingBag(Set<Long> itemIds, ShoppingBag shoppingBag);
    Set<Long> getBagItems(ShoppingBag shoppingBag);
}
