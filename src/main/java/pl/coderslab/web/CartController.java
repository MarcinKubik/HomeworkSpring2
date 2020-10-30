package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Cart;
import pl.coderslab.domain.CartItem;
import pl.coderslab.domain.Product;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@SessionAttributes({"lastProductId", "cartItems", "lastProductId"})
public class CartController {

    private Cart cart;

    @Autowired
    public CartController(Cart cart){
        this.cart = cart;
    }

    @GetMapping("/addtocart")
    public String showForm() {

        return "addToCartForm";
    }

    @PostMapping("/addtocart")
    public String addToCart(@RequestParam String productName, @RequestParam Double productPrice, @RequestParam int quantity, @RequestParam Long id,
                            Model model, HttpSession session){
        List<CartItem> cartItems = cart.getCartItems();
       // Long lastProductId = cart.getLastProductId();
        Product product = new Product(productName, productPrice, id);
        CartItem cartItem = new CartItem(quantity, product);
        cart.addToCart(cartItem);
        model.addAttribute("cartItems", cartItems);
       // model.addAttribute("lastProductId", lastProductId + 1);

        return "showCart";
    }

    @GetMapping("/removeOnePiece")
    public String removeOnePiece(@RequestParam Long id){
        cart.removeOnePiece(id);
        return "showCart";
    }

    @GetMapping("/addOnePiece")
    public String addOnePiece(@RequestParam Long id){
        cart.addOnePiece(id);
        return "showCart";
    }

    @GetMapping("/removeProduct")
    public String removeProduct(@RequestParam Long id){
        cart.removeProduct(id);
        return "showCart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String displayCart(){
        return cart.toString();
    }

}
