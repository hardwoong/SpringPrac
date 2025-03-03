package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Parrot x = new Parrot(); // 스프링 컨텍스트에 추가하고 싶은 인스턴스를 생성한다.
    x.setName("Kiki");

    Supplier<Parrot> parrotSupplier = () -> x; // 이 인스턴스를 반환할 Supplier를 정의한다.

    context.registerBean("parrot1" ,Parrot.class, parrotSupplier);
    // registerBean() 메서드를 호출하여 이 인스턴스를 스프링 컨텍스트에 추가한다.
    // 마지막 인자로 bc->bc.setPrimary(true)를 넣어 기본인자로 설정 가능

    Parrot p = context.getBean(Parrot.class); // 컨텍스트에 있는 빈은 검증하려고
    System.out.println(p.getName()); // 앵무새 빈을 참조하여 이름을 콘솔에 출력한다.
  }
}