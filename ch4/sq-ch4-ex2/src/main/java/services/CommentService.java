package services;

import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component // 스프링은 이 클래스를 빈으로 생성하고 컨텍스트에 추가한다.
public class CommentService {
  private final CommentRepository commentRepository;
  private final CommentNotificationProxy commentNotificationProxy; // 이 클래스에 생성자가 두 개 이상 있다면 @Autowired를 사용해야 한다.
  // 클래스의 속성으로 의존성 두 개를 정의

  // 객체가 생성될 때 생성자의 매개변수로 의존성 제공
  public CommentService( // 스프링은 이 생성자로 빈을 생성하며 빈 인스턴스를 생성할 때 스프링 컨텍스트에서 매개변수의 레퍼런스(또는 레퍼런스들)를 주입한다.
      CommentRepository commentRepository,
      CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  public void publishComment(Comment comment) { // 댓글 저장과 알림 전송 책임을 의존성에 위임하는 사용 사례 구현
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }

}
