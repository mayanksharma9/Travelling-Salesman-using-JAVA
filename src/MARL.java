import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MARL {
    public static void main(String[] args) {
        int[][] listOfCities = {
                {60, 200},
                {180, 200},
                {80, 180},
                {140, 180},
                {20, 160},
                {160, 20}
        };

        //print the list of cities
        System.out.println("List of cities: ");
        for (int i = 0; i < listOfCities.length; i++) {
            System.out.println("Model.City " + i + ": " + listOfCities[i][0] + ", " + listOfCities[i][1]);
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
            nextCity = Greedy.getNextCity(currentCity, listOfCities);
            System.out.println("Visit city " + nextCity);
            totalPrize += listOfCities[nextCity][1];
            currentCity = nextCity;
        }
        System.out.println("Collected prize: " + totalPrize);
        //print getTotalDistance
        System.out.println("Total distance: " + MARL.getTotalDistance(currentCity, nextCity, listOfCities));
    }

    //get total distance
    public static int getTotalDistance(int currentCity, int nextCity, int [][] listOfCities) {
        int totalDistance = 0;
        int distance = 0;
        int [] visitedCities = new int[listOfCities.length];
        for (int i = 0; i < listOfCities.length; i++) {
            visitedCities[i] = 0;
        }
        visitedCities[currentCity] = 1;
        while (nextCity != -1) {
            distance = Math.abs(listOfCities[currentCity][0] - listOfCities[nextCity][0]) + Math.abs(listOfCities[currentCity][1] - listOfCities[nextCity][1]);
            totalDistance += distance;
            visitedCities[nextCity] = 1;
            currentCity = nextCity;
            nextCity = Greedy.getNextCity(currentCity, listOfCities);
        }
        return totalDistance;
    }


}
