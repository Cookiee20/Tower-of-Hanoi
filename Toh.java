import java.util.*;

public class Toh {
    public static void main(String[] args) {
        // Creating scanner object
        Scanner input = new Scanner(System.in);
        // Gathering number of disks from user
        System.out.print("Please specify how many disks you want: ");
        int numberOfDisks = input.nextInt();
        System.out.print("\n");
        int total = 0;
        
        // Initiating array list of disks
        ArrayList<Integer> disks = new ArrayList<Integer>();
        // Adding disks into the array list
        for(int i = 0; i < numberOfDisks; i++) {
            disks.add(i+1);
        }
        
        // Creating the three pegs utilized in the program
        Peg start = new Peg("Start", disks);
        Peg temp = new Peg("Temp");
        Peg end = new Peg("End");
        
        // Calling the recursive method
        TowerOfHanoi(numberOfDisks, start, temp, end);
        
        // Gathering total of moves made to each peg
        total += start.getTotal();
        total += end.getTotal();
        total += temp.getTotal();
        // Printing total number of moves
        System.out.println("\n");
        System.out.println("You made a total of " + total + " moves!");
    }
    
    // Recursive method
    public static void TowerOfHanoi(int n, Peg start, Peg temp, Peg end) {
        // When down to one disk in stack...
        if(n == 1) {
            // Move the disk to the end peg
            start.moveDisk(n, end);
            // Call off recursion
            return;
        }
        
        // Move n-1 stack from start to end
        TowerOfHanoi(n - 1, start, end, temp);
        start.moveDisk(n, end);
        // Move n-1 stack but with start now being temp and end now being start
        TowerOfHanoi(n - 1, temp, start, end);
    }
}
