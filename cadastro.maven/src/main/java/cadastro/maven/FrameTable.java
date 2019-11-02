package cadastro.maven;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame {
	
	public FrameTable () {
		super("Roupas");
		//RoupasDAO dao = new RoupasDAO();
		//RoupasTableModel tm = new RoupasTableModel(dao);
		//JTable t = new JTable(tm);
		JTable t = new JTable(new GenericTableModel<Filme>(new FilmeDAO()));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(t);
		add(scroll);
		setSize(200,200);
		
		/*JPanel pan = new JPanel();
		JButton btNovo = new JButton("NOVO");
		pan.add(btNovo, BorderLayout.EAST);
		add(pan, BorderLayout.SOUTH);
		
		btNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				JFrame frame = new CadastroDeRoupas();
				frame.setSize(300,200); 
			    frame.setVisible(true); 
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});*/
	}
	public static void main(String[] args) {
		FrameTable f = new FrameTable();
		f.setVisible(true);
	}
}
