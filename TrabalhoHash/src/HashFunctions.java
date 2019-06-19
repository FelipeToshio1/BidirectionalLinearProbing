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

            Integer position = nextPosition(inicialPosition, increment);
            if (position == null) {
                System.out.println("\nResonance");
            } else {
                hashmap.set(position, key);
            }
        }
    }

    public Integer nextPosition(int position, int increment) {

        int count = 1;

        int direction = 2;

        while (true) {

            if (count > hashmapSize) {
                break;
            }
            int comparator = position + increment * count * (int) Math.pow(-1, direction);

            if (hashmapSize < comparator) {
                int aux = hashmapSize - position;
                comparator = increment - aux;
            }

            if (hashmapSize > comparator && hashmap.get(comparator) == null) {
                return comparator;

            } else {

                direction++;
                comparator = position + increment * count * (int) Math.pow(-1, direction);

                if (increment > position) {
                    int aux = increment - position;
                    comparator = hashmapSize - aux;
                }
                if (hashmapSize > comparator && hashmap.get(comparator) == null) {

                    return comparator;
                }

            }
            direction++;
            count++;
        }
        return null;
    }

    public void remove(int key) {
        Integer inicialPosition = key % hashmapSize;

        if (hashmap.get(inicialPosition) == key) {
            hashmap.set(inicialPosition, null);
            organize(key, inicialPosition);
        } else {

            Integer position = nextPosition(inicialPosition, increment);
            if (position == null) {
                System.out.println("\n404 NOT FOUND");
            } else {
                hashmap.set(position, null);
                organize(key, position);
            }
        }
    }

    public Integer search(int key) {
        Integer inicialPosition = key % hashmapSize;
        if (hashmap.get(inicialPosition) != null && hashmap.get(inicialPosition) == key) {
            return inicialPosition;
        } else {
            Integer position = nextPosition(inicialPosition, increment);
            return position;
        }
    }

    public void organize(int lastKey, int index) {
        int count = 1;
        int direction = 2;
        int lastEmpty = index;
        while (true) {
            int comparator = index + increment * count * (int) Math.pow(-1, direction);
            if (hashmap.get(comparator) == null) {
                break;
            }

            int hash = hashmap.get(comparator) % hashmapSize;

            if (hash - comparator != 0) {
                int lastHash = lastKey % hashmapSize;
                int distance = hash - comparator;
                int lastDistance = lastHash - lastEmpty;
                int distanceDifference = Math.abs(distance) - Math.abs(lastDistance);
                if (distanceDifference > 0 || (distanceDifference == 0 && lastDistance < 1)) {
                    hashmap.set(lastEmpty, hashmap.get(comparator));
                    lastKey = hashmap.get(comparator);
                    hashmap.set(comparator, null);
                    lastEmpty = comparator;
                }
            }
            direction++;

            comparator = index + increment * count * (int) Math.pow(-1, direction);
            if (hashmap.get(comparator) == null) {
                break;
            }

            hash = hashmap.get(comparator) % hashmapSize;

            if (hash - comparator != 0) {
                int lastHash = lastKey % hashmapSize;
                int distance = hash - comparator;
                int lastDistance = lastHash - lastEmpty;
                int distanceDifference = Math.abs(distance) - Math.abs(lastDistance);
                if (distanceDifference > 0 || (distanceDifference == 0 && lastDistance < 1)) {
                    hashmap.set(lastEmpty, hashmap.get(comparator));
                    lastKey = hashmap.get(comparator);
                    hashmap.set(comparator, null);
                    lastEmpty = comparator;
                }
            }
            direction++;
            count++;
            
            if(count > hashmapSize)break;
        }
    }

    public void tableAutoFill() {
        for (int i = 0; i < getHashmapSize(); i++) {
            hashmap.add(i, null);
        }
    }
}
