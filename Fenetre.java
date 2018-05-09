import javax.swing.JFrame;

import java.awt.Dimension;
import java.io.IOException;

/** 
 *  Classe qui permet l'afficahge graphique du logiciel.
 * 
 */
public class Fenetre extends JFrame {
	private static final long serialVersionUID = 1L;
	
    private Panneau main_container = new Panneau();
    
    
	public Fenetre() throws IOException {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // affiche la fenetre au milieu de l'ecran
        setTitle("KEGG Browser");    // nom de la fenetre
        setSize(900, 450);           // taille de la fenetre
        setMinimumSize(new Dimension(640, 480));     // taille minimun de la fenetre
        setResizable(true);          // redimension de la fenetre
        
        add(main_container);
        
        //======================= Affiche la GeneMap en html =====================*/
        //create the component 
        //~ BrowserPane swingbox = new BrowserPane(); 
        // add the component to your GUI  
        //~ Container myContainer = getContentPane();
        //~ myContainer.add(new JScrollPane(swingbox)); 
        // display the page 
        //~ swingbox.setPage(new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001"));
        
    }
    
	/**
	 * @param args
	 */
    public static void main(String[] arg) throws IOException {
        Fenetre browser = new Fenetre();
        browser.setVisible(true);            /* affiche la fenetre */
        
    }

    
}
