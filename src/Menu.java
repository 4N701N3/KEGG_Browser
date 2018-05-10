import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//package kegg.gui;

public class Menu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final int OFFSET = 5;
	
	// Initialiser les composants du menu
	private Box menu_box;
	private Etiquette label_brow;
	private JLabel label_species;
	private JTextField text_species;
	private JLabel label_ID;
	private JTextField text_ID;
	private JButton menu_bouton_search;
	
	
	public Menu(String browser_name) {
        
        menu_box = Box.createHorizontalBox(); // left menu
        
        label_brow = new Etiquette(browser_name);
//        label_brow.setOpaque(true);
//        label_brow.setBackground(Color.CYAN);
        label_species = new JLabel("    Species  ");
        text_species = new JTextField(4);
        //~ lab_species.setLabelFor(text_species); // Inutile ?
        
        // Valeur par defaut si non reimplemente lors de l'instanciation
        label_ID = new JLabel("    ID "); 
        text_ID = new JTextField(5);
        //~ lab_ID.setLabelFor(text_ID); // Inutile ?
        
        menu_box.add(label_brow);
        menu_box.add(label_species);
        menu_box.add(text_species);
        menu_box.add(label_ID);
        menu_box.add(text_ID);
        
        menu_bouton_search = new JButton("Search");
        
        setLayout(new BorderLayout());
        add(menu_box, BorderLayout.WEST);
        add(menu_bouton_search, BorderLayout.EAST);
        setBorder(BorderFactory.createEmptyBorder(OFFSET,OFFSET,OFFSET,0)); // Marge du menu : top, left, bottom, right
        
    }
	
	/**
	 * @param nom de l'identifiant. Ex : "Gene ID".
	 */
	public void setLabelID(String nom) {
		String label_name = "       " + nom + "  ";
		label_ID.setText(label_name);
	}

}
