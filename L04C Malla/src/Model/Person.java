package Model;


public class Person 
{
    private String name;
    private  Height height;
    private int weight;
    private String hometown;
    private String state;
    private String highSchool;
    
    public Person(String a, Height b, int c, String d, String e, String f)
    {
        name = a;
        height = b;
        weight = c;
        hometown = d;
        state = e;
        highSchool = f;
    }
    
     public Person()
    {
        
    }
     
     
    @Override
    public String toString()
    {
        return getName() + " " + getHeight() + " " + getWeight() + " " + getHometown() + " " + getHighSchool() + " " + getState(); 
    }
    
    public String getInfo()
    {
        return "Name: " + getName() + "\nHeight: " + getHeight().getFeet() + "'" + getHeight().getInches() + "\nWeight: " + getWeight() + "\nHome Town: " + getHometown() + "\nHigh School: " + getHighSchool() + "\nState: " + getState();
    }

    public Height getHeight() {
        return height;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Height height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the hometown
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * @param homeTown the hometown to set
     */
    public void setHometown(String homeTown) {
        this.hometown = homeTown;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }
    
}
