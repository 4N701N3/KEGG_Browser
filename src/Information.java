import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Information extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final int OFFSET = 5;
	
	// Initialiser les composants de la partie droite de l'application
		// les deux conteneurs principaux de Information
	private JPanel info_panel;
	private Box box;
	
	private Etiquette info_label;
	private JEditorPane info_content;
	
	private JLabel involved_label;
	private JList<String> involved_list;
	
	public Information(String info_name, String involved_name) {
		setBorder(BorderFactory.createEmptyBorder(0,OFFSET,0,0)); // top, left, bottom, right
		setMinimumSize(new Dimension(200, 200));
		
		info_label = new Etiquette(info_name);
		involved_label = new JLabel(involved_name);
		involved_label.setAlignmentX(LEFT_ALIGNMENT);
		
		info_content = new JEditorPane();
		info_content.setEditable(false);
		info_content.setPreferredSize(new Dimension(180, 50));
		
		DefaultListModel<String> liste = new DefaultListModel<String>();
		liste.addElement("1");
		liste.addElement("2");
		liste.addElement("3");
		
		involved_list = new JList<String>(liste);
		involved_list.setPreferredSize(new Dimension(180, 50));
//		involved_list.addListSelectionListener(null);
//		involved_list.setPreferredSize(new Dimension ...);
		
		
		// Ajout des composants
		info_panel = new JPanel();
		info_panel.setLayout(new BorderLayout());
		info_panel.setBorder(BorderFactory.createEmptyBorder(0,0,OFFSET,0)); // top, left, bottom, right
		info_panel.add(info_label, BorderLayout.WEST);
		
		setLayout(new BorderLayout());
		add(info_panel, BorderLayout.NORTH);
		
		box = Box.createVerticalBox();
		box.add(new JScrollPane(info_content));
		box.add(involved_label);
		box.add(new JScrollPane(involved_list));
		
		add(box, BorderLayout.CENTER);
	}
	
	
}
