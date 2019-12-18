package Controller;

import Model.FootballPlayer;
import Model.Model;
import View.View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Controller {

    private Model model;
    private View view;
   

    private int k = 0;

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.setupLayout(model.getFpData().getHeaders().size(), model.getFpData().getLinesBeingDisplayed());
        view.setupHeaders(model.getFpData().getHeaders().size());
        view.updateHeaders(model.getFpData().getHeaders());
        view.setupTableArray(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
        view.updateTableArray(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        addScrolling();
        highlighter();
        searcherEnterKey();
    }

    private void addScrolling() {
        getView().getIf().getIp().getCp().addMouseWheelListener(
                new MouseWheelListener() {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent e) {
                        int units = e.getUnitsToScroll();
                      //  System.out.println("units=" + units);
                        getModel().getFpData().setFirstLineToDisplay(units + getModel().getFpData().getFirstLineToDisplay()); //use setFirstLinetoDisplay method to update firstLine to display using units
                        //+  -
                        getView().updateTableArray(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders()); //update buttons(getLines(firstline,lastline);
                        //..... 
                    }
                });
    }

    private void highlighter() //this is the method that will listen to the mouse clicking header labels or WestPanel buttons which will then be highlighted
    {
        for(int i = 0; i <= 7; i++) //MouseListener for the headers (sortField)
        {
            getView().getIf().getIp().getCp().getHeaders().get(i).addMouseListener(
                new MouseListener() 
                {
                    
                    @Override
                    public void mouseClicked(MouseEvent a)
                    {
                        for(int j = 0; j <= 7; j++)
                        {
                            JLabel clicked = (JLabel) a.getSource();
                            getView().getIf().getIp().getCp().getHeaders().get(j).setBackground(Color.LIGHT_GRAY);
                            clicked.setBackground(Color.red);
                            //set sort field
                            int n = getModel().getFpData().getHeaders().indexOf(clicked.getText());
                            getModel().getFpData().SetSortField(n);
                            getModel().getFpData().setSearchByField(n);
                            System.out.println("Sort Field set to " + clicked.getText());
                            getModel().getFpData().sort(getModel().getFpData().getSortType(), getModel().getFpData().getSortField());
                            getView().updateTableArray(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders()); //update buttons(getLines(firstline,lastline);
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent a) 
                    {

                    }

                    @Override
                    public void mouseReleased(MouseEvent a) 
                    {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent a)
                    {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent a)
                    {
                        
                    }
                });
        }
        
        for (int k = 1; k <= 3; k++) //ActionListener for the sortType (from WestPanel)
        {
            getView().getIf().getIp().getWp().getSortTypeButtons().get(k).addActionListener(
                    new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    for (int j = 1; j <= 3; j++) {
                        JButton clicked2 = (JButton) ae.getSource();
                        getView().getIf().getIp().getWp().getSortTypeButtons().get(j).setBackground(Color.WHITE);
                        getView().getIf().getIp().getWp().getSortTypeButtons().get(j).setForeground(Color.BLACK);
                        clicked2.setBackground(Color.BLACK);
                        clicked2.setForeground(Color.WHITE);
                        
                        if(clicked2.getText() == "(1) Selection/Write Yourself")
                        {
                            getModel().getFpData().SetSortType(1);
                            System.out.println("Selection Sort Selected");
                        }
                        if(clicked2.getText() == "(2) Merge/ArrayList()")
                        {
                            getModel().getFpData().SetSortType(2);
                            System.out.println("Merge Sort Selected");
                        }
                        if(clicked2.getText() == "(3) Quick/Arrays[]")
                        {
                            getModel().getFpData().SetSortType(3);
                            System.out.println("Quick Sort Selected");
                        }
                    }
                }
            });
        }
    }
    
    
    private void searcherEnterKey() //KeyListener for the ENTER key that will search the database
    {
        getView().getIf().getIp().getNp().getSearchField().addKeyListener(
                new KeyListener() 
                {

            @Override
            public void keyTyped(KeyEvent ke) 
            {

            }

            @Override
            public void keyPressed(KeyEvent ke) 
            {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Enter key pressed");

                    String termFromSearchBar = getView().getIf().getIp().getNp().getSearchField().getText();
                    model.getFpData().search(termFromSearchBar);
                    if(model.getFpData().search(termFromSearchBar) == false)
                    {
                        getView().getIf().getIp().getNp().getSearchField().setOpaque(true);
                        getView().getIf().getIp().getNp().getSearchField().setBackground(Color.RED);
                    }
                    else
                    {
                        getView().getIf().getIp().getNp().getSearchField().setBackground(Color.WHITE);
                        getView().updateTableArray(getModel().getFpData().getLines(getModel().getFpData().getFirstLineToDisplay(), getModel().getFpData().getLastLineToDisplay()), getModel().getFpData().getHeaders());
                        getModel().getFpData().getFoundIndex().setBackground(Color.YELLOW);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) 
            {

            }
        });
    }


    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * @return the view
     */
    public View getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * @return the k
     */
    public int getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(int k) {
        this.k = k;
    }
}
