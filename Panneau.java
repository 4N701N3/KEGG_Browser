import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//import org.fit.cssbox.swingbox.BrowserPane;

public class Panneau extends JPanel {
	
	private static final long serialVersionUID = 1L;
	// Marge entre les composants
	private final int OFFSET = 5;
	
	// Initialisation des composants
	private JPanel gene_part; // top half
	private JPanel genome_browser; // quarter top left
	private JPanel gene_info; // quarter top right
		// Composants du menu 
	private JPanel genome_browser_menu;
	private Box genome_browser_menu_box;
	private JLabel lab_gen_brow;
	private JLabel lab_species;
	private JTextField text_species;
	private JLabel lab_geneID;
	private JTextField text_geneID;
	private JButton genome_browser_menu_b_search;
	
	// Initialisation des Layout 
//    private static BorderLayout gene_part_bl;
//    private static BorderLayout gb_bl;
    
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//	    GridLayout gl = new GridLayout(2,1);
//	    setLayout(gl);
		setLayout(new GridLayout(2,1));
	    
	    System.out.println("Test 1");
	    // ============  Definition de la moitie haute de l'appli ==============
	    
	    gene_part = new JPanel();
	    add(gene_part);
	    
//	    gene_part_bl = new BorderLayout();
//	    gene_part.setLayout(gene_part_bl);
	    gene_part.setLayout(new BorderLayout());
	    
	    genome_browser = new JPanel();
	    
	    gene_info = new JPanel();
	    gene_info.setPreferredSize(new Dimension(200, 100));
	    
	    gene_part.add(genome_browser, BorderLayout.CENTER);
	    gene_part.add(gene_info, BorderLayout.EAST);
	    
//	    gb_bl = new BorderLayout();
//	    genome_browser.setLayout(gb_bl);
	    genome_browser.setLayout(new BorderLayout());
	    
	    System.out.println("Test 2");
	    
	    // Genome browser menu
	    genome_browser_menu = new JPanel();
	    genome_browser_menu_box = Box.createHorizontalBox(); // menu gb gauche
	    
	    lab_gen_brow = new JLabel("Genome browser");
	    lab_gen_brow.setOpaque(true);
	    lab_gen_brow.setBackground(Color.CYAN);
	    
	    lab_species = new JLabel("    Species  ");
	    text_species = new JTextField(4);
	    
	    lab_geneID = new JLabel("    Gene ID  ");
	    text_geneID = new JTextField(5);
	    
	    
	    genome_browser_menu_box.add(lab_gen_brow);
	    genome_browser_menu_box.add(lab_species);
	    genome_browser_menu_box.add(text_species);
	    genome_browser_menu_box.add(lab_geneID);
	    genome_browser_menu_box.add(text_geneID);
	    
	    genome_browser_menu.setLayout(new BorderLayout());
	    
	    genome_browser_menu_b_search = new JButton("Search");
	    
	    genome_browser_menu.add(genome_browser_menu_box, BorderLayout.WEST);
	    genome_browser_menu.add(genome_browser_menu_b_search, BorderLayout.EAST);
	    genome_browser_menu.setBorder(BorderFactory.createEmptyBorder(OFFSET, OFFSET, OFFSET,0)); // Marge du menu : top, left, bottom, right
	    
	    genome_browser.add(genome_browser_menu, BorderLayout.NORTH);
	    
	    System.out.println("Test 3");
	    
/*	    //create the component 
	    BrowserPane swingbox = new BrowserPane(); 
	    genome_browser.add(new JScrollPane(swingbox), BorderLayout.CENTER); 
	    // display the page 
        try {
			swingbox.setPage(new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        //version alternative au BrowserPane avec swing
        JEditorPane html_viewer = new JEditorPane(); 
	    genome_browser.add(new JScrollPane(html_viewer), BorderLayout.CENTER); 
	    // display the page 
        try {
        	html_viewer.setPage(new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        System.out.println("Test 4");
	    /*
	    //====================== Pathway browser part ====================
	    JPanel path_part = new JPanel();
	    //~ path_part.setBackground(Color.yellow);
	    add(path_part);
	    
	    BorderLayout path_part_bl = new BorderLayout();
	    path_part.setLayout(path_part_bl);
	    JPanel menu_path = new JPanel();
	    path_part.add(menu_path, BorderLayout.NORTH);
	    
	    menu_path.add(new JLabel("Pathway browser"), BorderLayout.WEST);
	    
	    JPanel reaction_info = new JPanel();
	    reaction_info.setPreferredSize(new Dimension(200, 100));
	    path_part.add(reaction_info, BorderLayout.EAST);
	    */
	    //~ ImageIO.read(image);

	    
	    // definition du layout a utiliser dans le contentPane        
	    //~ this.setLayout(new BorderLayout()); 
	    
	    //~ this.getContentPane().add(b_search, BorderLayout.NORTH);
	    
	    
	    //~ pan.setBackground(Color.GREY);
	    //~ this.setContentPane(pan);	
	}
}
