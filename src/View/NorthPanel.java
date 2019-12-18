
package View;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NorthPanel extends JPanel
{
    private JTextField searchField;
    
    public NorthPanel()
    {
        super();
        GridLayout grid = new GridLayout (1,8,1,1);
        setLayout(grid);
        
        searchField = new JTextField();
        this.add(searchField);
        searchField.setAlignmentX(JTextField.CENTER);
    }

    /**
     * @return the searchField
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }
}
