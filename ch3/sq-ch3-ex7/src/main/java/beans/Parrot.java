package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {

  private String name = "Koko";
  private final Person person;

  @Autowired
  public Parrot(Person person) { // 스프링은 Parrot 인스턴스를 생성하는 데 Person 빈이 필요하다. -> 순환 의존성 에러!!
    this.person = person;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Parrot : " + name;
  }
}