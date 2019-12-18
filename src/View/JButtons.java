
package View;

import javax.swing.JButton;

public class JButtons extends JButton
{
    private int n;
    
    public JButtons()
    {
        for(int i = 0; i < 5; i++)
        {
            i = n;
            setText("Line Button" + n); 
        }
        
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
}
