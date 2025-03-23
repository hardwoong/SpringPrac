package proxies;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH") // @Qualifier로 "PUSH" 구현이라고 명명한다.
public class CommentPushNotificationProxy
  implements CommentNotificationProxy { // 이 클래스는 CommentNotificationProxy 인터페이스를 구현한다.

  @Override
  public void sendComment(Comment comment) {
    System.out.println("Sending push notification for comment " + comment.getText());
  }
}
