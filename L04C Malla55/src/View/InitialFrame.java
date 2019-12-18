package View;

import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class InitialFrame extends JFrame
{

    private InitialPanel ip;

    public InitialFrame()
    {
        super("A04C - Graphics, Data, and Interfaces with MVC");
        setupLayoutForMacs();
        ip = new InitialPanel(); //Creates InitialPanel
        add(ip, "Center");
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(840, 640);
        setVisible(true);
    }

    private void setupLayoutForMacs()
    {
        // On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear    
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }

    /**
     * @return the ip
     */
    public InitialPanel getIp()
    {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(InitialPanel ip)
    {
        this.ip = ip;
    }
}
