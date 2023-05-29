class ParkingSystem {

    private int[] system;

    public ParkingSystem(int big, int medium, int small) {
        this.system = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        if (this.system[carType - 1] == 0) {
            return false;
        }
        this.system[carType - 1]--;
        return true;
    }
}
