package aroundclasses;

public interface Vehicle {


    public int getNoOfWheels();


    class Bus implements Vehicle{

        @Override
        public int getNoOfWheels() {
            return 4;
        }
    }
}

class App{


    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle.Bus();
        System.out.println(vehicle.getNoOfWheels());
    }



}
