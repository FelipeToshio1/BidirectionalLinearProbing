public class Hash {

    private Integer[] hashmap;
    private int increment;
    private int cont;
    private int key;

    public void insert(int key) {

        int position = key % hashmap.length;

        if (hashmap[position] == 0) {
            hashmap[position] = position;
        } else {
            nextPosition(position, increment);
        }
    }

    public int nextPosition(int position, int increment) {

        int newPosition = position + increment * cont * (int) Math.pow(-1, cont);

        cont++;

        if (hashmap[newPosition] != null) {
            newPosition = nextPosition(position, increment);
        }
        return newPosition;

    }

    public int searchPosition(int position, int increment) {

        int search = position;

        int comparator = position + increment * cont * (int) Math.pow(-1, cont);

        cont++;

        if (search == hashmap[comparator]) {
            return search;
        } else {
            searchPosition(position, increment);
        }
        return 0;
    }

}
