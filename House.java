import java.util.ArrayList;

/**
 * Represents a House that extends Building and implements HouseRequirements.
 * A House can have multiple residents and contains a dining room.
 */
public class House extends Building implements HouseRequirements {

    // House specific attributes
    private ArrayList<Student> residents; 
    private boolean hasDiningRoom;

    /**
     * Constructs a new House with the specified details.
     * 
     * @param name the name of the house
     * @param address the address of the house
     * @param nFloors the number of floors in the house
     * @param hasDiningRoom indicates whether the house has a dining room
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.hasDiningRoom = hasDiningRoom;
        this.residents = new ArrayList<Student>();
    }

    /**
     * Checks if the house has a dining room.
     * 
     * @return true if the house has a dining room, false otherwise
     */
    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    /**
     * Returns the number of residents in the house.
     * 
     * @return the number of residents
     */
    public int nResidents() {
        return this.residents.size();
    }

    /**
     * Moves a student into the house, if not already a resident.
     * 
     * @param s the student to move in
     * @throws RuntimeException if the student is already a resident
     */
    public void moveIn(Student s) {
        if (!residents.contains(s)) { // Check if the student is already in the house
            residents.add(s); // Add the student to the house
            System.out.println(s.getName() + " has moved in.");
        } else {
            throw new RuntimeException("The student is already in this house and cannot move in. Please try another house!");
        }
    }

    /**
     * Moves a student out of the house.
     * 
     * @param s the student to move out
     * @return the student that was moved out
     * @throws RuntimeException if the student is not a resident of the house
     */
    public Student moveOut(Student s) {
        if (residents.contains(s)) {
            residents.remove(s);
            return s;
        } else {
            throw new RuntimeException("The student is not in this house and cannot move out.");
        }
    }

    /**
     * Checks if a student is a resident of the house.
     * 
     * @param s the student to check
     * @return true if the student is a resident, false otherwise
     */
    public boolean isResident(Student s) {
        return residents.contains(s);
    }

    /**
     * Main method to test the functionality of the House class.
     */
    public static void main(String[] args) {
        House myHouse = new House("Green House", "123 Elm Street", 3, true);

        // Print house details (make sure to override toString() in House or Building)
        System.out.println("House Created: " + myHouse);

        // Create students
        Student s1 = new Student("Tabz", "12345", 20);
        Student s2 = new Student("Githinji", "67890", 21);

        // Test moving students in
        myHouse.moveIn(s1);
        myHouse.moveIn(s2);

        // Check residents count
        System.out.println("Number of residents: " + myHouse.nResidents());

        // Check if a student is a resident
        System.out.println("Is Tabz a resident? " + myHouse.isResident(s1));
        System.out.println("Is Githinji a resident? " + myHouse.isResident(s2));

        // Test moving a student out
        myHouse.moveOut(s1);
        System.out.println("Tabz has moved out.");

        // Check residents count after moving out
        System.out.println("Number of residents after move out: " + myHouse.nResidents());

        // Check if Tabz is still a resident
        System.out.println("Is Tabz a resident? " + myHouse.isResident(s1));
    }
}
