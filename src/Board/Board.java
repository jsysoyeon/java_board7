package Board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	ArticleDao dao = new ArticleDao();
	Member m = new Member();
	
	public void print() {
		Scanner sc = new Scanner(System.in);
		ArticleDao dao = new ArticleDao();
		String title;
		String body;
		print_menu p = new print_menu();
		
		while(true) {
			System.out.println("");
			p.menu();
			
			String s = sc.nextLine();
			
			if(s.equals("add")) {
				
				System.out.println("로그인해주십시오.");
				m.start();
				
			}
			
			else if(s.equals("list")) {
				ArrayList<Article> articles = dao.listData(); 
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					System.out.println("번호 : " + article.getId());
		    		System.out.println("제목 : " + article.getTitle());
		    		System.out.println("내용 : " + article.getBody());
		    		System.out.println("");
				}
			}
			
			else if(s.equals("read")) {
				ArrayList<Article> articles = dao.listData(); 
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					
					System.out.println("");
					System.out.println("번호 : " + article.getId());
		    		System.out.println("제목 : " + article.getTitle());
		    		System.out.println("");
				}
			}
			
			else if(s.equals("detail")) {
				System.out.println("");
				System.out.println("보고싶은 게시물의 번호를 입력해주십시오.");
				int id = sc.nextInt();
				sc.nextLine();
				
				Article article = dao.getArticleById(id);
				
				if(article == null) { 
					System.out.println("");
					System.out.println("게시물이 존재하지 않습니다.");
				}
				else {
					System.out.println("");
					System.out.println("번호 : " + article.getId());
		    		System.out.println("제목 : " + article.getTitle());
		    		System.out.println("내용 : " + article.getBody());
		    		System.out.println("");
				}
			}
			
			else if(s.equals("update")) {
				System.out.println("");
				System.out.println("수정을 원하는 게시물의 번호를 입력해주십시오.");
				int id = sc.nextInt();
				sc.nextLine();
				
				Article article = dao.getArticleById(id);
				
				if(article == null) { 
					System.out.println("");
					System.out.println("게시물이 존재하지 않습니다.");
				}
				else {
					System.out.println("");
					System.out.println("새로운 제목을 입력해주십시오.");
					title = sc.nextLine();
					article.setTitle(title);
					System.out.println("새로운 내용을 입력해주십시오.");
					body = sc.nextLine();
					article.setBody(body);
					
					dao.updateData(id, article);
				}
			}
			else if(s.equals("delete")) {
				System.out.println("");
				System.out.println("삭제를 원하는 게시물의 번호를 입력해주십시오.");
				int id = sc.nextInt();
				sc.nextLine();
				
				Article article = dao.getArticleById(id);
				
				if(article == null) { 
					System.out.println("");
					System.out.println("게시물이 존재하지 않습니다.");
				}
				else {
					dao.deleteData(article);
				}
			}	
			else if(s.equals("search")) {
				System.out.println("검색을 원하는 문자를 입력해주십시오. ");
				String word = sc.nextLine();
				
				ArrayList<Article> articles = dao.listData();
				
				for(int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if(article.getTitle().contains(word)) {
						System.out.println("번호 : " + article.getId());
						System.out.println("제목 : " + article.getTitle());
					}
				}
			}
		}
	}
}

class print_menu {
	void menu() {
		System.out.println("원하는 기능에 맞게 입력해주십시오.");
		System.out.println("게시물 추가(로그인 후 이용가능) : add");
		System.out.println("게시물 조회 : list");
		System.out.println("게시물 목록 조회 : read");
		System.out.println("게시물 상세보기 : detail");
		System.out.println("게시물 수정 : update");
		System.out.println("게시물 삭제 : delete");
		System.out.println("게시물 검색 : search");
		System.out.println("프로그램 종료 : exit");
	}
}