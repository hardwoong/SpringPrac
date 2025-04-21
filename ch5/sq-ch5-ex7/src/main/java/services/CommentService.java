package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;

@Service
public class CommentService {
  @Autowired
  private ApplicationContext context;
  public void sendComment(Comment c) {
    CommentProcessor p = context.getBean(CommentProcessor.class);

    // my iron lungs
    p.setComment(c); // CommentProcessor 인스턴스를 사용하여 Comment 인스턴스를 변경한다.
    p.processComment(c); // CommentProcessor 인스턴스를 사용하여 Comment 인스턴스를 변경한다.
    p.validateComment(c); // CommentProcessor 인스턴스를 사용하여 Comment 인스턴스를 변경한다.
    c = p.getComment(); // 수정된 Comment 인스턴스를 가져와 추가로 사용한다.
    // 추가 작업 수행
  }
}
