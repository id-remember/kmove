package kmove.persistence;
import java.sql.*;
import javax.sql.DataSource;
import java.util.*;
import kmove.controller.Component;
import kmove.domain.MemberVO;
@Component("memberDAO")
public class MemberDAOImple implements MemberDAO {
	DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
	    this.dataSource = dataSource;
	  }
	public List<MemberVO> selectList() throws Exception {
		try {
			Connection conn = dataSource.getConnection();
			Statement sql = conn.createStatement();
			ResultSet resultSet = sql.executeQuery("select * from members");
			ArrayList<MemberVO> members = new ArrayList<MemberVO>();
			MemberVO member = new MemberVO();
			while(resultSet.next()) {
				member.setMname(resultSet.getString("mname"));
				member.setEmail(resultSet.getString("email"));
				members.add(member);
			}
			return members;
		} catch (Exception e) { throw e; }
	}
}
