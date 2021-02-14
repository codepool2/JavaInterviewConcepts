package aroundclasses;

public abstract class ClassInsideClassAbstract {




    public  abstract class chotaClass{

        public abstract void method1();
    }
}

class AboveImple extends ClassInsideClassAbstract{

    public static void main(String[] args) {

        ClassInsideClassAbstract classInsideClass = new ClassInsideClassAbstract() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        ClassInsideClassAbstract.chotaClass chotaClass = classInsideClass.new chotaClass(){

            @Override
            public void method1() {

            }
        };
    }

}
