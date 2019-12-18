
package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;


public class WestPanel extends JPanel
{
        private ArrayList<JButton> sortTypeButtons; 
        private JButton b1;
        private JButton b2;
        private JButton b3;
        private JButton b4;
    
    public WestPanel()
    {
        super();
        GridLayout grid = new GridLayout (4,1,1,1);
        setLayout(grid);
        
        sortTypeButtons = new ArrayList<>(); // Creates the ArrayList of sortTypeButtons
        setupSortTypeButtons();
//        updateSortTypeButtons();

    }
    
    public void updateSortTypeButtons()
    {
        System.out.println("HI"+getSortTypeButtons().size());
        
        for(int i = 1; i <= getSortTypeButtons().size(); i++)
        {
            getSortTypeButtons().add(getSortTypeButtons().get(i));
            getSortTypeButtons().get(i).setForeground(Color.white);
            getSortTypeButtons().get(i).setOpaque(true);
            getSortTypeButtons().get(i).setBackground(Color.black);
        }
        validate();
        repaint();
    }
    
    public void setupSortTypeButtons() 
    {
        setB1(new JButton("Choose a SORT Type"));
        getSortTypeButtons().add(getB1());
        getB1().setForeground(Color.WHITE);
        getB1().setBackground(Color.GRAY);
        add(getB1());
        
        setB2(new JButton("(1) Selection/Write Yourself"));
        getSortTypeButtons().add(getB2());
        getB2().setForeground(Color.BLACK);
        getB2().setBackground(Color.WHITE);
        add(getB2());
        
        setB3(new JButton("(2) Merge/ArrayList()"));
        getSortTypeButtons().add(getB3());
        getB3().setForeground(Color.BLACK);
        getB3().setBackground(Color.WHITE);
        add(getB3());
        
        setB4(new JButton("(3) Quick/Arrays[]"));
        getSortTypeButtons().add(getB4());
        getB4().setForeground(Color.BLACK);
        getB4().setBackground(Color.WHITE);
        add(getB4());

        validate();
        repaint();
    }

    public ArrayList<JButton> getSortTypeButtons() {
        return sortTypeButtons;
    }

    public void setSortTypeButtons(ArrayList<JButton> sortTypeButtons) {
        this.sortTypeButtons = sortTypeButtons;
    }

    /**
     * @return the b1
     */
    public JButton getB1() {
        return b1;
    }

    /**
     * @param b1 the b1 to set
     */
    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    /**
     * @return the b2
     */
    public JButton getB2() {
        return b2;
    }

    /**
     * @param b2 the b2 to set
     */
    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    /**
     * @return the b3
     */
    public JButton getB3() {
        return b3;
    }

    /**
     * @param b3 the b3 to set
     */
    public void setB3(JButton b3) {
        this.b3 = b3;
    }

    /**
     * @return the b4
     */
    public JButton getB4() {
        return b4;
    }

    /**
     * @param b4 the b4 to set
     */
    public void setB4(JButton b4) {
        this.b4 = b4;
    }
    
    
    
}
