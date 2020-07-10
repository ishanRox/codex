/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.NewHibernateUtil;
import database.User;
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

/**
 *
 * @author IshanVimukthi
 */
public class signin extends HttpServlet {

    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String mobile=request.getParameter("mobile");
            String password=request.getParameter("password");
            
            System.out.println(mobile);
            System.out.println(password);
            
            SessionFactory f=NewHibernateUtil.getSessionFactory();
            Session se=f.openSession();
            
            Criteria c=se.createCriteria(User.class);
            c.add(Restrictions.eq("mobile",Integer.parseInt(mobile) ));
            c.add(Restrictions.eq("password", password));
            List<User> list = c.list();
              PrintWriter j=response.getWriter();
            
            if(list.isEmpty()){
                j.write("1");
                System.out.println("user account not availble");
            
            }else{
                j.write("2");
                
                HttpSession hs=request.getSession();
              User u =list.get(0);
              hs.setAttribute("u", u);             
                
            
            }
            
          
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

}
