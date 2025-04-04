package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    Parrot p = context.getBean(Parrot.class);
    System.out.println(p); // 스프링 컨텍스트에서 가져온 인스턴스를 기본 String 형식으로 출력한다,
    System.out.println(p.getName()); // 스프링이 컨텍스트에 추가한 Parrot 인스턴스에 아직 이름을 설정하지 않았기 때문에 null 출력
  }
}