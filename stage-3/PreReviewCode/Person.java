/**
 * This class holds people's infomration.
 * @author 
 * Date:
 * Assignment: Final Project, CSCI 2210
 */
class Person {

    private String name;
    private int age;
    private String email;

    /**
     * This method is the constructor for this class.
     * @param name A person's name as a string.
     * @param age A person's age as an int.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * This method returns a person's name.
     * @return Returns's person's name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns a person's age.
     * @return Returns a person's age as an int.
     */
    public int getAge() {
        return age;
    }

    /**
     * This method will return a person's email.
     * @return Returns a person's email as a string.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method will change a person's name.
     * @param name A person's name as a string.
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * This method will change a person's age.
     * @param age A person's age as an int.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * This method will change a person's email.
     * @param email A person's email as a string.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}