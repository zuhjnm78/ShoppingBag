package ru.skypro.shoppingbag;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Component
public class ShoppingBagServiceImpl implements ShoppingBagService {
    private ShoppingBag shoppingBag;
    public ShoppingBagServiceImpl() {
        this.shoppingBag = new ShoppingBag();
    }

    @Override
    public void addItemToShoppingBag(Set<Long> itemIds, ShoppingBag shoppingBag) {
        shoppingBag.getItemIds().addAll(itemIds);
    }

    @Override
    public Set<Long> getBagItems(ShoppingBag shoppingBag) {
        return shoppingBag.getItemIds();
    }
}
