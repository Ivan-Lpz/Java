import java.util.Arrays;        // for primitive arrays
import java.util.ArrayList;    // for dynamic arrays

public class ArraysTest {

    public static void main(String[] bobs) {
        // System.out.println("test");



        int[] myArray;
        myArray = new int[5];    // Initialization
        // [0,0,0,0,0,]    this is the value because we didnt give it any so its automatically 0's 
        String name; // null
        int x; // 0 we can decalre all these but automatically they will have no value 
        double y; // 0.0


        myArray[0] = 4;
        myArray[1] = 8;
        myArray[2] = 8;
        myArray[3] = 5;
        myArray[4] = 9;

        System.out.println(Arrays.toString(myArray));

        for(int i = 0; i<myArray.length; i++) {
            System.out.println(myArray[i]);   // this is how we loop over a primitive array if added a + 1 it will add every number in the array with a 1
        }

        String[] names = {"bob", "john", "jenny"};
        System.out.println(Arrays.toString(names));  // these are all primitive arrays but dynamic arrays are next and they are more important
    
    // Dyanmic Arrays 

    ArrayList<String> people = new ArrayList<String>();         //everything inside the alligator mouths must be a class wrapper/object class
    people.add("bob");
    people.add("Jenny");
    people.add("Tyler");
    // people.remove("bob");       //you can either remove bob like this or like this people.remove(0); because bob is at the 0 index
    // System.out.println(people);
    System.out.println("-----\n -----");

    for (int i = 0; i<people.size() ; i++) {
        // System.out.println(people.get(i));
        // String aName = people.get(i);
        // System.out.println(aName + " is awesome");  // this just prints and concanates but if you want to truly want to change the values in the array then we must do somehthing different
        people.set(i, people.get(i) + " is awesome");  //with this now the original array has been manipulated
    }
    System.out.println(people);

    for (String someName : people) {
        System.out.println("e: " + someName);
    }  
    }
}

