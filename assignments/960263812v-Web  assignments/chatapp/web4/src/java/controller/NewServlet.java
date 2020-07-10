/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
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
public class NewServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SessionFactory sessionFactory= NewHibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            database.User u= new database.User();
            u.setName("koiLP");
            u.setMobile(9800);
            session.save(u);
            
//             u.setName("dinuka");
//            u.setMobile(9090);
//            session.update(u);
            
            
//            u.setMobile(9090);
//            session.delete(u);
            
            
            Transaction t=session.beginTransaction();
            t.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
}
