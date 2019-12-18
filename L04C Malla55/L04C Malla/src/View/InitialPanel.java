/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author vxm52
 */
public class InitialPanel extends JPanel
{
    public CenterPanel cp;
    
    public InitialPanel()
    {
        super();
        GridLayout grid = new GridLayout (1,1,5,5);
        setLayout(grid);
        cp = new CenterPanel(); //Creates the CenterPanel
        add(cp);
    }
    
     public CenterPanel getCp()
    {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(CenterPanel cp)
    {
        this.cp = cp;
    }
    
}
