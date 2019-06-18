package src;

import java.util.ArrayList;

public class HashFunctions {

    private int hashmapSize;
    private ArrayList<Integer> hashmap;
    private int increment;
    private int cont;

    public HashFunctions( int hashmapSize, int increment){
        this.hashmapSize = hashmapSize;
        this.increment = increment;

    }

    public int getHashmapSize() {
        return hashmapSize;
    }

    public void setHashmapSize(int hashmapSize) {
        this.hashmapSize = hashmapSize;
    }

    public ArrayList<Integer> getHashmap() {
        return hashmap;
    }

    public void setHashmap(ArrayList<Integer> hashmap) {
        this.hashmap = hashmap;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
    public void insert(int key) {

        int position = key % hashmapSize;

        if (hashmap.get(position) == null) {
            hashmap.add(key);
        } else {
            nextPosition(position, increment);
        }
        
    }

    public int nextPosition(int position, int increment) {

        int newPosition = position + increment * cont * (int) Math.pow(-1, cont);

        cont++;

        if (hashmap.get(newPosition) != 0) {
            newPosition = nextPosition(position, increment);
        }
        return newPosition;

    }

    public int searchPosition(int position, int increment) {

        int search = position;

        int comparator = position + increment * cont * (int) Math.pow(-1, cont);

        cont++;

        if (search == hashmap.get(comparator)) {
            return search;
        } else {
            searchPosition(position, increment);
        }
        return 0;
    }

}
