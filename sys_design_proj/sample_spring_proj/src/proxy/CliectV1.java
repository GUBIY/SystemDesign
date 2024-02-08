package proxy;

public class CliectV1 {
  public static void main(String[] args) {
    Car cliectV1 = new Car("CliectV1");
    cliectV1.start();
    cliectV1.forward();
    cliectV1.stop();

  }
}
