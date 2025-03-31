package services;

import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSOutput;

@Service
public class CommentService {
  // 누구도 CommentService 빈을 사용하지 않아도 스프링은 컨텍스트에 인스턴스를 생성하고 저장한다.
  // 실행 시 CommentService 빈 클래스의 생성자에서 출력 메시지를 보고 스프링이 인스턴스를 생성한다는 것을 알 수 있다.
  public CommentService() {
    System.out.println("CommentService instance created!");
  }
}
