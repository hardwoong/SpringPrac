package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import org.springframework.stereotype.Component;

@Component // 스프링은 이 클래스를 빈으로 생성하고 컨텍스트에 추가한다.
public class CommentService {
  @Autowired
  private final CommentRepository commentRepository;
  @Autowired
  private final CommentNotificationProxy commentNotificationProxy;
  // 필드는 이제 final이 아니며, @Autowired로 표시된다. 스프링은 기본 생성자로 클래스의 인스턴스를 생성한 후
  // 스프링의 컨텍스트에서 두 의존성을 가져와 주입한다.

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
