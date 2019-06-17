
public class hash {
    
    private int hashmapSize;
    private int hashmap[];
    private int increment;
    private int cont;
    private int key;
    
    public void insert(){
        
        int position = key % hashmapSize;
        
        if(hashmap[position] == null){
            hashmap[position] = position;
        }
        else{
            nextPosition(position, increment);
        }
    }

    public int nextPosition(int position, int increment){

        int newPosition = position + increment * cont * Math.pow(-1, cont);

        cont++;

        if(hashmap[newPosition] == null){
            hashmap[newPosition] = newPosition;
        }
        else{
            nextPosition(position,increment)
        }
    }
    
    public int searchPosition(int position, int increment){

       int search = position;

       int comparator = position + increment * cont * Math.pow(-1, cont);

       cont++;

       if(search == hashmap[comparator]){
           return search;
       }
       else{
           searchPosition(position, increment);
       }
    }

}
