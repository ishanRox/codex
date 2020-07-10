/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IshanVimukthi
 */
public class B extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SessionFactory sessionFactory= NewHibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            
//          database.User u=(database.User) session.load(User.class, 9800);
//          System.out.println(u.getName());
            
            Criteria c=session.createCriteria(User.class);
            c.add(Restrictions.eq("city", "colombo"));
        List<User> list = c.list();
        
        for (User user : list) {
            
            System.out.println(user.getName());
            
        }
            
//            Query query=session.createQuery("from User");
//            List<User> list = query.list();
//             for (User user : list) {
//            
//            System.out.println(user.getName());
//            
//        }
            
            
                    
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
