package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
  public static void main(String[] args) {
    var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

    var s1 = c.getBean(CommentService.class); // 서비스 빈에 대한 컨텍스트에서 참조를 얻는다.
    var s2 = c.getBean(UserService.class); // 서비스 빈에 대한 컨텍스트에서 참조를 얻는다.

    boolean b = s1.getCommentRepository() == s2.getCommentRepository();
    // 주입된 CommentRepository 인스턴스에 대한 참조값을 비교한다.
    // CommentRepository는 프로토타입 빈이므로 비교 결과는 항상 false
    System.out.println(b);
  }
}