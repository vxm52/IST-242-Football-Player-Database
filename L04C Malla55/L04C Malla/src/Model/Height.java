package Model;


public class Height 
{
    private int feet;
    private int inches;
    
    //Constructor Method
    public Height(int infFeet, int infInches)
    {
        feet = infFeet;
        inches = infInches;
    }
    
    public Height()
    {
        
    }
    
    @Override
    public String toString()
    {
        return getFeet() + "'" + getInches() + "''"; 
    }

    /**
     * @return the feet
     */
    public int getFeet() {
        return feet;
    }

    /**
     * @param feet the feet to set
     */
    public void setFeet(int feet) {
        this.feet = feet;
    }

    /**
     * @return the inches
     */
    public int getInches() {
        return inches;
    }

    /**
     * @param inches the inches to set
     */
    public void setInches(int inches) {
        this.inches = inches;
    }
}
