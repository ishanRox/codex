
package controler;

import database.Customer;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class signIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        try {
            resp.setContentType("text/html;charset=UTF-8");
            
            String un=req.getParameter("un");
            String pw=req.getParameter("pw");

            System.out.println(un);
            System.out.println(pw);
            
            SessionFactory sessionFactory=NewHibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();

            Criteria criteria=session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("username", un));
            criteria.add(Restrictions.eq("password", pw));

            List<Customer> customer=criteria.list();
            
            PrintWriter pwr=resp.getWriter();
            
            if(customer.isEmpty()){
                //user not found
                pwr.write("0");
            }else{
                //user found
                pwr.write("1");
                HttpSession ses=req.getSession();
                Customer c=customer.get(0);
                ses.setAttribute("customer", c);
            }
            
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
   
}
