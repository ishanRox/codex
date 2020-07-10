

package controler;

import database.Cart;
import database.Customer;
import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class addToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String id=req.getParameter("id");
        String qty=req.getParameter("qty");

        if(req.getSession().getAttribute("customer")!=null){
            //user loged
            Customer customer=(Customer)req.getSession().getAttribute("customer");
            
            SessionFactory sessionFactory=NewHibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();

            Product product =(Product)session.load(Product.class, Integer.parseInt(id));

            Cart cart=new Cart();
            cart.setCustomer(customer);
            cart.setProduct(product);
            cart.setQty(Integer.parseInt(qty));

            session.save(cart);//save on session tempory
            session.beginTransaction().commit();//permenata session save

            session.close();
            
        }else{
            //session cart
            
            
            
        }
        
        
    }

    
    
}
