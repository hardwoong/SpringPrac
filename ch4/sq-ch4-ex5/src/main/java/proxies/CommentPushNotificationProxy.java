package proxies;

import model.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // @Primary를 사용하여 DI에 대한 기본 구현으로 표시한다.
public class CommentPushNotificationProxy
  implements CommentNotificationProxy { // 이 클래스는 CommentNotificationProxy 인터페이스를 구현한다.

  @Override
  public void sendComment(Comment comment) {
    System.out.println("Sending push notification for comment " + comment.getText());
  }
}
