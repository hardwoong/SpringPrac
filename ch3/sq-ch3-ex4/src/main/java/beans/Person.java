package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

  private String name = "Ella";

  // 필드에 @Autowired 애너테이션을 추가하면, 해당 컨텍스트에서 적절한 값을 주입하도록 스프링에 지시하게 된다.
  @Autowired
  private Parrot parrot;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Parrot getParrot() {
    return parrot;
  }

  public void setParrot(Parrot parrot) {
    this.parrot = parrot;
  }
}