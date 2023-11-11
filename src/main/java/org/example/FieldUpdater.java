package org.example;

import java.util.function.Consumer;

public class FieldUpdater {

  public static <T> void updateField(Consumer<T> setMethod, T newValue) {
    if (newValue != null) {
      setMethod.accept(newValue);
    }
  }
}
