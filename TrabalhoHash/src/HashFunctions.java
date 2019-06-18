package src;

import java.util.ArrayList;

public class HashFunctions {

    public int hashmapSize;
    private int increment;
    private int cont;


    public HashFunctions(int hashmapSize, int increment) {
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

    private ArrayList<Integer> hashmap = new ArrayList<>();


    public void insert(int key) {

        Integer inicialPosition = key % hashmapSize;

        if (hashmap.get(inicialPosition) == null) {
            hashmap.set(inicialPosition, key);
        } else {
            hashmap.set(nextPosition(inicialPosition, increment), key);

        }
    }

    public int nextPosition(int position, int increment) {

        int count = 1;
        int direction = 2;

        while (true) {

            int comparator = position + increment * count * (int) Math.pow(-1, direction);

//            if(count > hashmapSize){
//                System.out.println("Map is Full!");
//                break;
//            }
            if (hashmapSize < comparator ) {
                int aux = hashmapSize - position;
                comparator = increment - aux;
            }

            if (hashmap.get(comparator) == null) {

                return comparator;
            } else {

                direction++;
                comparator = position + increment * count * (int) Math.pow(-1, direction);

                if (increment > position){
                    int aux = increment - position;
                    comparator = hashmapSize - aux;
                }
                if (hashmap.get(comparator) == null) {


                    return comparator;
                }
            }
            direction++;
            count++;
        }
    }

    public void tableAutoFill() {
        for (int i = 0; i < getHashmapSize(); i++) {
            hashmap.add(i, null);
        }
    }
}
