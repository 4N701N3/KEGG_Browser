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
	
	private Menu menu;
	
	private JPanel browser; // quarter left
	private JPanel info; // quarter right
	
    public Browser(String browser_name) {
//	    gene_part_bl = new BorderLayout();
//	    gene_part.setLayout(gene_part_bl);
	    setLayout(new BorderLayout());
	    
	    browser = new JPanel();
	    
	    info = new JPanel();
	    info.setPreferredSize(new Dimension(200, 100));
	    
	    add(browser, BorderLayout.CENTER);
	    add(info, BorderLayout.EAST);
	    
//	    gb_bl = new BorderLayout();
//	    genome_browser.setLayout(gb_bl);
	    browser.setLayout(new BorderLayout());
    	
        menu = new Menu(browser_name);
        
        browser.add(menu, BorderLayout.NORTH);
        
        // Contenu html 
        JEditorPane html_viewer = new JEditorPane(); 
	    browser.add(new JScrollPane(html_viewer), BorderLayout.CENTER); 
	    try {
			URL url = new URL("http://www.kegg.jp/kegg-bin/show_genomemap?ORG=eco&CHR=c&START_POS=660001");
			afficherContenu(html_viewer, url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    public void afficherContenu(JEditorPane html_viewer, URL url) {
        try {
        	html_viewer.setPage(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
