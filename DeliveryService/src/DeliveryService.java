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
static final Scanner sc = new Scanner(System.in);

public void execute() {
	boolean flag = true;

	while(flag) {
		System.out.println("수행할 기능을 선택해주세요. ");
		System.out.println("");
		System.out.println("1. 1인 메뉴 주문이 가능한 음식점 검색하기");
		System.out.println("2. 특정 고객이 작성한 리뷰 검색하기 ");
		System.out.println("3. 종료 ");
		System.out.println(">>");
		
		int user_input = sc.nextInt(); 
	    sc.nextLine(); 
		
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
	    System.out.println("");
	}
	System.out.println("종료");
}


public void searchRestaurants(){
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	try {
		System.out.println("");
		System.out.println("1. 1인 메뉴 주문 가능한 음식점 검색 기능입니다.");
		System.out.println("음식점 분류를 선택해주세요. ");
		System.out.println("");
		System.out.println("0. 한식 ");
		System.out.println("1. 양식 ");
		System.out.println("2. 중식 ");
		System.out.println("3. 일식 ");
		System.out.println(">>");
		
		int user_input = sc.nextInt(); 
	    sc.nextLine(); 
	    
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		
		System.out.println("====================================");
		String sql = "select * "
				+ "from restaurant "
				+ "where is_one_person_set_available = 1 and category = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_input);
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
		System.out.println("====================================");
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
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	try {
		System.out.println("");
		System.out.println("2. 작성한 리뷰를 검색하는 기능입니다. ");
		System.out.println("작성자(고객)의 이름을 입력해주세요. >>");
		String user_input = sc.nextLine(); 
	    sc.nextLine(); 
	    
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		stmt = conn.createStatement();
		
		System.out.println("====================================");
		String sql = "select * "
				+ "from review "
				+ "where writer_id in "
					+ "(select id "
					+ "from customer "
					+ "where name = ?)"
					+ "order by created_at desc";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_input);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(
					" 작성시간: " + rs.getString("created_at") +
					" 별점: " + rs.getInt("rating") +
					" 내용: " + rs.getString("contents") +
					" 첨부 사진: " + rs.getString("image_url")
		);
		}
		System.out.println("====================================");
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