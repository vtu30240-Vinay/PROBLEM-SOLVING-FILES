class ParkingSystem {

    private int[] parking;

    public ParkingSystem(int big, int medium, int small) {
        parking = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (parking[carType - 1] > 0) {
            parking[carType - 1]--;
            return true;
        }

        return false;
    }
}

INPUT;
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1,1,0], [1], [2], [3], [1]]
OUTPUT;
[null, true, true, false, false]
