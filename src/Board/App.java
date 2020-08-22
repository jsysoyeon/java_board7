package Board;

import java.util.Scanner;
 
public class App {
	
	ArticleDao dao = new ArticleDao();
	ArticleManage am = new ArticleManage();
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		Member m = new Member();
		Board b = new Board();
		
		while(true) {
			System.out.println("로그인 / 회원가입 : join");
			System.out.println("게시판 이용 : board");
			
			String s = sc.nextLine();
			
			if(s.equals("join")) {
				m.start();
			}
			else if(s.equals("exit")) {
				System.out.println("");
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if(s.equals("board")) {
				b.print();
			}

		}
		
	}
 
}