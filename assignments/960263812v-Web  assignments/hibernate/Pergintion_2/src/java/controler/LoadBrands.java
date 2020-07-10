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

/**
 *
 * @author IshanVimukthi
 */
public class LoadBrands extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            PrintWriter writer = resp.getWriter();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Product.class);
            criteria.setProjection(Projections.distinct(Projections.property("brand")));

            writer.write("<option>Select Brand</option>");
            List<String> brand_name_list = criteria.list();
            for (String string : brand_name_list) {
                    writer.write("<option>"+string+"</option>");
            }
            
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
