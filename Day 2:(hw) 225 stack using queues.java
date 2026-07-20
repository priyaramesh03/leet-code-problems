public class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        
        this.slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (this.slots[carType] > 0) {
            this.slots[carType]--;
            return true;
        }
        return false;
    }
}
