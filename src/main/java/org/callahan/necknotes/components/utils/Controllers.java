package org.callahan.necknotes.components.utils;


import java.util.HashMap;
import java.util.Map;

public class Controllers {

  private static final Map<Class<?>, Object> CONTROLLERS =
    new HashMap<>();

  public static <T extends Controller> T get(Class<T> type) {
    return autoCast(
      CONTROLLERS.computeIfAbsent(type, Controllers::create)
    );
  }

  private static Object create(Class<?> c) {
    try {
      return c.newInstance();
    } catch (Exception e) {
      throw new IllegalStateException("Missing controller.", e);
    }
  }

  public static <T extends Controller> void notify(Class<T> type) {
    get(type).notify();
  }

  @SuppressWarnings("unchecked")
  private static <T extends Controller> T autoCast(Object o) {
    return (T) o;
  }

}
