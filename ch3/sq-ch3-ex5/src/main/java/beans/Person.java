package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

  private String name = "Ella";

  private final Parrot parrot; // 필드를 final로 설정하여 초기화한 후 값 변경 불가하게 설정 가능

  @Autowired // 생성자에 @Autowired 애너테이션 사용
  // 클래스에 생성자가 하나만 있다면 @Autowired 애너테이션 생략 가능
  public Person(Parrot parrot) {
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