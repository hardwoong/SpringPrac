package processors;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
  @Autowired
  private CommentRepository commentRepository;

  private Comment comment;

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  public Comment getComment() {
    return this.comment;
  }

  public void processComment(Comment comment) {
    // comment 속성을 변경한다.
  }
  // 아래 위 두 메서드가 Comment 속성 값을 변경한다.
  public void validateComment(Comment comment) {
    // comment 속성을 검사하고 변경한다.
  }
}
