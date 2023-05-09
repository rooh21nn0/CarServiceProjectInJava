
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DB_Connection {

    Connection con;
    Statement st;
    ResultSet rs;

    DB_Connection() throws SQLException {
           Connection con = null ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            st = con.createStatement();
            System.out.println(" Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

////    vehicle manger add data
//    public void vehicleData(String name, String cnic, String owner,String model) {
//        try {
//            String sql = "INSERT INTO `vehicledetails`(`vehicleNum`, `CNIC`, `OwnerName`, `vehicleModel`) VALUES ('"+name+"','"+cnic+"','"+owner+"','"+model+"')";
//            st.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public void userSignUp(String username, String userEmail, int userCont, String userPass) {
        String sql = "INSERT INTO usersignup(userName, userEmail, userContact, userPass) VALUES ('" + username + "','" + userEmail + "','" + userCont + "','" + userPass + "')";
        try {
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    public ResultSet userLogin(String userLog, String userPassword) {
        try {
            ResultSet rs;
            String pass = "SELECT * FROM `usersignup` WHERE `userName`='" + userLog + "' and `userPass`='" + userPassword + "'";
//     st.execute(pass);
            rs = st.executeQuery(pass);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

//    public void custManager(String name, String email, String addres) {
//        try {
//            String sql = "INSERT INTO `customermanage`(`custName`, `custAddress`, `custEmail`, `custDate`) VALUES ('" + name + "','" + addres + "','" + email + "','[value-4]')";
//            st.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    GetCustomer
    public ResultSet geCustomer() {
        try {
            String sql = "SELECT * FROM `customermanage`";
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void DeletecustManager(String name, String email, String addres) {
        try {
            String sql = "DELETE FROM `customermanage` WHERE custName = '" + name + "'";
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Record is deleted!");
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
