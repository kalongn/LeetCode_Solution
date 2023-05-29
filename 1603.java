class ParkingSystem {

    private int[] system = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        this.system[0] = big;
        this.system[1] = medium;
        this.system[2] = small;
    }

    public boolean addCar(int carType) {
        if (this.system[carType - 1] == 0) {
            return false;
        }
        this.system[carType - 1]--;
        return true;
    }
}
