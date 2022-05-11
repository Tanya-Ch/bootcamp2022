public class Horse {
    static int size = 6;
    static int[][] desk = new int[size][size];
    int[][] step = {{1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}, {-2, -1}, {-1,-2}};
    static int n;

    public static void main(String [] args){
        Horse horse = new Horse();
        n = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                desk[i][j] = 0;
            }
        }
        horse.setHorse(1,1);
        horse.print();
    }

    private void print(){
        System.out.printf("n=%d\n", n);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf(" %2d", desk[i][j]);
            }
            System.out.print("\n");
        }
    }
    private boolean setHorse(int x, int y){
        if((x < 0 || x >= size) || (y < 0 || y >= size)){
            return false;
        }
        if(desk[x][y] != 0){
            return false;
        }
        n++;
        desk[x][y] = n;
        if(n == size*size){
            return true;
        }
        print();
        for (int i = 0; i < 8; i++) {
            if(setHorse(x + step[i][0], y + step[i][1])){
                return true;
            }
        }
        n--;
        desk[x][y] = 0;
        return false;
    }
}
