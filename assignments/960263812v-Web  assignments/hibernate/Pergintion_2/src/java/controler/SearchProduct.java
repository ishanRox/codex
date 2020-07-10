package controler;

import database.NewHibernateUtil;
import database.Product;
import database.Seller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class SearchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String brand = req.getParameter("brand");
            String model = req.getParameter("model");
            String price_from = req.getParameter("price_from");
            String price_to = req.getParameter("price_to");
            String feature = req.getParameter("feature");
            String location = req.getParameter("location");
            String order_by = req.getParameter("order_by").trim();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Product.class);
            if(!brand.equals("Select Brand")){
            criteria.add(Restrictions.eq("brand", brand));
            }
            
            if (!"Select Model".equals(model)) {
                criteria.add(Restrictions.eq("model", model));
            }

            double from = 0;
            if (!price_from.isEmpty()) {
                try {
                    from = Double.parseDouble(price_from);
                    criteria.add(Restrictions.ge("price", from));
                } catch (Exception e) {

                }
            }

            double to = 0;
            if (!price_to.isEmpty()) {
                try {
                    to = Double.parseDouble(price_to);
                    if (to > from) {
                        criteria.add(Restrictions.le("price", to));
                    }
                } catch (Exception e) {

                }
            }

            criteria.add(Restrictions.like("disc", feature, MatchMode.ANYWHERE));

            if (order_by.equals("Price Low to High")) {
                criteria.addOrder(Order.asc("price"));
            } else if (order_by.equals("Price High to Low")) {
                criteria.addOrder(Order.desc("price"));
            } else if (order_by.equals("Model ASC")) {
                criteria.addOrder(Order.asc("model"));
            } else {
                criteria.addOrder(Order.desc("model"));
            }

            if (!location.equals("Select Location")) {

                Criteria criteria2 = session.createCriteria(Seller.class);
                criteria2.add(Restrictions.eq("city", location));
                List<Seller> seller_list = criteria2.list();
                criteria.add(Restrictions.in("seller", seller_list));
            }

            List<Product> products = criteria.list();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("productsViewTemp.jsp");
            dispatcher.include(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
