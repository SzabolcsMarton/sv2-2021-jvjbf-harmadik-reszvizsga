package vehiclerental;

import java.time.LocalTime;

public class Car implements Rentable{

    private String id;
    private LocalTime rentingTime;
    private int pricePerMinute;

    public Car(String id, int pricePerMinute) {
        this.id = id;
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public int calculateSumPrice(long minutes) {
        return (int) minutes * pricePerMinute;
    }

    @Override
    public LocalTime getRentingTime() {
        return this.rentingTime;
    }

    @Override
    public void rent(LocalTime time) {
        this.rentingTime = time;
    }

    @Override
    public void closeRent() {
        this.rentingTime = null;
    }

//    @Override
//    public int compareTo(Rentable o) {
//        return 0;
//    }
}
