import java.util.*;

public class Queens {
    static int[] result; 

    public void solve(int x, int size, ArrayList<Integer> count ) {
        for (int i = 0; i < size; i++) {
            if (isValid(x, i)) {
                result[x] = i;

                if (x == size - 1) {
                    count.add(1); 
                    System.out.printf("Order of " + size + " queens: " );
                    for (int n = 0; n < size; n++){
                        System.out.printf("(" + n + ", " + result[n] + ") ");
                    }
                    System.out.println();
                }

                solve(x+1, size, count);
            }
        }        
    }

    public boolean isValid(int j, int k) {
       
        for (int i = 0; i < j; i++) {
            if ((result[i] == k) || (Math.abs(i - j) == Math.abs(result[i] - k))) {
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the number of Queens problem: ");

    	int n = input.nextInt();
    	ArrayList<Integer> count = new ArrayList<Integer>();
    	Queens queen = new Queens();
    	result = new int[n];

    	queen.solve(0, n, count);

    	if(count.size() == 0){
    		System.out.println("There is no solution! ");
    	}else{
			System.out.println("The total number of solutions is " + count.size());
    	}
}
}