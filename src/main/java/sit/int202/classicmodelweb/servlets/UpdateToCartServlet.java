package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.io.IOException;

@WebServlet(name = "UpdateToCartServlet", value = "/update-to-cart")
public class UpdateToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.findProduct(productCode);
        if (product != null) {
            if(type.equals("remove")){
                cart.removeItem(productCode);
            }
            else if(type.equals("add")){
                cart.addItem(productCode,new ClassicModelLineItem(product));
            }
            else if(type.equals("reduce")){
                cart.reduceItem(productCode, new ClassicModelLineItem(product));
            }
        }
        response.getWriter().print(cart.countPiece());
    }
}
