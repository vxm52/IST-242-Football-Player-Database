
package View;

import javax.swing.JButton;

public class JButtons extends JButton
{
    int n;
    
    public JButtons()
    {
        for(int i = 0; i < 5; i++)
        {
            i = n;
            setText("Line Button" + n); 
        }
        
    }
    
}
