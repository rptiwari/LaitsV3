/**
 * LAITS Project Arizona State University
 */
package edu.asu.laits.gui.menus;

import edu.asu.laits.editor.GraphEditorPane;
import edu.asu.laits.editor.listeners.InsertModeChangeListener;
import edu.asu.laits.gui.nodeeditor.GraphValuesDialog;
import edu.asu.laits.gui.nodeeditor.NodeEditor;
import edu.asu.laits.model.Vertex;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import org.apache.log4j.Logger;
import org.jgraph.graph.DefaultGraphCell;

/**
 *
 * @author ramayantiwari
 */
public class VertexSelectionMenu extends JPopupMenu {

    GraphEditorPane graphPane;
    private JMenuItem deleteItem = null;
    private JMenuItem editItem = null;
    private JMenuItem graphDataItem = null;
    private static Logger logs = Logger.getLogger("DevLogs");
    private static Logger activityLogs = Logger.getLogger("ActivityLogs");
    /**
     * This method initializes
     *
     */
    public VertexSelectionMenu(GraphEditorPane graphPane) {
        super();
        this.graphPane = graphPane;
        initialize();
    }

    /**
     * This method initializes this
     *
     */
    private void initialize() {
        add(getEditItem());
        add(getDeleteItem());
        add(getGraphDataItem());
        
    }
    
    public void setGraphDataItem(){
        DefaultGraphCell gc = (DefaultGraphCell) graphPane.getSelectionCell();
        Vertex currentVertex = (Vertex) gc.getUserObject();
        
        if(!currentVertex.getGraphsStatus().equals(Vertex.GraphsStatus.UNDEFINED)){
            graphDataItem.setEnabled(true);
        }else{
            graphDataItem.setEnabled(false);
        }
    }

    /**
     * This method initializes deleteItem
     */
    private JMenuItem getDeleteItem() {
        if (deleteItem == null) {
            deleteItem = new JMenuItem();
            deleteItem.setText("Delete");
            deleteItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    graphPane.removeSelected();
                }
            });
        }
        return deleteItem;
    }

    /**
     * This method initializes deleteItem
     */
    private JMenuItem getEditItem() {
        if (editItem == null) {
            editItem = new JMenuItem();
            editItem.setText("Edit");
            editItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    new NodeEditor(graphPane);
                }
            });
        }
        return editItem;
    }
    
    /**
     * This method initializes deleteItem
     */
    private JMenuItem getGraphDataItem() {
        if (graphDataItem == null) {
            graphDataItem = new JMenuItem();
            graphDataItem.setText("Graph Values");
            graphDataItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    DefaultGraphCell gc = (DefaultGraphCell) graphPane.getSelectionCell();
                    Vertex currentVertex = (Vertex) gc.getUserObject();
                    new GraphValuesDialog(graphPane.getMainFrame(), true, currentVertex);
                }
            });
        }
        return graphDataItem;
    }
}