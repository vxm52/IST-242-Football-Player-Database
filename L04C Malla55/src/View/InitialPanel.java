
package View;

import java.awt.BorderLayout;
import javax.swing.JPanel;


public class InitialPanel extends JPanel {

    private CenterPanel cp;
    private WestPanel wp;
    private NorthPanel np;

    public InitialPanel() {
        super();
        BorderLayout border = new BorderLayout();
        setLayout(border);
        
        np = new NorthPanel(); //Creates the NorthPanel
        add(np, BorderLayout.NORTH);
        
        cp = new CenterPanel(); //Creates the CenterPanel
        add(cp, BorderLayout.CENTER);
        
        wp = new WestPanel(); //Creates the WestPanel
        add(wp, BorderLayout.WEST);
        
        
    }

    public CenterPanel getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(CenterPanel cp) {
        this.cp = cp;
    }

    public WestPanel getWp() {
        return wp;
    }

    public void setWp(WestPanel wp) {
        this.wp = wp;
    }

    /**
     * @return the np
     */
    public NorthPanel getNp() {
        return np;
    }

    /**
     * @param np the np to set
     */
    public void setNp(NorthPanel np) {
        this.np = np;
    }

}
