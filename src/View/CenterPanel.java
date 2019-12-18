
package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class CenterPanel extends JPanel
{

    /**
     * @return the tableArray
     */
    public ArrayList<JButton> getTableArray() {
        return tableArray;
    }

    /**
     * @param tableArray the tableArray to set
     */
    public void setTableArray(ArrayList<JButton> tableArray) {
        this.tableArray = tableArray;
    }

    /**
     * @return the headers
     */
    public ArrayList<JLabel> getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(ArrayList<JLabel> headers) {
        this.headers = headers;
    }

    /**
     * @return the bs
     */
    public ArrayList<ArrayList<JButtons>> getBs() {
        return bs;
    }

    /**
     * @param bs the bs to set
     */
    public void setBs(ArrayList<ArrayList<JButtons>> bs) {
        this.bs = bs;
    }
    private ArrayList<JButton> tableArray; // declares the tables ArrayList 
    private ArrayList<JLabel> headers; 
    private ArrayList<ArrayList<JButtons>> bs;
    //getLines()
    
    
    public CenterPanel()
    {
        super();
        setBackground(Color.gray);
        
        bs = new ArrayList<>();
        headers = new ArrayList<>(); // Creates the ArrayList of headers
        tableArray = new ArrayList<>();
    }
    
    public void setupLayout(int cols, int lines)
    {
        setLayout(new GridLayout(lines + 1, cols));
    }
    public void updateHeaders(ArrayList<String> h)
    {
        for(int i = 0; i < h.size(); i++)
        {
            getHeaders().get(i).setText(h.get(i));
            getHeaders().get(i).setForeground(Color.black);
            getHeaders().get(i).setOpaque(true);
            getHeaders().get(i).setBackground(Color.LIGHT_GRAY);
            add(getHeaders().get(i));
        }
        validate();
        repaint();
    }
    
    public void setupHeaders(int cols)
    {
        for(int i = 0; i < cols; i++)
        {
            JLabel jlo = new JLabel(""+i);
            getHeaders().add(jlo);
            add(jlo);
        }
        validate();
        repaint();
    }
    
    public void setupTableArray(int rows,int cols)
    {
        for(int j = 0; j < rows; j++)
        {
            for(int i = 0; i < cols; i++)
            {
                JButton jbu = new JButton(j+"-"+i);
                getTableArray().add(jbu);
                add(jbu);
            }    
        }    
        validate();
        repaint();
    }
    
    public void updateTableArray(ArrayList<ArrayList<String>> lines, ArrayList<String> headers)
    {
        int butcount=0;
        for(int j = 0; j < lines.size(); j++)
        {
            ArrayList<String> test = lines.get(j);
            for(int k = 0; k < test.size(); k++)
            {
                getTableArray().get(butcount).setText(test.get(k));
                butcount++;
            }
        }
    }
    
    public void lineToHighlight(int n)
    {
        System.out.println("Found player(s) highlighted");
        
        for(int p = 0; p < 8; p++) //For loop so that each button in the row is highlighted
        {
        tableArray.get(p).setBackground(Color.YELLOW); //This statement will highlight a button in the found row
        }
    }
}
