package repositories;

import model.Comment;
import org.springframework.stereotype.Repository;

@Repository // @Repository를 사용하여 이 객체를 레포지토리 책임을 가진 컴포넌트로 정의한다.
public class DBCommentRepository implements CommentRepository {
  @Override
  public void storeComment(Comment comment) {
    System.out.println("Storing comment: " + comment.getText());
  }
}
