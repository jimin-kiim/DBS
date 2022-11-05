import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeliveryService {static final String DB_URL = "jdbc:mysql://localhost/delivery_service?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone= UTC";
static final String USER = "root"; 
static final String PASS = "wlalsdlqslek!"; 
static final String QUERY = "select * from menu"; 


public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	try {
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(QUERY);
		int menuNum = 1;
		while(rs.next()) {
			System.out.println("Menu"+ menuNum + " name = "+ rs.getString("name"));
			menuNum++;
		}
		System.out.println("====================================");
		String sql = "insert into menu values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,"20220006");
		pstmt.setString(2, "얼큰국밥");
		pstmt.setString(3, "더진국");
		pstmt.setInt(4, 9000);
		pstmt.setString(5, "얼큰한 맛의 순대, 수육 국밥");
		pstmt.setString(6, "https://thejincook.com/upload/menu_01/2019_05_10/hero_SRGKA_2019_05_10_16_06_36.jpg");
		pstmt.executeUpdate();
		
		rs = stmt.executeQuery(QUERY);
		menuNum = 1;
		while(rs.next()) {
			System.out.println("Menu"+ menuNum + " name = "+ rs.getString("name"));
			menuNum++;
		}
	}catch(SQLException e) {
		System.out.println("SQLException : "+e);
	}finally {
		try {
			rs.close();
			stmt.close();
			pstmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}