package main;

import model.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
  public static void main(String[] args) {
    // 의존성 객체들을 생성
    var commentRepository = new DBCommentRepository();
    var commentNotificationProxy = new EmailCommentNotificationProxy();

    // 의존성을 제공하여 서비스 클래스 인스턴스 생성
    var commentService = new CommentService(commentRepository, commentNotificationProxy);

    // 댓글 게시 사용 사례를 위해 매개변수로 전달할 댓글 인스턴스를 생성
    var comment = new Comment();
    comment.setAuthor("Laurentiu");
    comment.setText("Demo comment");

    // 댓글 게시 사용 사례 호출
    commentService.publishComment(comment);
  }
}