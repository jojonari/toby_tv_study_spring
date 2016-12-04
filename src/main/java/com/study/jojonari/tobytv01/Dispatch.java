package com.study.jojonari.tobytv01;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JoJoNaRi on 2016-11-06.
 */
public class Dispatch {
    /*static abstract class Service{
        abstract void run();

    }
    static class MyService1 extends Service{
        @Override
        void run(){
            System.out.println("run(1)");
        }
    }
    static class MyService2 extends Service{
        @Override
        void run(){
            System.out.println("run(2)");
        }
    }
    public static void main(String[] args){
        List<Service> svc = Arrays.asList(new MyService1(), new MyService2());
        svc.forEach(Service::run);
    }

    String hello(int id){return "";}*/

    interface Post { void postOn(SNS sns);}
    static class Text implements Post{

        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }
    static class Picture implements Post{

        @Override
        public void postOn(SNS sns) {
            sns.post(this);
        }
    }
    interface SNS {
        void post (Text post);
        void post (Picture post);
    }

    static class Facebook implements SNS{
        public void post(Text post) {System.out.println("text -facebook");}
        public void post(Picture post) {System.out.println("picture -facebook");}
    }

    static class Twitter implements SNS{
        public void post(Text post) {System.out.println("text -Twitter");}
        public void post(Picture post) {System.out.println("picture -Twitter");}
    }

    static class Googleplus implements SNS{
        public void post(Text post) {System.out.println("text -Googleplus");}
        public void post(Picture post) {System.out.println("picture -Googleplus");}
    }

    public static void main (String[] args){
        List<Post> posts = Arrays.asList(new Text(), new Picture());
        List<SNS> sns = Arrays.asList(new Facebook(), new Twitter(), new Googleplus());

        posts.forEach(p -> sns.forEach((SNS s)->p.postOn(s)));
    }

}

/*
* Double Dispatch
* Method Signature (name, parameter types) - override 가능, 동일한 메소드가 한 클래스 내에 있을 수 없음.
* Method Type (return type, method type parameter, method argument types, exception) - Method Reference를 쓸 수 있음.
* */