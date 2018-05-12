import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//package kegg.gui;
/**
 * Browser constitue la moitie de l'app 
 */
public class Browser extends JPanel {

	private static final long serialVersionUID = 1L;
	
//	private static final double SCALE = 0.7;
	
	// Initialiser les composants
	private JEditorPane html_viewer;
	
    public Browser() {
    	
        html_viewer = new JEditorPane(); // Contenu html
        html_viewer.setEditable(false);  // Contenu non modifiable par l'utilisateur
//        html_viewer.addHyperlinkListener(new Hyperactive());
        
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
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.scale(SCALE, SCALE);
	}
}
