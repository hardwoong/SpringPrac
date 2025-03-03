package beans;

public class Parrot {

  private String name;

  public Parrot() {
    System.out.println("Parrot created"); // Parrot 인스턴스 생성 디버깅용 출력
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