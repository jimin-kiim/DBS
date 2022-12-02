//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

public class DeliveryService {
static final String DB_URL = "jdbc:mysql://localhost/DeliveryService?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone= UTC";
static final String USER = "root"; 
static final String PASS = "wlalsdlqslek!"; 
static final String QUERY = "select * from menu";

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
//	 while () {
//			String line = input.nextLine();
//			
//			if (line.matches("//.*")||line.isEmpty()){
//				continue;
//			}
//			
//			String[] strings = line.split("[;,]",5);
//			//";|,"도 되고 "[;,]"도 된다. 
//
//			try {
//				String str = strings[1].trim();
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
//				LocalDateTime.parse(str, formatter);
//			}catch(Exception e){
//				System.out.println("Date Format Error -> No Created Time invalid Bookmark info line: "
//			+strings[0]+","+strings[1]+","+strings[2]+","+strings[3]+","+strings[4]);
//				break;
//			}
//			
//			String url=strings[2].trim();
//			if (url.isEmpty()) {
//				System.out.println("MalformedURLException: wrong URL - No URL ; invalid Bookmark info line: "
//						+strings[0]+","+strings[1]+","+strings[2]+","+strings[3]+","+strings[4]);
//				break;
//			}
//			
//			Bookmark bookmark = new Bookmark(url);
//			bookmark.name=strings[0].trim();
//			bookmark.groupName=strings[3].trim();
//			bookmark.memo=strings[4].trim();
//			this.addBookmarkList(bookmark);
//		 
//
//			
//			Connection conn = null;
//			Statement stmt = null;
//			ResultSet rs = null;
//			PreparedStatement pstmt = null;
//			try {
//				conn = DriverManager.getConnection(DB_URL,USER,PASS);
//				stmt = conn.createStatement();
//				rs = stmt.executeQuery(QUERY);
//				int menuNum = 1;
//				while(rs.next()) {
//					System.out.println("Menu"+ menuNum + 
//							" id: " + rs.getInt("id") + 
//							" name: "+ rs.getString("name") + 
//							" restaurant: " + rs.getString("restaurant") +
//							" price: " + rs.getInt("price") +
//							" description: " + rs.getString("description") +
//							" image_url: " + rs.getString("image_url")
//				);
//					menuNum++;
//				}
//				
//				rs.close();
//				
//				System.out.println("====================================");
//				String sql = "insert into menu values(?,?,?,?,?,?)";
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setInt(1,20220003);
//				pstmt.setString(2, "basic custom");
//				pstmt.setString(3, "custom yogurt");
//				pstmt.setInt(4, 5900);
//				pstmt.setString(5, "cinnamon powder, apple, granola, dried fig, banana");
//				pstmt.setString(6, "https://mblogthumb-phinf.pstatic.net/MjAyMTEyMzFfMTMx/MDAxNjQwOTIOOTkMj01.ezziNFgjaYyRLqyTrg10F3LTU-kTZyDbaUXyu6Xopjcg.hxZTv6q561qq5anXDYk6_1ypeV7dkH7cHpU8V49]]v8g.PNG.customyogurt77/image.png?type=w800");
//				pstmt.executeUpdate();
//				
//				rs = stmt.executeQuery(QUERY);
//				menuNum = 1;
//				while(rs.next()) {
//					System.out.println("Menu"+ menuNum + 
//							" id: " + rs.getInt("id") + 
//							" name: "+ rs.getString("name") + 
//							" restaurant: " + rs.getString("restaurant") +
//							" price: " + rs.getInt("price") +
//							" description: " + rs.getString("description") +
//							" image_url: " + rs.getString("image_url")
//				);
//					menuNum++;
//				}
//			}catch(SQLException e) {
//				System.out.println("SQLException : "+e);
//			}finally {
//				try {
//					rs.close();
//					stmt.close();
//					pstmt.close();
//					conn.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
}

public void searchReviews(){
	System.out.println("searchReviews");
	
}
}