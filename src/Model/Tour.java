package Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Tour {
    private List<City> tour = new ArrayList<>();
    private ArrayList<City> previousTour = new ArrayList<>();

    public Tour(int noofCities) {
        for (int i = 0; i < noofCities; i++) {
            tour.add(new City());
        }
    }

    public void generateInitialTour(){
        if (tour.isEmpty()){
            new Tour(5);
        }
        Collections.shuffle(tour);
    }

    public double getDistance(){
        double distance = 0;
        for (int i = 0; i < tour.size(); i++) {
            City fromCity = tour.get(i);
            City destinationCity;
            if (i + 1 < tour.size()) {
                destinationCity = tour.get(i + 1);
            } else {
                destinationCity = tour.get(0);
            }
            distance += fromCity.distanceTo(destinationCity);
        }
        return distance;
    }

    //getCity
    public City getCity(int index){
        return tour.get(index);
    }

    //generateRandomIndex
    public int generateRandomIndex(){
        return (int) (tour.size() * Math.random());
    }

    //revertSwap
    public void revertSwap(){
        tour = previousTour;
    }

//swapcities
    public void swapCities(int index1, int index2){
        previousTour = new ArrayList<>(tour);
        City city1 = getCity(index1);
        City city2 = getCity(index2);
        tour.set(index2, city1);
        tour.set(index1, city2);
    }

    //containsCity
    public boolean containsCity(City city){
        return tour.contains(city);
    }

    //getNoOfCities
    public int getNoOfCities(){
        return tour.size();
    }

    //toString
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < getNoOfCities(); i++) {
            geneString += getCity(i) + "|";
        }
        return geneString;
    }
}
