import java.io.IOException;

import javax.swing.JFrame;

import org.fit.cssbox.swingbox.BrowserPane;

public class Legend extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public Legend() {
		try {
			setTitle("Legend");
			setSize(580,650);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			BrowserPane bp = new BrowserPane();
			bp.setPage("http://www.kegg.jp/kegg/docs/ko_color.html");
			
			add(bp);
			
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
}
