package aroundclasses;

public class MixedChil implements  IParent, IParent2{
    @Override
    public void impl() {

        System.out.println("I am a cross child");
    }
}
