/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.sun.xml.ws.api.model.ExceptionType;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IshanVimukthi
 */
public class loaduser extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            database.User u=(database.User) request.getSession().getAttribute("u");
              PrintWriter pw=response.getWriter();
            if(u!=null){
                
                SessionFactory sf=NewHibernateUtil.getSessionFactory();
                Session s=sf.openSession();
                
                Criteria c=s.createCriteria(User.class);
                c.add(Restrictions.ne("mobile", u.getMobile()));
                List<User> list = c.list();
              
                
                
                for (User user : list) {
                    
                    System.out.println(user.getMobile());
                  pw.write("<option>"+user.getMobile()+"</option>");
                    
                }
            
            }else{
               pw.write("1");
                
            
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }

}
