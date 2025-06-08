public class Superclass {
        Superclass(){
            System.out.println("super class constructor called");
        }
        void superMethod(){
            System.out.println("superMethod called");
        }
    }
// import hemantPack;
// package JAVA_CODES;
//driver class
class Task112{
    public static void main(String[] args){
        System.out.println("Driver class called");
        Superclass sobj = new Superclass();
        sobj.superMethod();
        System.out.println("Driver class ended");
    }
}


