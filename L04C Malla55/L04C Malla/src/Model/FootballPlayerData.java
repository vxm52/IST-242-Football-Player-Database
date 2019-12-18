package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FootballPlayerData implements TableData, Displayable
{
    //For setters and getters implemented from Displayable
    private int firstLineToDisplay = 10;
    private int linkToHighlight = 0;
    private int lastLineToDisplay = 15;
    public int linesBeingDisplayed = 20;
    
    
    private ArrayList<FootballPlayer> players;

    public FootballPlayerData()
    {
        players = new ArrayList<>();
        linesBeingDisplayed = 20;
        firstLineToDisplay = 0;
        lastLineToDisplay = firstLineToDisplay + linesBeingDisplayed;
        int numberOfLines = 20;
        int lineToHighlight = 0;
        
        this.loadTable();
        
        getTable();
        
    }

    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    getPlayers().add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx) {xx.printStackTrace();}
    }
    
    @Override
    public void loadTable()
    {
        ReadPlayersFromXML();
    }
    
    @Override
    public ArrayList<FootballPlayer> getTable()
    {
        return getPlayers();
    }
    
    @Override
    public ArrayList<String> getHeaders()
    {
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
    public void setPlayers(ArrayList<FootballPlayer> players) 
    {
        this.players = players;
    }

    @Override
    public ArrayList<String> getLine(int line)
    {
        return getPlayers().get(line).getAttributes();
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) 
    {
        ArrayList<ArrayList<String>> x1 = new ArrayList<ArrayList<String>>();
       
        for (int i = firstLine; i <= lastLine; i++)
        {
            x1.add(getLine(i));
        }
        return x1;
    }

    @Override
    public int getFirstLineToDisplay() 
    {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() 
    {
        return linkToHighlight;
    }

    @Override
    public int getLastLineToDisplay() 
    {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() 
    {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) 
    {
        this.firstLineToDisplay = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine)
    {
        this.linkToHighlight = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) 
    {
        this.lastLineToDisplay = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) 
    {
        this.linesBeingDisplayed = numberOfLines;
    }
}
