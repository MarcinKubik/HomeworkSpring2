package pl.coderslab.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private Long lastProductId;
    private List<CartItem> cartItems;
    public Cart(HttpSession session){
        lastProductId = (Long)session.getAttribute("lastProductId");
        cartItems = (List<CartItem>)session.getAttribute("cartItems");
        if(lastProductId == null){
            lastProductId = (long)1;
        }
        if(cartItems == null){
            cartItems = new ArrayList<>();
        }
    }

    public void addToCart(CartItem item){
        Objects.requireNonNull(item, "CartItem cannot be null");
        int i = 0;
        for (; i < cartItems.size(); i++){
            if(cartItems.get(i).getProduct().getId() == item.getProduct().getId()){
                cartItems.get(i).setQuantity(cartItems.get(i).getQuantity() + item.getQuantity());
                break;
            }
        }

        if(i == cartItems.size()){
            cartItems.add(item);
        }
    }

    public void removeOnePiece(Long id){
        for(CartItem c : cartItems){
            if(c.getProduct().getId() == id){
                c.setQuantity(c.getQuantity() - 1);
                break;
            }
        }
    }

    public void addOnePiece(Long id){
        for(CartItem c : cartItems){
            if(c.getProduct().getId() == id){
                c.setQuantity(c.getQuantity() + 1);
                break;
            }
        }
    }

    public void removeProduct(Long id){
        for(CartItem c : cartItems){
            if(c.getProduct().getId() == id){
                c.setQuantity(0);
                break;
            }
        }
    }

    public Long getLastProductId(){
        return lastProductId;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {

        int amountPositions;
        int amountProducts;
        double value;

        amountPositions = cartItems.size();
        amountProducts = cartItems.stream()
                .mapToInt(CartItem::getQuantity)     //.mapToInt(c -> c.getQuantity())
                .sum();
        value = cartItems.stream()
                .mapToDouble(c -> {
                    return c.getQuantity() * c.getProduct().getPrice();
                })
                .sum();

        return "W koszyku jest <" + amountPositions + "> pozycji.\n" + "W koszyku jest <" + amountProducts + "> produktów.\n" +
                "Wartość koszyka to: <" + value + ">.";
    }
}
