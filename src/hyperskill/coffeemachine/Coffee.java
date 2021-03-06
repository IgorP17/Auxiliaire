package hyperskill.coffeemachine;

import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {
        CoffeeMachineMy coffeeMachine = new CoffeeMachineMy();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();
            System.out.println();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String s = scanner.nextLine();
                    if ("back".equalsIgnoreCase(s)){
                        break;
                    }
                    int n = Integer.parseInt(s);
                    coffeeMachine.buy(n);
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int beans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int dCups = scanner.nextInt();
                    coffeeMachine.fill(water, milk, beans, dCups);
                    break;
                case "take":
                    coffeeMachine.take();
                    break;
                case "remaining":
                    coffeeMachine.printState();
                    break;
                case "exit":
                    loop = false;
            }
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

class CoffeeMachineMy {
    private int balance = 550;
    private int water = 400;
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
        System.out.println("$" + balance + " of money");
        System.out.println();
    }

    void buy(int n) {
        if (n >= 1 && n <= 3) {
            if (this.water < types[n - 1].getWater()){
                System.out.println("Sorry, not enough water!");
                return;
            } else if (this.milk < types[n - 1].getMilk()){
                System.out.println("Sorry, not enough milk!");
                return;
            } else if (this.beans < types[n - 1].getBeans()){
                System.out.println("Sorry, not enough beans!");
                return;
            }
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            this.balance += types[n - 1].getCost();
            this.water -= types[n - 1].getWater();
            this.milk -= types[n - 1].getMilk();
            this.beans -= types[n - 1].getBeans();
            this.dCups--;
        }
    }

    void fill(int water, int milk, int beans, int dCups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.dCups += dCups;
    }

    void take() {
        System.out.println("I gave you $" + this.balance);
        balance = 0;
    }
}
