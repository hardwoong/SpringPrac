package main;

import org.springframework.stereotype.Component;

@Component // Parrot 클래스에 대해 @Component 애너테이션을 사용하면 스프링은 이 클래스의 인스턴스를 생성하고 스프링 컨텍스트에 추가한다.
public class Parrot {
  private String name;
  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }
}
