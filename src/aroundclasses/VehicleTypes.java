package aroundclasses;

public class VehicleTypes {

    //Can we have interfaces inside class, yes why not

    public static interface Vehicle {


        public static int getNofWheelss() {

            return 1;
        }

        public int getNofWheels();

    }

    class Bus implements Vehicle{

        @Override
        public int getNofWheels() {
            return 4;
        }
    }

     class Auto implements Vehicle{

        @Override
        public int getNofWheels() {
            return 3;
        }
    }


    public static void main(String[] args) {

     VehicleTypes.Vehicle vehicle = new Vehicle() {
         @Override
         public int getNofWheels() {
             return 0;
         }
     };

      /*  VehicleTypes vehicleTypes = new VehicleTypes();
        VehicleTypes.Vehicle myVehicle = new Vehicle() {
            @Override
            public int getNofWheels() {
                return 5;
            }
        };

        VehicleTypes.Bus bus = vehicleTypes.new Bus();

        System.out.println(bus.getNofWheels());

        System.out.println(myVehicle.getNofWheels());*/
    }
}
