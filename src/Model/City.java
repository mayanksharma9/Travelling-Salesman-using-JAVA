package Model;

import lombok.Data;

@Data
public class City {
    private int x;
    private int y;

    public City() {
        this.x = (int) (Math.random() * 200);
        this.y = (int) (Math.random() * 200);
    }

    public City(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    public double distanceTo(City city) {
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public int getPrize() {
        return (int) (Math.random() * 100);
    }
}
