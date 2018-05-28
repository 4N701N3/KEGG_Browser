/**
 * BrowserGenome.java
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.fit.cssbox.swingbox.BrowserPane;

import kegg.recuperation.Fichiers;

//package kegg.gui;
/**
 * GenomeBrowser  
 */
public class BrowserGenome extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static BrowserPane html_viewer;
	
	private static String species; // nom de l'espece entree dans le champs species
	private static String gene_id; // nom de l'identifiant entree dans le champs id
	
	private final int OFFSET = 5;
	
	// Initialiser les composants du menu
	private JPanel menu;
	private Box menu_box;
	private Etiquette label_brow;
	private JLabel label_species;
	private static JTextField text_species;
	private JLabel label_ID;
	private static JTextField text_ID;
	private static JButton menu_bouton_search;
	
		 // Composants zoom
//	private JButton zoom;
//	private JButton unzoom;
//	private static final double SCALE = 0.7;
	
    public BrowserGenome(String browser_name, String label_ID_text) {
    	
        html_viewer = new BrowserPane();
//      html_viewer = new JEditorPane(); // Contenu html
//      html_viewer.setEditable(false);  // Contenu non modifiable par l'utilisateur
    	
    	// Menu
		menu = new JPanel();
        menu_box = Box.createHorizontalBox(); // left menu
        
        label_brow = new Etiquette(browser_name);
        label_species = new JLabel("    Species  ");
//        text_species = new JTextField(4);
        text_species = new JTextField("eco", 4); // TEST
        
        label_ID = new JLabel("     " + label_ID_text + "  "); 
//        text_ID = new JTextField(5);
        text_ID = new JTextField("b0630", 5); // TEST
        text_ID.setFocusable(true);
        text_ID.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent enter) {
				if (enter.getKeyCode() == KeyEvent.VK_ENTER) {
					
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
        });

        
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
	        		gene_id = text_ID.getText().trim();
	        		Pattern sp = Pattern.compile("\\b[a-z]{3,4}\\b");
	        		Pattern gid = Pattern.compile("\\b[a-z]\\d{4}\\b");
	        		Matcher match_sp = sp.matcher(species);
	        		Matcher match_gid = gid.matcher(gene_id);
	        		if (match_sp.find() && match_gid.find()) {
	        			label_species.setForeground(Color.GREEN);
	        			label_ID.setForeground(Color.GREEN);
//	        			System.out.println("Species: " + species + " ; ID: " + gene_id); // TEST
		        		try {
//							afficherContenu(species, gene_id);
							html_viewer.setPage(new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + species + "&ACCESSION=" + gene_id));
							InfoGenome.setInfo(Fichiers.getGenomeFiles(species, gene_id));
							// Recupere la liste des voies metaboliques impliquees
							Fichiers.getPathwayList(species, gene_id);
							InfoGenome.setList(Fichiers.involvedInReactionsList(species, gene_id));
						} catch (IOException ioe) {
							System.err.println("IOException: " + ioe.getMessage());
						}
	        		} else if (match_sp.find()) {
	        			label_species.setForeground(Color.GREEN);
	        			label_ID.setForeground(Color.RED);
	        			JOptionPane.showMessageDialog(new JFrame(),
	        		        "Gene ID should start with a lowercase letter "
	        		        + "followed by 4 numbers. For example: b0002.",
	        				"Warning",
	        				JOptionPane.WARNING_MESSAGE);
	        		} else if (match_gid.find()) {
	        			label_species.setForeground(Color.RED);
	        			label_ID.setForeground(Color.GREEN);
	        			JOptionPane.showMessageDialog(new JFrame(),
		        		        "Gene ID should start with a lowercase letter "
		        		        + "followed by 4 numbers. For example: b0002.",
		        				"Warning",
		        				JOptionPane.WARNING_MESSAGE);
	        		} else {
	        			label_species.setForeground(Color.RED);
	        			label_ID.setForeground(Color.RED);
	        			JOptionPane.showMessageDialog(new JFrame(),
		        		        "Gene ID should start with a lowercase letter "
		        		        + "followed by 4 numbers. For example: b0002.",
		        				"Warning",
		        				JOptionPane.WARNING_MESSAGE);
	        		}
	        		
	        	}
	    	}	
        }); 
        
        menu.setLayout(new BorderLayout());
        menu.add(menu_box, BorderLayout.WEST);
        menu.add(menu_bouton_search, BorderLayout.EAST);
        menu.setBorder(BorderFactory.createEmptyBorder(0,0,OFFSET,0)); // Marge du menu : top, left, bottom, right
    	// fin Menu
        
        
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
    
//	public void afficherContenu(String species, String id) {
//		File html_path;
//		try {
//			html_path = Fichiers.getHtml(species, id);
//			html_viewer.loadStyleSheet(new URL("http://www.kegg.jp/css/kegg2.css"), "/css/kegg2.css", "utf-8");
//			html_viewer.setPage(html_path.toURI().toURL());
//		} catch (IOException ioe) {
//			System.err.println("IOException afficherContenu: " + ioe.getMessage());
//		}
//    public void afficherContenu(String species, String id) throws IOException {
//    	try {
////    		URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + species + "&ACCESSION=" + id);// "&CHR=c&START_POS=660001");
////	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + menu.getSpecies() + "&ACCESSION=" + menu.getID());// "&CHR=c&START_POS=660001");
//	    	html_viewer.setPage(new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + species + "&ACCESSION=" + id));
//		} 
//	    catch (MalformedURLException e) {
//	    	System.err.println("MalformedURLException afficherContenu: " + e.getMessage());
//		} 
//	    catch (IOException ioe) {
//	    	System.err.println("IOException afficherContenu: " + ioe.getMessage());
//		}
//       
//    }
    
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
////		Graphics2D g2d = (Graphics2D) g;
////		g2d.scale(SCALE, SCALE);
//	}
	
    /**
     * @return species
     */
    public String getSpecies() {
    	return species;
    }
    /**
     * @return gene_id
     */
    public static String getID() {
    	return gene_id;
    }
    /**
     * Set the species value.
     * @param sp
     */
    public static void setSpecies(String sp) {
    	 species = sp;
    }
    /**
     * Set the gene_id value.
     * @param id
     */
    public static void setID(String id) {
    	 gene_id = id;
    }
    /**
     * Set the Species text field.
     * @param species
     */
    public static void setSpeciesText(String species) {
    	setSpecies(species);
    	text_species.setText(species);
    }
    /**
     * Set the Map_ID text field.
     * @param id
     */
    public static void setIdText(String id) {
   	 	setID(id);
   	 	text_ID.setText(id);
    }
    /**
     * Set the species and map_id text fields values.
     * @param species
     * @param id
     */
    public static void setText(String species, String id) {
    	setSpeciesText(species);
    	setIdText(id);
    }
    
    /**
     * Simule un clic sur le bouton search.
     */
    public static void clickSearch() {
    	menu_bouton_search.doClick();
    }
}
