import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//package kegg.gui;
/**
 * GenomeBrowser  
 */
public class GenomeBrowser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JEditorPane html_viewer;
	
	private String species; // nom de l'espece entree dans le champs species
	private String id;      // nom de l'identifiant entree dans le champs id
	
	private final int OFFSET = 5;
	
	// Initialiser les composants du menu
	private JPanel menu;
	private Box menu_box;
	private Etiquette label_brow;
	private JLabel label_species;
	private JTextField text_species;
	private JLabel label_ID;
	private JTextField text_ID;
	protected JButton menu_bouton_search;
	
		 // Composants zoom
//	private JButton zoom;
//	private JButton unzoom;
	
//	private static final double SCALE = 0.7;
	
    public GenomeBrowser(String browser_name, String label_ID_text) {
    	
    	// Menu
		menu = new JPanel();
        menu_box = Box.createHorizontalBox(); // left menu
        
        label_brow = new Etiquette(browser_name);
        label_species = new JLabel("    Species  ");
//        text_species = new JTextField(4);
        text_species = new JTextField("eco", 4); // TEST
        
        label_ID = new JLabel("     " + label_ID_text + "  "); 
//        text_ID = new JTextField(5);
        text_ID = new JTextField("b0002", 5);
        
        menu_box.add(label_brow);
        menu_box.add(label_species);
        menu_box.add(text_species);
        menu_box.add(label_ID);
        menu_box.add(text_ID);
//        menu_box.add(unzoom);
//        menu_box.add(zoom);
        
        menu_bouton_search = new JButton("Search");

        menu_bouton_search.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent clic) {
	        	if (text_species.getText() != "" && text_ID.getText() != "") {
	        		species = text_species.getText().trim();
	        		id = text_ID.getText().trim();
	        		System.out.println("Species: " + species + " ; ID: " + id); // TEST
	        		try {
						afficherContenu(species, id);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	    	}	
        }); 
        
        menu.setLayout(new BorderLayout());
        menu.add(menu_box, BorderLayout.WEST);
        menu.add(menu_bouton_search, BorderLayout.EAST);
        menu.setBorder(BorderFactory.createEmptyBorder(0,0,OFFSET,0)); // Marge du menu : top, left, bottom, right
    	// fin Menu
        
        
        html_viewer = new JEditorPane(); // Contenu html
        html_viewer.setEditable(false);  // Contenu non modifiable par l'utilisateur
//        html_viewer.addHyperlinkListener(new Hyperactive());
        
        // Ajout au browser
	    setLayout(new BorderLayout());
	    add(new JScrollPane(html_viewer), BorderLayout.CENTER);
	    add(menu, BorderLayout.NORTH);
	    
//	    try {
//	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + menu.getSpecies() + "&ACCESSION=" + menu.getID());// "&CHR=c&START_POS=660001");
////	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001");
//			afficherContenu(html_viewer, url);
//		} 
//	    catch (MalformedURLException e) {
//			e.printStackTrace();
//		} 
//	    catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
    }
    
    public void afficherContenu(/*URL url*/String species, String id) throws IOException {
    	try {
    		URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + species + "&ACCESSION=" + id);// "&CHR=c&START_POS=660001");
//	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + menu.getSpecies() + "&ACCESSION=" + menu.getID());// "&CHR=c&START_POS=660001");
//	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001");
//			afficherContenu(html_viewer, url); 
	    	html_viewer.setPage(url);
		} 
	    catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	    catch (IOException ioe) {
			ioe.printStackTrace();
		}
       
    }
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.scale(SCALE, SCALE);
	}
	
    
    public String getSpecies() {
    	return species;
    }
    
    public String getID() {
    	return id;
    }
    
    public void setSpecies(String species) {
    	 this.species = species;
    }
    
    public void setID(String id) {
    	 this.id = id;
    }
}
