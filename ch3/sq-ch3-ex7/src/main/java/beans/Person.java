package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

  private String name = "Ella";

  private final Parrot parrot;

  @Autowired
  public Person(Parrot parrot) { // 스프링은 Person 인스턴스를 생성하는 데 Parrot 빈이 필요하다.
    this.parrot = parrot;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Parrot getParrot() {
    return parrot;
  }
}