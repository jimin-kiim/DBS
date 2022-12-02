import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeliveryService {
static final String DB_URL = "jdbc:mysql://localhost/DeliveryService?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone= UTC";
static final String USER = "root"; 
static final String PASS = "wlalsdlqslek!"; 

public void execute() {
	boolean flag = true;
	Scanner sc = new Scanner(System.in);
	
	while(flag) {
		System.out.println("수행할 기능을 선택해주세요. ");
		System.out.println("1. 1인 메뉴 주문 가능한 음식점 검색 ");
		System.out.println("2. 작성한 리뷰 검색 ");
		System.out.println("3. 종료 ");
		
		int user_input = sc.nextInt(); // 배열 원소 개수
	    sc.nextLine(); // 버퍼 비우기
		
	    switch (user_input) {	
		case 1:	
			searchRestaurants();
			break;
		case 2:		
			searchReviews();
			break; 
		case 3:		
			flag = false;
			break;
		default:
			System.out.println("잘못된 입력입니다.");
		}
	}
}


public void searchRestaurants(){
	System.out.println("searchRestaurants.");
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	try {
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		
		System.out.println("====================================");
		String sql = "select * "
				+ "from restaurant "
				+ "where is_one_person_set_available in "
					+ "(select is_one_person_set_available "
					+ "from restaurant "
					+ "where category = ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 0);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					"이름: "+ rs.getString("name") + 
					" 위치: " + rs.getString("location") +
					" 영업 시간 정보: " + rs.getString("opening_hours_info") +
					" 연락처: " + rs.getString("telephone") +
					" 최소 주문 금액: " + rs.getInt("min_order_amount") +"원"
		);
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

public void searchReviews(){
	System.out.println("searchReviews");
	
}
}