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
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author IshanVimukthi
 */
public class savemessege extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            PrintWriter pw=response.getWriter();
           String t=request.getParameter("to");
           String m=request.getParameter("msg");
             System.out.println(t+m);
             
           User u_from=(User) request.getSession().getAttribute("u");
           SessionFactory f=NewHibernateUtil.getSessionFactory();
            Session se=f.openSession();
            
            Messege chat=new Messege();
            chat.setUserByFrommsg(u_from);
            
           User u_to=(User) se.load(User.class, Integer.parseInt(t));
           
           chat.setUserByTomsg(u_to);
           
           chat.setMessege(m);
           Date d=new Date();
           chat.setDatetime(d);
           
           se.save(chat);
           Transaction tr=se.beginTransaction();
            tr.commit();
               
          
            pw.write("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
