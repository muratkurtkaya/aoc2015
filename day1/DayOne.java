import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class DayOne {
    public static void main(String args[]) {
      String puzzleData = readTxt();

      System.out.println("First part: " + solveFirstPart(puzzleData));
      System.out.println("Second part: " + solveSecondPart(puzzleData));
      
    }

    public static String readTxt(){
      String puzzle = "";
      try {
      File myObj = new File("input.txt");
      Scanner myReader = new Scanner(myObj);
      puzzle = myReader.nextLine();
      } catch (FileNotFoundException err){
        System.out.println("File read error occured.");
        err.printStackTrace();
      }
      return puzzle;
    }

    public static int solveFirstPart(String puzzle){
      int leftBracket = (int) puzzle.chars().filter(ch -> ch == '(').count();
      return (2 * leftBracket - puzzle.length());
      }

    public static int solveSecondPart(String puzzle){
      int floor = 0, i = 0;
      for(i = 0; i < puzzle.length(); i++){
        int result = puzzle.charAt(i) == '(' ? floor++ : floor--;
        if(floor==-1) break;
      }
      return i+1;
    }


}