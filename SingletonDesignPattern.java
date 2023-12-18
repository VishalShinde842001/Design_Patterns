//Singleton design pattern is the design pattern which is used when we need only one object of that class

public class SingletonDesignPattern {
    public static void main(String[] args) {
        //Now we can create object of singleton class only once


        //Below statement is not legal because constructor of Singleton class in now private
       // Singleton singleton=new Singleton();

        Singleton singleton=Singleton.getSingleton();
        Singleton singleton1=Singleton.getSingleton();
        //for below both output statement output will be same because we used singleton design pattern
        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
    }

}
class Singleton{
    //here we have created object of class but not initialized so it will null
    private static Singleton singleton;
    //step1:create constructor of class as private so other class will not make its object
    private Singleton(){
        if(singleton!=null){
            throw new RuntimeException("You are trying to break Singleton rules");
        }

    }
    //step2:create static method which will internally create object of class provide to another class
    //but implementation of this class must be in that way so it will not create more than 1 object
    public static Singleton getSingleton(){
        //as we know value of object will null only once after passing through if statement it will not go inside again ever
        //but in the case of multithreading it can produce error
        //so we can use synchronization for that
        synchronized (Singleton.class){
        if(singleton==null){
            singleton = new Singleton();
        }}
        return singleton;
    }
}
