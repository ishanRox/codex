/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import database.NewHibernateUtil;
import database.Product;
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
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IshanVimukthi
 */
public class LoadProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            PrintWriter writer = resp.getWriter();
            String brand_name = req.getParameter("brand_name");
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("brand", brand_name));
            criteria.setProjection(Projections.distinct(Projections.property("model")));

            List<String> model_name_list = criteria.list();
            writer.write("<option>Select Model</option>");
            for (String string : model_name_list) {
                    writer.write("<option>"+string+"</option>");
            }
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
