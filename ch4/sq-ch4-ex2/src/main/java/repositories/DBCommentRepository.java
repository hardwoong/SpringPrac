package repositories;

import model.Comment;
import org.springframework.stereotype.Component;

@Component // @Component로 클래스를 표시하면 스프링이 클래스의 인스턴스를 만들고 이를 빈으로 추가하도록 지시한다.
public class DBCommentRepository implements CommentRepository {
  @Override
  public void storeComment(Comment comment) {
    System.out.println("Storing comment: " + comment.getText());
  }
}
