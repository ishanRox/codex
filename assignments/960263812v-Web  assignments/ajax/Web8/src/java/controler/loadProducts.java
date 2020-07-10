
package controler;

import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class loadProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        try {
            SessionFactory sessionFactory=NewHibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            
            Criteria criteria=session.createCriteria(Product.class);
            
            List<Product> p_list=criteria.list();
            
            req.setAttribute("p_list",p_list);
            
            RequestDispatcher rd=req.getRequestDispatcher("productView.jsp");
            rd.forward(req, resp);
            
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    
    
    
}
