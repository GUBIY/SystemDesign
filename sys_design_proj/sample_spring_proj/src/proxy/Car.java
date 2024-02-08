package proxy;

public class Car implements IVehicle{
  private String name;

  public Car(String name) {
    this.name = name;
  }

  public void start() {
    System.out.println("Car " + name + " start");
  }

  @Override
  public void stop() {
    System.out.println("Car " + name + " stop");
  }

  @Override
  public void forward() {
    System.out.println("Car " + name + " forward");
  }

  @Override
  public void reverse() {
    System.out.println("Car " + name + " reverse");
  }

  @Override
  public String getName() {
    return null;
  }


}
