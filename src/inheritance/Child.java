package inheritance;

public class Child extends Parent {

    @Override
    public void hello(Number s) {
        System.out.println("In Child Class");
    }


    //Whenever u extend from a parent tp verride something, u should exactly match the args, u should not even subtype

    public void test(Integer s) {
        System.out.println("In child");
    }

    public int methodOverloadingValid(Number s, Integer s1){
        System.out.println("in Number");
        return 1;
    }
    public void methodOverloadingValid(Integer s, Number s1){

        System.out.println("In Integer");

    }
}

class App {


    public static void main(String[] args) {

       /* Parent parent = new Child();
        parent.hello(3);
        parent.test(5);*/

        Child child = new Child();
        child.methodOverloadingValid(5d,5);

    }
}
