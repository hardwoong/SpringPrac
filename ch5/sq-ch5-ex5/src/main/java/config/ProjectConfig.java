package config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import services.CommentService;

@Configuration
public class ProjectConfig {
  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE) // 이 빈을 프로토타입 스코프로 만든다.
  public CommentService commentService() {
    return new CommentService();
  }
}
