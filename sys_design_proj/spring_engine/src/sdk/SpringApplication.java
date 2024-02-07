package sdk;

import sdk.annotation.*;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class SpringApplication {
  private HashMap<Class,Object> beanContainerMap = new HashMap<Class,Object>();

  public static void run(Class<?> primarySource, String... args) {
    try {
      SpringApplication appContext = new SpringApplication();
      appContext.initBeanContainer(primarySource);

      appContext.di();

      appContext.run(primarySource);


    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  private void run(Class<?> primarySource) throws Exception {
    if (CommandLineRunner.class.isAssignableFrom(primarySource)) {
      CommandLineRunner commandLineRunner = (CommandLineRunner) beanContainerMap.get(primarySource);
      commandLineRunner.run();
    }

  }

  private void di() throws IllegalAccessException {
    for (Class beanClass : beanContainerMap.keySet()) {
      for (Field field : beanClass.getDeclaredFields()) {
        for (Annotation annotation : field.getAnnotations()) {
          if (annotation instanceof Autowired) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            for (Class clazz : beanContainerMap.keySet()) {
              if (fieldClass.isAssignableFrom(clazz)) {
                field.set(beanContainerMap.get(beanClass), beanContainerMap.get(clazz));
                break;
              }
            }
          }
        }
      }
    }
  }

  private void initBeanContainer(Class<?> primarySource) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    File appFile = new File(primarySource.getProtectionDomain().getCodeSource().getLocation().getPath());
    ArrayList<File> processAppDirList = new ArrayList<File>();
    processAppDirList.add(appFile);
    while (appFile != null && processAppDirList.size() > 0) {
      File curFile = processAppDirList.remove(0);
      if (curFile.isDirectory()) {
        File[] files = curFile.listFiles();
        processAppDirList.addAll(Arrays.asList(files));
        continue;
      }
      String endExt = ".class";
      String curFilePath = curFile.getPath();
      if (!curFilePath.endsWith(endExt)) {
        continue;
      }
      String filenameWithoutExt = curFilePath.substring(appFile.getPath().length() + 1, curFilePath.indexOf(endExt)).replace("\\", ".");
      Class<?> clazz = Class.forName(filenameWithoutExt);
      for (Annotation annotation : clazz.getAnnotations()) {
        if (annotation instanceof Component) {
          beanContainerMap.put(clazz,clazz.newInstance());
        }
      }
    }
  }
}
