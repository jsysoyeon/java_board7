 package Board;

import java.util.Scanner;

public class Member {
	
	MemberManage mm = new MemberManage();
	ArticleManage am = new ArticleManage();
	ArticleDao dao = new ArticleDao();
	
	public void start() {

		Scanner sc = new Scanner(System.in);
		String Id;
		String Pw;
		String name;
		
		while(true) {
			System.out.println("로그인 : login / 회원가입 : signup");
			
			String s = sc.nextLine();
			
			if(s.equals("signup")) {
				System.out.println("");
				System.out.println("아이디를 입력해주십시오.");
				Id = sc.nextLine();
				System.out.println("비밀번호를 입력해주십시오.");
				Pw = sc.nextLine();
				System.out.println("이름을 입력해주십시오.");
				name = sc.nextLine();
				System.out.println("가입이 완료되었습니다.");
				
				Article member = new Article();
				member.setMember(Id);
				member.setPassword(Pw);
				member.setName(name);
				
				mm.signup(member);
			}
			
			else if(s.equals("login")) {

				System.out.print("아이디 : ");
				String id = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pw = sc.nextLine();
				
				mm.Login(id, pw);
				am.print();

			}
		}
		
	}
}