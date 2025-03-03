package services;

import model.Comment;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

public class CommentService {
  private final CommentRepository commentRepository;
  private final CommentNotificationProxy commentNotificationProxy;
  // 클래스의 속성으로 의존성 두 개를 정의

  // 객체가 생성될 때 생성자의 매개변수로 의존성 제공
  public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
    this.commentRepository = commentRepository;
    this.commentNotificationProxy = commentNotificationProxy;
  }

  public void publishComment(Comment comment) { // 댓글 저장과 알림 전송 책임을 의존성에 위임하는 사용 사례 구현
    commentRepository.storeComment(comment);
    commentNotificationProxy.sendComment(comment);
  }

}
