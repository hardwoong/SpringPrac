package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    // 스프링 컨텍스트 인스턴스가 생성될 때 구성 클래스를 매개변수로 전송하여 스프링이 이를 사용하도록 지시한다.
    Parrot p = context.getBean(Parrot.class);
    // 스프링 컨텍스트에서 Parrot 타입의 빈 참조를 가져온다.
    // 명시적으로 형 변환(type casting)은 할 필요 없다. 스프링은 요청받은 빈 타입을 컨텍스트에서 찾는다.
    // 그러한 빈이 없으면 예외를 던진다
    System.out.println(p.getName());
    String s = context.getBean(String.class);
    System.out.println(s);
    Integer n = context.getBean(Integer.class);
    System.out.println(n);
  }
}