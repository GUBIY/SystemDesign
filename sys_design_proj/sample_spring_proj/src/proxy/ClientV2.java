package proxy;

import proxy.staticProxy.*;

public class ClientV2 {
  public static void main(String[] args) {
    StaticVehicleProxy clientV2 = new StaticVehicleProxy("ClientV2");
    clientV2.start();
    clientV2.forward();
    clientV2.stop();
  }
}
