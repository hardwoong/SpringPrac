package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
  @Bean
  public Parrot parrot() {
    Parrot p = new Parrot();
    p.setName("Koko");
    return p;
  }

  @Bean
  public Person person() {
    Person p = new Person();
    p.setName("Ella");
    p.setParrot(parrot()); // 사람의 앵무새 속성에 앵무새 빈의 참조를 설정한다.
    // 설정하려는 빈을 반환하는 메서드를 직접 호출하여 사람 빈과 앵무새 빈 간 관계를 정의한다.
    return p;
  }
}
