package services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
// 누군가가 빈을 사용할 때만 생성하도록 스프링에 지시
public class CommentService {
  public CommentService() {
    System.out.println("CommentService instance created!");
  }
}
