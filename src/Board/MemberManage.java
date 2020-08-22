package Board;
 
import java.util.ArrayList;

public class MemberManage {
	ArrayList<Article> members = new ArrayList<>();
	
	void signup(Article member) {
		members.add(member);
	}
	
	ArrayList<Article> memberData() {
		return members;
	}
	
	int getIndexById(int id) {
		for(int i = 0; i < members.size(); i++) {
			if(id == members.get(i).getId()) {
				return i;
			}
		}
		
		return -1;
	}
	
	void Login(String id, String pw) {

		if(LoginManage(id, pw) == -1) {
			for(int i = 0; i < members.size(); i++) {
				Article member = members.get(i);
				if(member.getMember().equals(id)) {
					if(member.getPassword().equals(pw)) {
						System.out.println(member.getName() + "님! 환영합니다.");
					}
			}
			}
		}
		
			else if(LoginManage(id, pw) == 0) {
			System.out.println("틀린 비밀번호입니다.");
		}
		
		else if(LoginManage(id, pw) == 1) {
			System.out.println("틀린 아이디입니다.");
		}
	}
	
	int LoginManage(String id, String pw) {
		
		int index;
		
		for(int i = 0; i < members.size(); i++) {
			Article member = members.get(i);
			if(member.getMember().equals(id)) {
				if(member.getPassword().equals(pw)) {
					return -1;
				}
				else {
					return 0;
				}
			}
			else {
				return 1;
			}
		}
		
		return 10;
	}
}