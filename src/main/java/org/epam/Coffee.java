package org.epam;

public class Coffee {

    private int coffeeCount;
    private final int MACHINE_CAPACITY = 10;

    public Coffee(int coffeeCount){
        if(coffeeCount>10) throw new IllegalArgumentException("Machine Capacity is 10");
        this.coffeeCount = coffeeCount;
    }

    public int getCoffeeCount() {
        return this.coffeeCount;
    }

    public void dispenseCoffee(int count){
        if(coffeeCount ==0){
            throw new IllegalArgumentException("There are no coffee in the machine");
        }
        if(count>coffeeCount) throw new IllegalArgumentException(count + " coffee's aren't available in the machine");
        this.coffeeCount -=count;
    }

    public void loadCoffee(int count){
        int afterAdding = this.getCoffeeCount()+count;
        if(afterAdding > this.MACHINE_CAPACITY) {
            throw new IllegalArgumentException("Coffee Machine is Full");
        }
        this.coffeeCount +=count;
    }
}
