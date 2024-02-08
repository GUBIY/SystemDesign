package proxy;

import java.lang.reflect.*;

public class ClientV3 {

  public void beforeAdvice(Method method, Object... args) {
  		System.out.println("Before method:" + method);
  	}

  public static void main(String[] args) {
    ClientV3 clientV3 = new ClientV3();
    IVehicle c = new Car("Botar");
    Class<?>[] interfaces = c.getClass().getInterfaces();
    IVehicle v = (IVehicle) Proxy.newProxyInstance(c.getClass().getClassLoader(),
                                                   interfaces, new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          Class<?> clazz = Class.forName("proxy.ClientV3");
          clazz.getMethod("beforeAdvice",Method.class,Object[].class).invoke(clientV3, method, args);
          System.out.println("surprise");
          return method.invoke(c, args);

        }
      });
    v.start();
    v.forward();
    v.stop();

  }
}
