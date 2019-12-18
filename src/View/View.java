
package View;

import java.util.ArrayList;

public class View
{
    
    public void setupHeaders(int cols)
    {
        getIf().getIp().getCp().setupHeaders(cols);
        getIf().validate();
        getIf().repaint();
    }
    
    private InitialFrame If;
    
    public View()
    {
        If = new InitialFrame(); //Creates the Frame
    }

    public void updateHeaders(ArrayList<String> h)
    {
        getIf().getIp().getCp().updateHeaders(h);
    }

    public void setupLayout(int cols, int lines) 
    {
        getIf().getIp().getCp().setupLayout(cols, lines);
    }

    /**
     * @return the If
     */
    public InitialFrame getIf() {
        return If;
    }

    /**
     * @param If the If to set
     */
    public void setIf(InitialFrame If) {
        this.If = If;
    }

    public void setupTableArray(int rows,int cols) 
    {
        getIf().getIp().getCp().setupTableArray(rows, cols);
    }

    public void updateTableArray(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) 
    {
        getIf().getIp().getCp().updateTableArray(lines, headers);
    }
}
