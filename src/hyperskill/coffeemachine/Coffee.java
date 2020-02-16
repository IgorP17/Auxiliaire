package hyperskill.coffeemachine;

import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.printState();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int n = scanner.nextInt();
                coffeeMachine.buy(n);
                System.out.println();
                coffeeMachine.printState();
                break;
            case "fill":
                break;
            case "take":
                break;
        }
    }
}

class CoffeeType {
    private int water;
    private int milk;
    private int beans;
    private int cost;

    CoffeeType(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }

    int getWater() {
        return water;
    }

    int getMilk() {
        return milk;
    }

    int getBeans() {
        return beans;
    }

    int getCost() {
        return cost;
    }
}

class CoffeeMachine {
    private int balance = 550;
    private int water = 1200;
    private int milk = 540;
    private int beans = 120;
    private int dCups = 9;

    private CoffeeType espresso = new CoffeeType(250, 0, 16, 4);
    private CoffeeType latte = new CoffeeType(350, 75, 20, 7);
    private CoffeeType cappuccino = new CoffeeType(200, 100, 12, 6);

    private CoffeeType[] types = new CoffeeType[]{espresso, latte, cappuccino};

    void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(dCups + " of disposable cups");
        System.out.println(balance + " of money");
        System.out.println();
    }

    void buy(int n) {
        if (n >= 1 && n <= 3) {
            balance = balance + types[n - 1].getCost();
            water = water - types[n - 1].getWater();
            milk = milk - types[n - 1].getMilk();
            beans = beans - types[n - 1].getBeans();
            dCups = dCups - 1;
        }
    }
}
