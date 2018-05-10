import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Information extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Initialiser les composants de la partie droite de l'application
//	private JPanel 
	private Etiquette info_label;
	private JEditorPane info_content;
//	private JScrollPane info_sp;
	
	private JLabel involved_label;
	private JList<String> involved_list;
//	private JScrollPane involved_sp; inutile pour l'instant
	
	public Information(String info_name, String involved_name) {
		
		setPreferredSize(new Dimension(200, 100));
		setLayout(new BorderLayout());
		// vertical Box or not ????
		
		info_label = new Etiquette(info_name);
		involved_label = new JLabel(involved_name);
		
		info_content = new JEditorPane();
		
		DefaultListModel<String> liste = new DefaultListModel<String>();
		liste.addElement("1");
		liste.addElement("2");
		liste.addElement("3");
		
		involved_list = new JList<String>(liste);
		
//		involved_list.addListSelectionListener(null);
//		involved_list.setPreferredSize(new Dimension ...);
		
		
		// Ajout des composants
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(info_label);
		add(new JScrollPane(info_content));
		add(involved_label);
		add(new JScrollPane(involved_list));
	}
	
	
}
