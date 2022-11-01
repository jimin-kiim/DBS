import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;


public class JDBC_Example {
	static final String DB_URL = "jdbc:mysql://localhost/causw?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone= UTC";
	static final String USER = "root"; 
	static final String PASS = "wlalsdlqslek!"; 
//	static final String QUERY = "select name from student where dept = 'CSE'"; 

	
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(QUERY);
//			int studentNum = 1;
//			while(rs.next()) {
//				System.out.println("Student"+ studentNum + "name = "+ rs.getString("name"));
//				studentNum++;
//			}
			String sql = "insert into student values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"20150008");
			pstmt.setString(2, "Cho");
			pstmt.setInt(3, 15);
			pstmt.setString(4, "CSE");
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("SQLException : "+e);
		}finally {
			try {
//				rs.close();
//				stmt.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
