import Model.City;

import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        //list cities from class City
        City[] listOfCities = {
                new City(60, 200),
                new City(180, 200),
                new City(80, 180),
                new City(140, 180),
                new City(20, 160),
                new City(100, 160)
        };

        //print the list of cities
        System.out.println("List of cities: ");
        for (int i = 0; i < listOfCities.length; i++) {
            System.out.println("City " + i + ": " + listOfCities[i].getX() + ", " + listOfCities[i].getY());
        }

        //get the starting city
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the starting city: ");
        int startingCity = input.nextInt();
        System.out.println("Starting city: " + startingCity);

        //get the ending city
        System.out.println("Enter the ending city: ");
        int endingCity = input.nextInt();
        System.out.println("Ending city: " + endingCity);

        //get the targeted prize
        System.out.println("Enter the targeted prize: ");
        int targetedPrize = input.nextInt();
        System.out.println("Targeted prize: " + targetedPrize);

        //print the sequences of the visits
        System.out.println("The sequence of the visits: ");
        int currentCity = startingCity;
        int totalPrize = 0;
        int nextCity = 0;
        for (int i = 0; i < listOfCities.length; i++) {
            nextCity = getNextCity(currentCity, listOfCities);
            System.out.println("Visit city " + nextCity);
            totalPrize += listOfCities[nextCity].getPrize();
            currentCity = nextCity;

            if (currentCity == endingCity || totalPrize >= targetedPrize) {
                break;
            }
    }
        //print the total distance using random algorithm
        System.out.println("Collected prize: " + totalPrize);

        //calculate total distance
        int totalDistance = 0;
        int distance = 0;
        int [] visitedCities = new int[listOfCities.length];
        visitedCities[0] = startingCity;
        for (int i = 1; i < listOfCities.length; i++) {
            visitedCities[i] = getNextCity(visitedCities[i - 1], listOfCities);
            distance = (int) listOfCities[visitedCities[i - 1]].distanceTo(listOfCities[visitedCities[i]]);
            totalDistance += distance;
        }
        System.out.println("Total distance: " + totalDistance);


}

    private static int getNextCity(int currentCity, City[] listOfCities) {
        int nextCity = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < listOfCities.length; i++) {
            if (i != currentCity) {
                double distance = listOfCities[currentCity].distanceTo(listOfCities[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                    nextCity = i;
                }
            }
        }
        return nextCity;
    }
    }
