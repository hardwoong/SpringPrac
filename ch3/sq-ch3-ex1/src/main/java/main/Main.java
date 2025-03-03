package main;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    // 구성 클래스 ProjectConfig를 기반으로 스프링 컨텍스트 인스턴스를 생성한다.
    Person person = context.getBean(Person.class); // 스프링 컨텍스트에서 Person 빈의 참조를 얻는다.
    Parrot parrot = context.getBean(Parrot.class); // 스프링 컨텍스트에서 Parrot 빈의 참조를 얻는다.
    System.out.println("Person's name: " + person.getName()); // 스프링 컨텍스트의 Person 빈인지 확인하려고 이름 출력
    System.out.println("Parrot's nameL " + parrot.getName()); // 스프링 컨텍스트의 Parrot 빈인지 확인하려고 이름 출력
    System.out.println("Person's parrot: " + person.getParrot()); // 인스턴스 사이의 관계 여부를 확인하려고 Person 빈의 Parrot 출력
  }
}