package MuhammadKoku.jfood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static MuhammadKoku.jfood.DatabaseConnectionPostgre.connection;

public class DatabaseCustomerPostgre {
    public static Customer insertCustomer(Customer customer) {
        Connection c = connection();
        PreparedStatement pstmt;
        try {
            c.setAutoCommit(false);
            String name = customer.getName();
            String email = customer.getEmail();
            String password = customer.getPassword();
            String sql = "INSERT INTO customer (name, email, password) " + "VALUES ('"+name+"','"+email+"','"+password+"');";
            pstmt = c.prepareStatement(sql);
            pstmt.executeUpdate();
            pstmt.close();
            c.commit();
            c.close();
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getCustomerLastId(){
        Connection c = connection();
        PreparedStatement pstmt;
        int id = 0;
        try {
            String sql = "SELECT id from customer;";
            pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            pstmt.close();
            c.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public static Customer getCustomerById(int id_custumer){
        Connection c = connection();
        PreparedStatement pstmt;
        Customer customer = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String date;
        Calendar cal = null;
        try {
            String sql = "SELECT * FROM customer WHERE id = '"+id_custumer+"';";
            pstmt = c.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                id = rs.getInt("id");
                name = rs.getString("name");
                email  = rs.getString("email");
                password = rs.getString("password");
                date = rs.getString("joindate");
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                cal = Calendar.getInstance();
                cal.setTime(df.parse(date));
            }
            rs.close();
            pstmt.close();
            c.close();
            customer = new Customer(id, name, email, password, cal);
            return customer;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeCustomer(int id){
        Connection c = connection();
        PreparedStatement pstmt;
        try {
            String sql = "DELETE FROM customer WHERE id = "+id+";";
            pstmt = c.prepareStatement(sql);
            pstmt.execute();
            pstmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Customer getCustomerLogin(String emailParam, String passwordParam)
    {
        Connection c = connection();
        PreparedStatement stmt;
        Customer customer = null;
        int id = 0;
        String name = null;
        String email = null;
        String password = null;
        String date;
        Calendar cal = null;
        try {
            c.setAutoCommit(false);
            String sql = "SELECT * FROM customer WHERE email = '"+emailParam+"' AND password = '"+passwordParam+"';";
            stmt = c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                id = rs.getInt("id");
                name = rs.getString("name");
                email  = rs.getString("email");
                password = rs.getString("password");
                date = rs.getString("joindate");
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                cal = Calendar.getInstance();
                cal.setTime(df.parse(date));
            }
            rs.close();
            stmt.close();
            c.close();
            //Check if response is null
            if (id == 0){
                return null;
            }
            else{
                customer = new Customer(id, name, email, password, cal);
                return customer;
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }


}
