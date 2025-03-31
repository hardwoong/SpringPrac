package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CommentRepository;

@Service
public class CommentService {
  @Autowired
  private final CommentRepository commentRepository;
  // 필드를 final로 정의하면 이 필드는 변결될 수 없다는 것을 강조할 수 있다.

  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  public CommentRepository getCommentRepository(CommentRepository commentRepository) {
    return commentRepository;
  }
}

