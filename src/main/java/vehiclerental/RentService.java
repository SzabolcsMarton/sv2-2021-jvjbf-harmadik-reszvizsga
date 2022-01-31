package vehiclerental;

import java.time.LocalTime;
import java.util.*;

public class RentService {

    private Set<User> users = new HashSet<>();
    private Set<Rentable> rentables = new HashSet<>();
    private Map<Rentable, User> actualRenting = new TreeMap<>();

    public void registerUser(User user) {
        if (users.stream().anyMatch(user1 -> user1.getUserName().equals(user.getUserName()))) {
            throw new UserNameIsAlreadyTakenException("Username is taken!");
        }
        users.add(user);
    }

    public void addRentable(Rentable rentable) {
        rentables.add(rentable);
    }

    public Set<User> getUsers() {
        return new HashSet<>(users);
    }

    public Set<Rentable> getRentables() {
        return new HashSet<>(rentables);
    }

    public void rent(User user, Rentable rentable, LocalTime time) {
        if(rentable.getRentingTime()!=null){
            throw new IllegalStateException("Rentable is alredy rented");
        }
        if(!hasEnoughBalance(user,rentable)){
            throw new IllegalStateException("Balance is not enough");
        }
        rentable.rent(time);
        this.actualRenting.put(rentable, user);
    }

    private boolean hasEnoughBalance(User user, Rentable rentable){
       return user.getBalance() >= rentable.calculateSumPrice(180);
    }

    public Map<Rentable, User> getActualRenting() {
        return new TreeMap<>(actualRenting);
    }

    public void closeRent(Rentable rentable, long minutesElapsed) {
        actualRenting.get(rentable).minusBalance(rentable.calculateSumPrice(minutesElapsed));
        actualRenting.remove(rentable);
        rentable.closeRent();
    }

}
