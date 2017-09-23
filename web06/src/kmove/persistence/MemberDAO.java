package kmove.persistence;
import java.util.List;
import kmove.domain.MemberVO;
public interface MemberDAO {
	List<MemberVO> selectList() throws Exception;
}
