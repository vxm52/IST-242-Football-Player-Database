
package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class CenterPanel extends JPanel
{
    ArrayList<JButton> tableArray; // declares the tables ArrayList 
    ArrayList<JLabel> headers; 
    ArrayList<ArrayList<JButtons>> bs;
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
        setLayout(new GridLayout(0, 8));
    }
    public void updateHeaders(ArrayList<String> h)
    {
        for(int i = 0; i < h.size(); i++)
        {
            headers.get(i).setText(h.get(i));
            headers.get(i).setForeground(Color.black);
            headers.get(i).setOpaque(true);
            headers.get(i).setBackground(Color.LIGHT_GRAY);
            add(headers.get(i));
        }
        validate();
        repaint();
    }
    
    public void setupHeaders(int cols)
    {
        for(int i = 0; i < cols; i++)
        {
            JLabel jlo = new JLabel(""+i);
            headers.add(jlo);
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
                tableArray.add(jbu);
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
                tableArray.get(butcount).setText(test.get(k));
               // tableArray.get(k).setVisible(true);
               // add(tableArray.get(k));
                butcount++;
            }
            
        }
        for(int k = 0; k < lines.size(); k++)
        {
            add(tableArray.get(k));
        }
       
    }
    
}
