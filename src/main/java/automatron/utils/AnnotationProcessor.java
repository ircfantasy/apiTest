package automatron.utils;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public void process(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = method.getAnnotation(Repeat.class);
            }
        }
    }

}
