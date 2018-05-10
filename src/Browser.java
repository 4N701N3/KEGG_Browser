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
	private Menu menu;
	
	private JPanel browser; // quarter left
//	private JPanel info; // quarter right
	private JEditorPane html_viewer;
	
	private Information info;
	
    public Browser(String browser_name) {
    	
	    browser = new JPanel();
	    
//	    info = new JPanel();
	    info = new Information("test", "test");
//	    info.setPreferredSize(new Dimension(200, 100));
	    
	    menu = new Menu(browser_name); 
        html_viewer = new JEditorPane(); // Contenu html
        
//	    part_bl = new BorderLayout();
//	    part.setLayout(gene_part_bl);
	    setLayout(new BorderLayout());
	    add(browser, BorderLayout.CENTER);
	    add(info, BorderLayout.EAST);
	    
//	    gb_bl = new BorderLayout();
//	    genome_browser.setLayout(gb_bl);
	    browser.setLayout(new BorderLayout());
        browser.add(menu, BorderLayout.NORTH);
	    browser.add(new JScrollPane(html_viewer), BorderLayout.CENTER); 
	    
	    try {
			URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001");
			afficherContenu(html_viewer, url);
		} 
	    catch (MalformedURLException e) {
			e.printStackTrace();
		} 
	    catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void afficherContenu(JEditorPane html_viewer, URL url) throws IOException {
        html_viewer.setPage(url);
    }
    
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//	}
}
