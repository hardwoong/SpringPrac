package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

@Configuration // 스테레오타입 애너테이션을 사용하지 않기 때문에 @ComponentScan 애너테이션이 더 이상 필요 없다.
public class ProjectConfiguration {
  @Bean
  public CommentRepository commentRepository() {
    return new DBCommentRepository();
  }

  @Bean
  public CommentNotificationProxy commentNotificationProxy() {
    return new EmailCommentNotificationProxy();
  }

  @Bean
  public CommentService commentService(
      CommentRepository commentRepository, // 인터페이스 타입으로 정의된 @Bean 메서드의 매개변수를 사용하면 스프링은 컨텍스트에서
      CommentNotificationProxy commentNotificationProxy // 매개변수의 타입과 호환되는 빈에 대한 참조를 제공하도록 지시한다.
  ) {
    return new CommentService(commentRepository, commentNotificationProxy);
  }
}
