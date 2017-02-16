package brokers;

public class Car {

        public Car(int numDoors) {

            myNumDoors = numDoors;

        }



        public abstract int maxNumPassengers();



        private int myNumDoors;

    }





class Sedan extends Car {

        public Sedan(int numDoors) {

            super(numDoors);

        }



        public int maxNumPassengers() {

            return myNumDoors * 1;

        }

    }
