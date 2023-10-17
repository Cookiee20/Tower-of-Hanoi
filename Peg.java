import java.util.ArrayList;

public class Peg {

    // Initiating variables used within the class
    private String pegName;
    private ArrayList<Integer> disks;
    private int total;
    
    // CONSTRUCTORS
    public Peg(String pegName) {
        this.pegName = pegName;
        this.disks = new ArrayList<Integer>();
        this.total = 0;
    }
    
    public Peg(String pegName, ArrayList<Integer> disks) {
        this.pegName = pegName;
        this.disks = disks;
        this.total = 0;
    }
        
    // ACCESSOR
    public String getPegName() {
        return pegName;
    }
    
    public int getTotal() {
        return total;
    }
    
    // SETTER
    public void setTotal(int total) {    
        this.total = total;
    }

    // The move disk action
    public void moveDisk(int n, Peg toPeg) {
        // Remove the disk from the peg
        disks.remove(disks.indexOf(n));
        // Add disk to the destination peg
        toPeg.disks.add(n);
        // Empty strings for peg name gathering
        String temp1 = "";
        String temp2 = "";
        
        // Checking which letter the from peg is related to
        if (pegName.equals("Start")){
            temp1 = "A";
        }
        if (pegName.equals("Temp")){
            temp1 = "B";
        }
        if (pegName.equals("End")){
            temp1 = "C";
        }
        
        // Checking which letter the to peg is related to
        if (toPeg.getPegName().equals("Start")){
            temp2 = "A";
        }
        if (toPeg.getPegName().equals("Temp")){
            temp2 = "B";
        }
        if (toPeg.getPegName().equals("End")){
            temp2 = "C";
        }
        // Adding a move to the total count for specific peg
        toPeg.setTotal(toPeg.getTotal()+1);
        
        // Printing the message
        System.out.println("Moved disk " + n + " from peg " + temp1 + " to " + temp2);
    }
}
