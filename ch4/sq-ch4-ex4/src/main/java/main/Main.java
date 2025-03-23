package main;

import configuration.ProjectConfiguration;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
    // 댓글 게시 사용 사례를 위해 매개변수로 전달할 댓글 인스턴스를 생성
    var comment = new Comment();
    comment.setAuthor("Laurentiu");
    comment.setText("Demo comment");

    var commentService = context.getBean(CommentService.class);
    // 댓글 게시 사용 사례 호출
    commentService.publishComment(comment);
  }
}