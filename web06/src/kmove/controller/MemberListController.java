package kmove.controller;
import java.util.Map;
import kmove.persistence.MemberDAO;
@Component("/list.do")
public class MemberListController implements Controller {
  MemberDAO memberDAO;
  public MemberListController setMemberDAO(MemberDAO memberDAO) {
    this.memberDAO = memberDAO;
    return this;
  }
  public String execute(Map<String, Object> model) throws Exception {
    model.put("members", memberDAO.selectList());
    return "/MemberList.jsp";
  }
}