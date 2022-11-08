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
			System.out.println("Menu"+ menuNum + 
					" id: " + rs.getInt("id") + 
					" name: "+ rs.getString("name") + 
					" restaurant: " + rs.getString("restaurant") +
					" price: " + rs.getInt("price") +
					" description: " + rs.getString("description") +
					" image_url: " + rs.getString("image_url")
		);
			menuNum++;
		}
		
		rs.close();
		
		System.out.println("====================================");
		String sql = "insert into menu values(?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,20220003);
		pstmt.setString(2, "basic custom");
		pstmt.setString(3, "custom yogurt");
		pstmt.setInt(4, 5900);
		pstmt.setString(5, "cinnamon powder, apple, granola, dried fig, banana");
		pstmt.setString(6, "https://mblogthumb-phinf.pstatic.net/MjAyMTEyMzFfMTMx/MDAxNjQwOTIOOTkMj01.ezziNFgjaYyRLqyTrg10F3LTU-kTZyDbaUXyu6Xopjcg.hxZTv6q561qq5anXDYk6_1ypeV7dkH7cHpU8V49]]v8g.PNG.customyogurt77/image.png?type=w800");
		pstmt.executeUpdate();
		
		rs = stmt.executeQuery(QUERY);
		menuNum = 1;
		while(rs.next()) {
			System.out.println("Menu"+ menuNum + 
					" id: " + rs.getInt("id") + 
					" name: "+ rs.getString("name") + 
					" restaurant: " + rs.getString("restaurant") +
					" price: " + rs.getInt("price") +
					" description: " + rs.getString("description") +
					" image_url: " + rs.getString("image_url")
		);
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