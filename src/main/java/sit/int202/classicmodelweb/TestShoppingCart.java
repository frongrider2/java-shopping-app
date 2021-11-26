package sit.int202.classicmodelweb;

import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.ProductRepository;

public class TestShoppingCart {
    public static void main(String[] args) {
        Cart<String, ClassicModelLineItem> cart = new Cart<>();
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.findProduct("S10_1678");
        cart.addItem(product.getId(), new ClassicModelLineItem(product,5));
        product = productRepository.findProduct("S12_3380");
        cart.addItem(product.getId(), new ClassicModelLineItem(product));
        System.out.println(cart.countItem());
        System.out.println(cart.countPiece());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItem());
        cart.removeItem("S10_1678");
        System.out.println(cart.countItem());
        System.out.println(cart.countPiece());
        System.out.println(cart.getTotalPrice());
        System.out.println(cart.getAllItem());
    }
}
