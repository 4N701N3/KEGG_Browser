import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// Initialisation des composants
	private JPanel gene_part; // top half
	private Browser genome_browser;
	private Information gene_info;
	
	private JPanel path_part; // bottom half
	private Browser pathway_browser;
	private Information react_info;
	
	// Initialisation des Layout 
//    private static BorderLayout gene_part_bl;
//    private static BorderLayout gb_bl;
    
    public Panneau() {
//    	GridLayout gl = new GridLayout(2,1);
//	    setLayout(gl);
		setLayout(new GridLayout(2,1));
	    
	    System.out.println("Test 1");
	    
	    // =======  Definition de la partie Genome browser (moitie haute) ==========
	    gene_part = new JPanel();
	    add(gene_part);
//	    gene_part_bl = new BorderLayout();
//	    gene_part.setLayout(gene_part_bl);
	    gene_part.setLayout(new BorderLayout());
	    
	    genome_browser = new Browser(" Genome browser ");
	    gene_part.add(genome_browser, BorderLayout.CENTER);

	    gene_info = new Information("Gene Information", "Involved in reaction(s)");
	    gene_part.add(gene_info, BorderLayout.EAST);
	    
	    System.out.println("Test 2");
	    
	    //====================== Pathway browser part (bottom half) ====================
	    path_part = new JPanel();
	    add(path_part);
	    
	    path_part.setLayout(new BorderLayout());
	    pathway_browser = new Browser(" Pathway browser ");
	    path_part.add(pathway_browser, BorderLayout.CENTER);
	    
	    react_info = new Information("Reaction Information", "Involves gene(s)");
	    path_part.add(react_info, BorderLayout.EAST);

	    System.out.println("Test 3");

	    //~ ImageIO.read(image);
        
        // Lire une image a partir d'un fichier
        // try {
        //     Image image = ImageIO.read(new File("CHEMIN _D'ACCES"));
        //     g.drawImage(image, 0, 0, this);
        // } 
        // catch (IOException e) {
        //     e.printStackTrace();
        // }
  
    }

}
