import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//package kegg.gui;
/**
 * Browser constitue la moitie de l'app 
 */
public class Browser extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Initialiser les composants
	private JEditorPane html_viewer;
	
    public Browser() {
    	
        html_viewer = new JEditorPane(); // Contenu html
        html_viewer.setEditable(false);  // Contenu non modifiable par l'utilisateur
        
	    setLayout(new BorderLayout());
	    add(new JScrollPane(html_viewer), BorderLayout.CENTER);
	    
	    try {
//	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=" + menu.getSpecies() + "&ACCESSION=" + menu.getID());// "&CHR=c&START_POS=660001");
	    	URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001");
			afficherContenu(html_viewer, url);
		} 
	    catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	    catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }
    
    public void afficherContenu(JEditorPane html_viewer, URL url) throws IOException {
        html_viewer.setPage(url);
    }
    
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//	}
}
