package aroundclasses;

public class ClassInsideClass {

    //Can we have class insdide class

    public class dependentClass{


    }


    public static void main(String[] args) {

        ClassInsideClass.dependentClass dependentClass = new ClassInsideClass().new dependentClass();
    }
}
