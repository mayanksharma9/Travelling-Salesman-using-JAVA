import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Greedy {

    public static void main(String[] args) {
        int [][] listOfCities = {
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
        while (currentCity != endingCity && totalPrize < targetedPrize) {
            int nextCity = getNextCity(currentCity, listOfCities);
            System.out.println("Visit city " + nextCity);
            totalPrize += listOfCities[nextCity][1];
            currentCity = nextCity;
        }
        System.out.println("Collected prize: " + totalPrize);


        //calculate total distance
        int totalDistance = 0;
        int nextCity = 0;
        int distance = 0;
        int [] visitedCities = new int[listOfCities.length];
        visitedCities[0] = startingCity;
        int visitedCitiesIndex = 1;
        while (currentCity != endingCity) {
            int tempDistance = 100000;
            for (int i = 0; i < listOfCities.length; i++) {
                if (i != currentCity) {
                    distance = calculateDistance(listOfCities[currentCity][0], listOfCities[currentCity][1], listOfCities[i][0], listOfCities[i][1]);
                    if (distance < tempDistance) {
                        tempDistance = distance;
                        nextCity = i;
                    }
                }
            }
            totalDistance += tempDistance;
            visitedCities[visitedCitiesIndex] = nextCity;
            visitedCitiesIndex++;
            currentCity = nextCity;
        }
        System.out.println("Total distance: " + totalDistance);


    }

    static int getNextCity(int currentCity1, int[][] listOfCities) {
        int nextCity = 0;
        int tempPrize = 0;
        for (int i = 0; i < listOfCities.length; i++) {
            if (i != currentCity1) {
                if (listOfCities[i][1] > tempPrize) {
                    tempPrize = listOfCities[i][1];
                    nextCity = i;
                }
            }
        }
        return nextCity;
    }

    private static int calculateDistance(int i, int i1, int i2, int i3) {
        int xDistance = Math.abs(i - i2);
        int yDistance = Math.abs(i1 - i3);
        return (int) Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

}