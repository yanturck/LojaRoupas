package cadastro.maven;

import javax.swing.JFrame;

public class AppCadastro {
	public static void main(String[] args) {
		JFrame frame = new CadastroDeRoupas();
		frame.setSize(300,200); 
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  
		/*Roupas rp = new Roupas("Camisa", "M", "12.23");
		System.out.println(rp.toString());*/
}
}
