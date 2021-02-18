package generics;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

public class th33 {
    static class Favorites{
        private Map<Class<?>,Object> favorites = new HashMap<>();
        public <T> void put(Class<T> type, T instance){
            favorites.put(Objects.requireNonNull(type),instance);
        }
        // type.cast()是不必要的
        public <T> void putCast(Class<T> type, T instance){
            favorites.put(Objects.requireNonNull(type),type.cast(instance));
        }

        public <T> T get(Class<T> type){
            return type.cast(favorites.get(type));
        }
     }


     static Annotation getAnnotation(AnnotatedElement element,String name){
        Class<?> at = null;
        try {
            at = Class.forName(name);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(at.asSubclass(Annotation.class));
     }
}
