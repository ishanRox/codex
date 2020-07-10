/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Vector;

/**
 *
 * @author Acer
 */
public class User {
    public static Vector user_list;
    private String nic;
    private String name;
    private String uname;
    private String password;

    public User(String nic, String name, String uname, String password) {
        this.nic = nic;
        this.name = name;
        this.uname = uname;
        this.password = password;
        if (user_list==null) {
            user_list=new Vector();
        }
    }

    public static Vector getUser_list() {
        return user_list;
    }

    public static void setUser_list(Vector user_list) {
        User.user_list = user_list;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
