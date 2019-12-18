package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FootballPlayerData implements TableData, Displayable, Sortable, Searchable {

    //For setters and getters implemented from Displayable
    private int firstLineToDisplay = 10;
    private int linkToHighlight = 0;
    private int lastLineToDisplay = 15;
    private int linesBeingDisplayed = 20;

    private int sortType = 0;
    private int sortField = 0;
    
    private int searchByField;
    private int foundIndex;
    private boolean found;


    private ArrayList<FootballPlayer> players;
    
    private Map<String, FootballPlayer> numberHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> nameHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> positionHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> heightHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> weightHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> homeTownHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> stateHash = new HashMap<String, FootballPlayer>();
    private Map<String, FootballPlayer> highSchoolHash = new HashMap<String, FootballPlayer>();

    public FootballPlayerData() 
    {
        players = new ArrayList<>();
        linesBeingDisplayed = 20;
        firstLineToDisplay = 0;
        lastLineToDisplay = firstLineToDisplay + linesBeingDisplayed - 1;
        //int numberOfLines = 20;
        int lineToHighlight = 0;

        sortType = 0;
        sortField = 0;

        this.loadTable();
        
        generateHash();
    }
    
    private void generateHash()
    {
        for(int k = 0; k < getPlayers().size(); k++)
        {
            getNumberHash().put(getPlayers().get(k).getAttribute(1), getPlayers().get(k)); //Gets the number
            getNameHash().put(getPlayers().get(k).getAttribute(1), getPlayers().get(k)); //Gets the name
            getPositionHash().put(getPlayers().get(k).getAttribute(2), getPlayers().get(k)); //Gets the position
            getHeightHash().put(getPlayers().get(k).getAttribute(3), getPlayers().get(k)); //Gets the height
            getWeightHash().put(getPlayers().get(k).getAttribute(4), getPlayers().get(k)); //Gets the weight
            getHomeTownHash().put(getPlayers().get(k).getAttribute(5), getPlayers().get(k)); //Gets the homeTown
            getStateHash().put(getPlayers().get(k).getAttribute(6), getPlayers().get(k)); //Gets the State
            getHighSchoolHash().put(getPlayers().get(k).getAttribute(7), getPlayers().get(k)); //Gets the highSchool
        }
        System.out.println("Name Hash works" + getNameHash().values().toString());
    }
    
    public void ReadPlayersFromXML() {
        try {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null) {
                try {
                    fp = (FootballPlayer) decoder.readObject();
                    getPlayers().add(fp);

                } catch (ArrayIndexOutOfBoundsException theend) {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {
            xx.printStackTrace();
        }
    }

    //Comparators for the headers (to sort data)
    private Comparator<FootballPlayer> number = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            if (fp1.getNumber() < (fp2.getNumber())) {
                return -1;
            }
            if (fp1.getNumber() == (fp2.getNumber())) {
                return 0;
            }
            return 1;
        }
    };

    private Comparator<FootballPlayer> name = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getName().compareTo(fp2.getName());
        }
    };

    private Comparator<FootballPlayer> position = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getPosition().compareTo(fp2.getPosition());
        }
    };

    private Comparator<FootballPlayer> height = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            if (fp1.getHeight().totalHeight(fp1.getHeight().getFeet(), fp1.getHeight().getInches()) < (fp2.getHeight().totalHeight(fp2.getHeight().getFeet(), fp2.getHeight().getInches()))) {
                return -1;
            }
            if (fp1.getHeight().totalHeight(fp1.getHeight().getFeet(), fp1.getHeight().getInches()) == (fp2.getHeight().totalHeight(fp2.getHeight().getFeet(), fp2.getHeight().getInches()))) {
                return 0;
            }
            return 1;
        }
    };

    private Comparator<FootballPlayer> weight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            if (fp1.getWeight() < (fp2.getWeight())) {
                return -1;
            }
            if (fp1.getWeight() == (fp2.getWeight())) {
                return 0;
            }
            return 1;
        }
    };

    private Comparator<FootballPlayer> homeTown = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getHometown().compareTo(fp2.getHometown());
        }
    };

    private Comparator<FootballPlayer> state = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getState().compareTo(fp2.getState());
        }
    };

    private Comparator<FootballPlayer> highSchool = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getHighSchool().compareTo(fp2.getHighSchool());
        }
    };

    @Override
    public void loadTable() {
        ReadPlayersFromXML();
    }

    @Override
    public ArrayList<FootballPlayer> getTable() {
        return getPlayers();
    }

    @Override
    public ArrayList<String> getHeaders() {
        return getPlayers().get(0).getAttributeNames();
    }

    /**
     * @return the players
     */
    public ArrayList<FootballPlayer> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<FootballPlayer> players) {
        this.players = players;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> a = getPlayers().get(line).getAttributes();

//        a.set(0, "" + line);
//        return a;
         return getPlayers().get(line).getAttributes();
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> x1 = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            x1.add(getLine(i));
        }
        return x1;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() {
        return getLinkToHighlight();
    }

    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        //0-3
        this.firstLineToDisplay = firstLine;
        //
        if (firstLineToDisplay < 0) {
            firstLineToDisplay = 0;
        }

        if (firstLineToDisplay >= (getPlayers().size() - getLinesBeingDisplayed())) {
            firstLineToDisplay = getPlayers().size() - getLinesBeingDisplayed();
        }

        setLastLineToDisplay(firstLineToDisplay + getLinesBeingDisplayed() - 1);
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.setLinkToHighlight(highlightedLine);
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineToDisplay = lastLine;

    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }
    private int minimumPosition(int from) 
    {
        int minValue = from;
        for(int i = from + 1; i < getPlayers().size(); i++)
                {   
                    if(getSortField() == 3)
                    {
                        if(getPlayers().get(i).getHeight().totalHeight() < getPlayers().get(minValue).getHeight().totalHeight()) //Need to compare the height separately. This if-statement compares the total height, whereas the other one that includes all attributes only compares the height's feet
                        {
                            minValue = i;
                        }
                    }
                    else
                    if (getPlayers().get(i).getAttribute(getSortField()).compareTo(getPlayers().get(minValue).getAttribute(getSortField())) < 0)    //Checks if the value is less than 0
                    {
                        minValue = i; //minValue is set to var1       
                    }
                }
        return minValue;
    }

    @Override
    public void sort(int sortType, int sortField) //SORTING METHOD ****************
    {
        
        
        //Ask about sort type
        
        if(sortType == 1) //Selection Sort
        {
            System.out.println("selection");
            for (int i = 0; i < getPlayers().size() - 1; i++)
            {
                int minValue = minimumPosition(i);
                Collections.swap(getPlayers(), minValue, i); //Swaps the positions of the compared players
//                System.out.println(minValue+" "+i);
            }
        }
        
        if (sortType == 2)  //Merge Sort 
        {
            //choose comaparator base on sort field
            if (sortField == 0)
            {
                Collections.sort(getPlayers(), getNumber()); //sort type 2 sort field 0
            }
            if (sortField == 1) 
            {
                Collections.sort(getPlayers(), getName());  //sort type 2 sort field 1
            }
            if (sortField == 2)
            {
                Collections.sort(getPlayers(), getPosition()); //sort type 2 sort field 2
            }
            if (sortField == 3) 
            {
                Collections.sort(getPlayers(), getHeight()); //sort type 2 sort field 3
            }
            if (sortField == 4)
            {
                Collections.sort(getPlayers(), getWeight()); //sort type 2 sort field 4
            }
            if (sortField == 5) 
            {
                Collections.sort(getPlayers(), getHomeTown()); //sort type 2 sort field 5
            }
            if (sortField == 6)
            {
                Collections.sort(getPlayers(), getState()); //sort type 2 sort field 6
            }
            if (sortField == 7) 
            {
                Collections.sort(getPlayers(), getHighSchool()); //sort type 2 sort field 7
            }
        }
        
        if (sortType == 3) //Quick Sort
        {
            FootballPlayer[] newFootballPlayerArray = new FootballPlayer[getPlayers().size()]; //Creates a new blank array of the size of "players"
            getPlayers().toArray(newFootballPlayerArray); //Switches players from an ArrayList to an Array. Fills newFootballPlayerArray array with "players" data
            
            if (sortField == 0)
            {
                Arrays.sort(newFootballPlayerArray, getNumber()); //sort type 3 sort field 0
            }
            if (sortField == 1)
            {
                Arrays.sort(newFootballPlayerArray, getName()); //sort type 3 sort field 1
            }
            if (sortField == 2)
            {
                Arrays.sort(newFootballPlayerArray, getPosition()); //sort type 3 sort field 2
            }
            if (sortField == 3)
            {
                Arrays.sort(newFootballPlayerArray, getHeight()); //sort type 3 sort field 3
            }
            if (sortField == 4)
            {
                Arrays.sort(newFootballPlayerArray, getWeight()); //sort type 3 sort field 4
            }
            if (sortField == 5)
            {
                Arrays.sort(newFootballPlayerArray, getHomeTown()); //sort type 3 sort field  5
            }
            if (sortField == 6)
            {
                Arrays.sort(newFootballPlayerArray, getState()); //sort type 3 sort field 6
            }
            if (sortField == 7)
            {
                Arrays.sort(newFootballPlayerArray, getHighSchool()); //sort type 3 sort field 7
            }
            
            List<FootballPlayer> newFootballPlayerArray2 = Arrays.asList(newFootballPlayerArray); //Converts newFootballPlayerArray from an array to an arrayList
            setPlayers(new ArrayList<FootballPlayer>(newFootballPlayerArray2));
        }
    }

    @Override
    public int getSortType() {
        return sortType;
    }

    @Override
    public void SetSortType(int sortType) {
        this.setSortType(sortType);
    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void SetSortField(int sortField) {
        this.setSortField(sortField);
    }

    /**
     * @return the linkToHighlight
     */
    public int getLinkToHighlight() {
        return linkToHighlight;
    }

    /**
     * @param linkToHighlight the linkToHighlight to set
     */
    public void setLinkToHighlight(int linkToHighlight) {
        this.linkToHighlight = linkToHighlight;
    }

    /**
     * @param sortType the sortType to set
     */
    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    /**
     * @param sortField the sortField to set
     */
    public void setSortField(int sortField) {
        this.sortField = sortField;
    }

    /**
     * @return the number
     */
    public Comparator<FootballPlayer> getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Comparator<FootballPlayer> number) {
        this.number = number;
    }

    /**
     * @return the name
     */
    public Comparator<FootballPlayer> getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Comparator<FootballPlayer> name) {
        this.name = name;
    }

    /**
     * @return the position
     */
    public Comparator<FootballPlayer> getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Comparator<FootballPlayer> position) {
        this.position = position;
    }

    /**
     * @return the height
     */
    public Comparator<FootballPlayer> getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Comparator<FootballPlayer> height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public Comparator<FootballPlayer> getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(Comparator<FootballPlayer> weight) {
        this.weight = weight;
    }

    /**
     * @return the homeTown
     */
    public Comparator<FootballPlayer> getHomeTown() {
        return homeTown;
    }

    /**
     * @param homeTown the homeTown to set
     */
    public void setHomeTown(Comparator<FootballPlayer> homeTown) {
        this.homeTown = homeTown;
    }

    /**
     * @return the state
     */
    public Comparator<FootballPlayer> getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(Comparator<FootballPlayer> state) {
        this.state = state;
    }

    /**
     * @return the highSchool
     */
    public Comparator<FootballPlayer> getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(Comparator<FootballPlayer> highSchool) {
        this.highSchool = highSchool;
    }

    
    //*********************Searchable Interface Methods ***********************
    @Override
    public boolean search(String searchTerm) 
    {
        if (getSearchByField() == 0) 
        {
            if (getNumberHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getNumberHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("Number has been HASHED"+ this.getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 1) 
        {
            if (getNameHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getNameHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("Name has been HASHED"+ this.getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 2) 
        {
            if (getPositionHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getPositionHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("Position has been HASHED");
                return true;
            }
        }
        if (getSearchByField() == 3) 
        {
            if (getHeightHash().containsKey(searchTerm))
            {
                setFoundIndex(getPlayers().indexOf(getHeightHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("Height has been HASHED");
                return true;
            }
        }
        if (getSearchByField() == 4) 
        {
            if (getWeightHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getWeightHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("Weight has been HASHED");
                return true;
            }
        }
        if (getSearchByField() == 5) 
        {
            if (getHomeTownHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getHomeTownHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("HomeTown has been HASHED");
                return true;
            }
        }
        if (getSearchByField() == 6) 
        {
            if (getStateHash().containsKey(searchTerm)) 
            {
                setFoundIndex(getPlayers().indexOf(getStateHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("State has been HASHED");
                return true;
            }
        }
        if (getSearchByField() == 7) 
        {
            if (getHighSchoolHash().containsKey(searchTerm))
            {
                setFoundIndex(getPlayers().indexOf(getHighSchoolHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                System.out.println("HighSchool has been HASHED");
                return true;
            }
        }
        System.out.println("Search Failed");
        setFound(false);
        return false;
    }

    @Override
    public int getFoundIndex() 
    {
        return foundIndex;
    }

    @Override
    public void setFoundIndex(int tableMemberindex) 
    {
        this.foundIndex = tableMemberindex;
    }
   
    @Override
    public boolean getFound() 
    {
        return isFound();
    }

    @Override
    public void setFound(boolean searchResult) 
    {
        this.found = searchResult;
    }

    @Override
    public int getSearchByField() 
    {
        return searchByField;
    }

    @Override
    public void setSearchByField(int fieldIndex) 
    {
        this.searchByField = fieldIndex;
    }
    
    //***************************************************************
    
    /**
     * @return the numberHash
     */
    public Map<String, FootballPlayer> getNumberHash() {
        return numberHash;
    }

    /**
     * @param numberHash the numberHash to set
     */
    public void setNumberHash(Map<String, FootballPlayer> numberHash) {
        this.numberHash = numberHash;
    }
    
    /**
     * @return the nameHash
     */
    public Map<String, FootballPlayer> getNameHash() {
        return nameHash;
    }

    /**
     * @param nameHash the nameHash to set
     */
    public void setNameHash(Map<String, FootballPlayer> nameHash) {
        this.nameHash = nameHash;
    }

    /**
     * @return the positionHash
     */
    public Map<String, FootballPlayer> getPositionHash() {
        return positionHash;
    }

    /**
     * @param positionHash the positionHash to set
     */
    public void setPositionHash(Map<String, FootballPlayer> positionHash) {
        this.positionHash = positionHash;
    }

    /**
     * @return the heightHash
     */
    public Map<String, FootballPlayer> getHeightHash() {
        return heightHash;
    }

    /**
     * @param heightHash the heightHash to set
     */
    public void setHeightHash(Map<String, FootballPlayer> heightHash) {
        this.heightHash = heightHash;
    }

    /**
     * @return the weightHash
     */
    public Map<String, FootballPlayer> getWeightHash() {
        return weightHash;
    }

    /**
     * @param weightHash the weightHash to set
     */
    public void setWeightHash(Map<String, FootballPlayer> weightHash) {
        this.weightHash = weightHash;
    }

    /**
     * @return the homeTownHash
     */
    public Map<String, FootballPlayer> getHomeTownHash() {
        return homeTownHash;
    }

    /**
     * @param homeTownHash the homeTownHash to set
     */
    public void setHomeTownHash(Map<String, FootballPlayer> homeTownHash) {
        this.homeTownHash = homeTownHash;
    }

    /**
     * @return the stateHash
     */
    public Map<String, FootballPlayer> getStateHash() {
        return stateHash;
    }

    /**
     * @param stateHash the stateHash to set
     */
    public void setStateHash(Map<String, FootballPlayer> stateHash) {
        this.stateHash = stateHash;
    }

    /**
     * @return the highSchoolHash
     */
    public Map<String, FootballPlayer> getHighSchoolHash() {
        return highSchoolHash;
    }

    /**
     * @param highSchoolHash the highSchoolHash to set
     */
    public void setHighSchoolHash(Map<String, FootballPlayer> highSchoolHash) {
        this.highSchoolHash = highSchoolHash;
    }

    /**
     * @return the found
     */
    public boolean isFound() {
        return found;
    }

}
