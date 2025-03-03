package java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
      Parrot p = new Parrot();
      var context = new AnnotationConfigApplicationContext();
    }
}