package Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Connect_database {
    public static Connection databaselink;

    public static Connection getConnection() {

        String Username = "root";
        String Password = "khanh6112005";
        String url = "jdbc:mysql://localhost:3306/qltv" ;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, Username, Password);
        } catch ( Exception e) {
            e.printStackTrace();
           e.getCause();
        }

        return databaselink;
    }
	
	public  static boolean login(String user, String pass) {
		Connection databaselink = getConnection();
		boolean kq = false;
		String sql_login = "select *from admin where username = ? and password = ?;";
		try {
			PreparedStatement ps = databaselink.prepareStatement(sql_login);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				kq = true;
			}
		} catch (Exception e) {
			return false;
		}
		return kq;
		

	}
	public static void main(String[] args) {

	}
	

}
