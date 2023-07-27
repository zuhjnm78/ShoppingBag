package ru.skypro.shoppingbag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/order")

public class ShoppingBagController {
    private final ShoppingBagService shoppingBagService;

    @Autowired
    public ShoppingBagController(ShoppingBagService shoppingBagService) {
        this.shoppingBagService = shoppingBagService;
    }

    @GetMapping("/add")
    public String addItemToShoppingBag(@RequestParam("itemId") Set<Long> itemIds, HttpSession httpSession) {
        ShoppingBag shoppingBag = (ShoppingBag) httpSession.getAttribute("shoppingBag");
        if (shoppingBag == null) {
            shoppingBag = new ShoppingBag();
            httpSession.setAttribute("shoppingBag", shoppingBag);
        }
        shoppingBagService.addItemToShoppingBag(itemIds, shoppingBag);
        return "Товары успешно добавлены в корзину.";
    }

    @GetMapping("/get")
    public Set<Long> getBagItems(HttpSession httpSession) {
        ShoppingBag shoppingBag = (ShoppingBag) httpSession.getAttribute("shoppingBag");
        if (shoppingBag != null) {
            return shoppingBag.getItemIds();
        }
        return new HashSet<>();
    }
}
