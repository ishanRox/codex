/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Messege;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IshanVimukthi
 */
public class viewchat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session se = sf.openSession();

        User u = (User) request.getSession().getAttribute("u");
        String mobile2 = request.getParameter("mobile2");

        User u_to = (User) se.load(User.class, Integer.parseInt(mobile2));

        Criteria c = se.createCriteria(Messege.class);
        Criterion c1 = Restrictions.eq("userByFrommsg", u);
        Criterion c2 = Restrictions.eq("userByTomsg", u_to);

        Criterion c3 = Restrictions.eq("userByFrommsg", u_to);
        Criterion c4 = Restrictions.eq("userByTomsg", u);

        Criterion c5 = Restrictions.and(c1, c2);
        Criterion c6 = Restrictions.and(c3, c4);

       c.add(Restrictions.or(c5, c6));
        
   
        //c.addOrder(Order.asc("datetime"));
        
        List<Messege> list = c.list();

        String resp = " ";
        String from;
        for (Messege messege : list) {
            if (String.valueOf(messege.getUserByFrommsg().getMobile()).equals(u.getMobile())) {
                from = "you";
            } else {

                from = messege.getUserByFrommsg().getMobile() + "&" + messege.getUserByFrommsg().getName();
            }
            resp += "<br><br>"
                    
                    +"FROM :"+from
                   
                    +"<p>"
                    +messege.getMessege()
                    +"</p>"
                             +"<br>"
                    +"Date time:"+messege.getDatetime()
            +"                          ";
                                

         
         
        }
        
        response.getWriter().write(resp);
se.close();
//        System.out.println(u.getMobile()+mobile2);
//        response.getWriter().write("loading");
    }


}
