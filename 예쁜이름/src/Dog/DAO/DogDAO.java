package Dog.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dog.Vo.DogVO;

/*
 * 등록(R), 목록(C), 수정(U), 삭제(D) 
 * 주의 : DAO 메세지(System.out.println)가 없음.
 */
public class DogDAO extends DAO {
	public List<DogVO> selectList() { // 목록1
		String sql = "select * from A_Doglist order by Dog_choday";
		List<DogVO> list = new ArrayList<>();
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DogVO svo = new DogVO();

				svo.setDog_choday(rs.getString("Dog_choday"));
				svo.setDog_useday(rs.getString("Dog_useday"));
				svo.setDog_outday(rs.getString("Dog_outday"));
				svo.setDog_roomname(rs.getString("Dog_roomname"));
				svo.setDog_user(rs.getString("Dog_user"));
				svo.setDog_mansu(rs.getString("Dog_mansu"));
				svo.setDog_dogsu(rs.getInt("Dog_dogsu"));
				svo.setDog_pmoney(rs.getInt("Dog_pmoney"));
				svo.setCreation_date(rs.getDate("creation_date"));
				list.add(svo);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	} // end of selectList

	public List<DogVO> selectList2() { // 목록2 (객실정보)
		String sql = "select * from B_Room order by Room_name";
		List<DogVO> list = new ArrayList<>();
		conn = getConn();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DogVO svo = new DogVO();

				svo.setRoom_name(rs.getString("Room_name"));
				svo.setRoom_maxman(rs.getString("Room_maxman"));
				svo.setRoom_maxdog(rs.getString("Room_maxdog"));
				svo.setRoom_price(rs.getString("Room_price"));
				

				list.add(svo);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
	// 예약 달력

	public int resCheck(String resRoom, String check) {
		String sql = "select count(1)\r\n" + "    from A_Doglist\r\n"
				+ "    where TO_DATE(?, 'mm-dd') between TO_DATE (Dog_choday, 'mm-dd') AND TO_DATE(Dog_outday, 'mm-dd')\r\n"
				+ "    and Dog_roomname = ?\r\n";

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, check);
			psmt.setString(2, resRoom);

			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1); // 1번은 가지고 온 첫번째 컬럼을 가지고 온다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 예약

	public boolean insertDog(DogVO svo) {
		String sql = "INSERT INTO A_Doglist( Dog_roomname, dog_user, Dog_password, Dog_choday, Dog_useday, Dog_outday, Dog_mansu, Dog_dogsu, Dog_pmoney)\r\n"
				+ "VALUES (?,?,?,?"
				+ ",?,?,?,?,?)";
	

		conn = getConn();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, svo.getDog_roomname());
			psmt.setString(2, svo.getDog_user());
			psmt.setString(3, svo.getDog_password());
			psmt.setString(4, svo.getDog_choday());
			psmt.setString(5, svo.getDog_useday());
			psmt.setString(6, svo.getDog_outday());
			psmt.setString(7, svo.getDog_mansu());
			psmt.setInt(8, svo.getDog_dogsu());
			psmt.setInt(9, svo.getDog_pmoney());
			

			int r = psmt.executeUpdate(); // 쿼리실행.
			if (r == 1) {
				return true; // 정상처리
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
