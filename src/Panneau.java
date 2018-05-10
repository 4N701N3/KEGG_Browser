import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// Marge entre les composants
//	private final int OFFSET = 5;
	
	// Initialisation des composants
	private JPanel gene_part; // top half
	private Browser genome_browser;
//	private JPanel gene_info; // quarter top right
	
	private JPanel path_part; // bottom half
	private Browser pathway_browser;
	
	// Initialisation des Layout 
//    private static BorderLayout gene_part_bl;
//    private static BorderLayout gb_bl;
    
    public Panneau() {
//    	GridLayout gl = new GridLayout(2,1);
//	    setLayout(gl);
		setLayout(new GridLayout(2,1));
	    
	    System.out.println("Test 1");
	    
	    // ============  Definition de la moitie haute de l'appli ==============
	    gene_part = new JPanel();
	    add(gene_part);
	    
//	    gene_part_bl = new BorderLayout();
//	    gene_part.setLayout(gene_part_bl);
	    gene_part.setLayout(new BorderLayout());
	    
	    genome_browser = new Browser(" Genome browser ");
	    gene_part.add(genome_browser, BorderLayout.CENTER);
	    
//	    gb_bl = new BorderLayout();
//	    genome_browser.setLayout(gb_bl);
//	    genome_browser.setLayout(new BorderLayout());
	    
	    System.out.println("Test 2");
	    
	    // AJOUT TEST
	    path_part = new JPanel();
	    add(path_part);
	    
	    path_part.setLayout(new BorderLayout());
	    pathway_browser = new Browser(" Pathway browser ");
	    path_part.add(pathway_browser, BorderLayout.CENTER);
	    
	    // FIN AJOUT TEST

	    System.out.println("Test 3");
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
        
        // Lire une image a partir d'un fichier
        // try {
        //     Image image = ImageIO.read(new File("CHEMIN _D'ACCES"));
        //     g.drawImage(image, 0, 0, this);
        // } 
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        
	    
	    // definition du layout a utiliser dans le contentPane        
	    //~ this.setLayout(new BorderLayout()); 
	    
	    //~ this.getContentPane().add(b_search, BorderLayout.NORTH);
	    
	    
	    //~ pan.setBackground(Color.GREY);
	    //~ this.setContentPane(pan);
    }
    
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//	}
}
