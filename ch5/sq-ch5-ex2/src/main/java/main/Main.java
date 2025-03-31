package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
  public static void main(String[] args) {
    var c = new AnnotationConfigApplicationContext(ProjectConfig.class); // 구성 클래스 기반 스프링 컨텍스트 생성

    var s1 = c.getBean(CommentService.class); // 스프링 컨텍스트에서 두 서비스 빈에 대한
    var s2 = c.getBean(CommentService.class); // 참조를 가져온다.

    // 스프링이 주입한 레포지토리 의존성에 대한 참조 값을 비교한다.
    boolean b = s1.getCommentRepository() == s2.getCommentRepository();
    // CommentRepository 의존성이 싱글톤이므로 두 서비스는 동일한 참조를 사용한다. 따라서 이 b 값은 항상 콘솔에 'true'로 출력된다.
    System.out.println(b);
  }
}