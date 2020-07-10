package database;
// Generated Nov 1, 2019 2:43:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Seller generated by hbm2java
 */
public class Seller  implements java.io.Serializable {


     private Integer id;
     private String name;
     private int mobile;
     private String gender;
     private String city;
     private Set<Product> products = new HashSet<Product>(0);

    public Seller() {
    }

	
    public Seller(String name, int mobile, String gender, String city) {
        this.name = name;
        this.mobile = mobile;
        this.gender = gender;
        this.city = city;
    }
    public Seller(String name, int mobile, String gender, String city, Set<Product> products) {
       this.name = name;
       this.mobile = mobile;
       this.gender = gender;
       this.city = city;
       this.products = products;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public int getMobile() {
        return this.mobile;
    }
    
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


