package Model;

import java.util.ArrayList;


public class FootballPlayer extends Person implements TableMember
{
    private int number;
    private String position;
    
    private ArrayList<String> arr = new ArrayList<String>();    
    
    
    public FootballPlayer(int g, String a, String p, Height b, int c, String d, String e, String f)
    {
        super(a, b, c, d, e, f);
        //calling the constructor of Person
        number = g;
        position = p;
        
        arr.add(a);
        arr.add(b.toString());
        arr.add(String.valueOf(c));
        arr.add(d);
        arr.add(e);
        arr.add(f);
        arr.add(String.valueOf(g));
        arr.add(p);
    }

    public FootballPlayer() 
    {
        
    }
    
    @Override
    public String toString()
    {
        String f = super.getInfo() + "\nNumber: " + getNumber() + "\nPosition: " + getPosition() + "\n\n";
        return f;
    }

    @Override
    public String getAttribute(int n) 
    {
        if(n == 0)
        {
            return Integer.toString(getNumber());
        }
        
        if(n == 1)
        {
            return getName();
        }
        
        if(n == 2)
        {
            return getPosition();
        }
        
        if(n == 3)
        {
            return super.getHeight().toString();
        }
        
        if(n == 4)
        {
            return Integer.toString(getWeight());
        }
        
        if(n == 5)
        {
            return getHometown();
        }
        
        if(n == 6)
        {
            return getState();
        }
        
        if(n == 7)
        {
            return getHighSchool();
        }
        
        return "";
    }

    @Override
    public ArrayList<String> getAttributes() 
    {
        ArrayList <String> mm = new ArrayList <String>();
       
        mm.add(Integer.toString(getNumber()));
        mm.add(getName());
        mm.add(getPosition());
        mm.add(super.getHeight().toString());
        mm.add(Integer.toString(getWeight()));
        mm.add(getHometown());
        mm.add(getState());
        mm.add(getHighSchool());
        
        return mm;
    }

    @Override
    public String getAttributeName(int n) 
    {
        if(n == 0)
        {
            return "Number";
        }
        
        if(n == 1)
        {
            return "Name";
        }
        
        if(n == 2)
        {
            return "Position";
        }
        
        if(n == 3)
        {
            return "Height";
        }
        
        if(n == 4)
        {
            return "Weight";
        }
        
        if(n == 5)
        {
            return "Home Town";
        }
        
        if(n == 6)
        {
            return "State";
        }
        
        if(n == 7)
        {
            return "High School";
        }
        
        return "";
    }

    @Override
    public ArrayList<String> getAttributeNames() 
    {
        ArrayList <String> nn = new ArrayList <String>();
       
        nn.add("number");
        nn.add("name");
        nn.add("position");
        nn.add("height");
        nn.add("weight");
        nn.add("homeTown");
        nn.add("state");
        nn.add("highSchool");
        
        return nn;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the arr
     */
    public ArrayList<String> getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(ArrayList<String> arr) {
        this.arr = arr;
    }
}

