package controler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import database.NewHibernateUtil;
import database.Product;
import database.Seller;
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
import org.hibernate.criterion.Restrictions;

public class LoadSellerDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String seller_id = req.getParameter("seller_id");
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Seller seller = (Seller) session.load(Seller.class, Integer.parseInt(seller_id));
            
            
//            Criteria criteria = session.createCriteria(Seller.class);
//            criteria.add(Restrictions.eq("id", seller_id));
//            
//            Seller seller = (Seller) criteria.uniqueResult();
            
            // we can easially use JSON 
//            req.setAttribute("seller", seller);
//            
//            RequestDispatcher dispatcher = req.getRequestDispatcher("SellerDetailsTemp.jsp");
//            dispatcher.include(req, resp);
            
            Gson gson = new Gson();
            //String gsoString = gson.toJson(seller); // cannot convert java object to JSON direclty
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", seller.getName());
            jsonObject.addProperty("gender", seller.getGender());
            jsonObject.addProperty("mobile", seller.getMobile());
            jsonObject.addProperty("city", seller.getCity());
            resp.getWriter().write(gson.toJson(jsonObject));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
