package Controller;

import Model.Model;
import View.View;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Controller
{
    private Model model;
    private View view;
    
    
    private int k = 0;
    
    public Controller(Model m, View v)
    {
        model = m;
        view = v;
        
        
        view.setupLayout(model.getFpData().getHeaders().size(), model.getFpData().linesBeingDisplayed);
        view.setupHeaders(model.getFpData().getHeaders().size());
        view.updateHeaders(model.getFpData().getHeaders());
        view.setupTableArray(model.getFpData().linesBeingDisplayed, model.getFpData().getHeaders().size());
        view.updateTableArray(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders());
        
//        view.getIf().ip.cp.addMouseWheelListener(
//        new MouseWheelListener()
//        {
//            @Override
//            public void mouseWheelMoved(MouseWheelEvent e) 
//            {
//                int units = mwe.getUnitesToScroll();
//                System.out.println("units=" + units);
//                //+  -
//                //use setFirstLinetoDisplay method to update
//                //firstLine to display using units
//                //update buttons(getLines(firstline,lastline);
//                //center update
//                
//                
//            }
//        });
    }
    
    private void addScrolling()
    {
        view.getIf().getIp().getCp().addMouseWheelListener(
                new MouseWheelListener()
                {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent e)
                    {
                        int units = e.getUnitsToScroll();
                        System.out.println("Units= " + units);
                        //code to make the table scroll
                        //......
                    }
                }
        );
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