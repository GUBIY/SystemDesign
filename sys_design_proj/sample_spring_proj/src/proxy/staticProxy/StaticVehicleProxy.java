package proxy.staticProxy;

import proxy.*;

public class StaticVehicleProxy implements IVehicle {
  private IVehicle realVehicle;

  public StaticVehicleProxy(String name) {
    realVehicle = new Car(name);
  }

  @Override
  public void start() {
    System.out.println("StaticVehicleProxy--start");
    realVehicle.start();

  }

  @Override
  public void stop() {
    System.out.println("StaticVehicleProxy--stop");
    realVehicle.stop();
  }

  @Override
  public void forward() {
    System.out.println("StaticVehicleProxy--forward");
    realVehicle.forward();
  }

  @Override
  public void reverse() {
    System.out.println("StaticVehicleProxy--reverse");
    realVehicle.reverse();
  }

  @Override
  public String getName() {
    return null;
  }
}
