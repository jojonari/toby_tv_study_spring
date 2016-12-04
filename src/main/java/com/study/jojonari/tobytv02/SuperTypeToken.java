package com.study.jojonari.tobytv02;

import com.sun.tools.corba.se.idl.IncludeGen;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperTypeToken {
    static class Sup<T>{
        T value;

    }
    //NESTED STATIC CLASS
//    static  class Sub extends Sup<List<String>>{
//
//    }


    //Local Class
//    public static void main(String[] args)throws Exception{
////        상속과정에서 파라메터 타입을 지정함.
////        Sup<String> s = new Sup<>();
////        System.out.println(s.getClass().getDeclaredField("value").getType());
//
//        Sup b = new Sup<String>(){};
//        Type t  =b.getClass().getGenericSuperclass();
//        ParameterizedType ptype =  (ParameterizedType)t;
//        System.out.println(ptype.getActualTypeArguments()[0]);
//    }



    static class TypesafeMap2 {
        Map<TypeReference<?>, Object> map = new HashMap<>();
        <T> void put(TypeReference<T> tr, T value){
            map.put(tr, value);
        }
        <T> T get(TypeReference<T> tr){
            if(tr.type instanceof Class<?>){
                return ((Class<T>)tr.type).cast(map.get(tr));
            }else
            return ((Class<T>)((ParameterizedType)tr.type).getRawType()).cast(map.get(tr));
        }
    }

    static class TypeReference<T>{
        Type type;

        public TypeReference() {
            Type stype = getClass().getGenericSuperclass();
            if (stype instanceof  ParameterizedType){
                this.type = ((ParameterizedType)stype).getActualTypeArguments()[0];
            }else throw new RuntimeException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;

            TypeReference<?> that = (TypeReference<?>) o;

            return type.equals(that.type);
        }

        @Override
        public int hashCode() {
            return type.hashCode();
        }

    }

    public static void main(String[] args)throws Exception{
        TypesafeMap2 m = new TypesafeMap2();
        m.put(new TypeReference<List<Integer>>(){}, Arrays.asList(1,2,3,4));
        m.put(new TypeReference<List<String>>(){}, Arrays.asList("a","b","C"));

        System.out.println(new TypeReference<List<Integer>>(){});
        System.out.println(new TypeReference<List<String>>(){});
    }
}
