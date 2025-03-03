package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
  @Bean
  Parrot parrot() {
    var p = new Parrot();
    p.setName("KoKo");
    return p;
  }

  @Bean // <- 스프링 컨텍스트에 "Hello" 문자열 추가
  String hello() {
    return "Hello";
  }

  @Bean // <- 스프링 컨텍스트에 정수 10 추가
  Integer ten() {
    return 10;
  }
}
