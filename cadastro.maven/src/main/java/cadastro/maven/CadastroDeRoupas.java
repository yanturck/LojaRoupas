package cadastro.maven;

import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroDeRoupas extends JFrame {
	public JTextField txtTipo;  
    public JTextField txtTamanho; 
    public JTextField txtPreco;
    public JButton btnCadastrar, btnLimpar, btnSair; 
 
     
 
    public CadastroDeRoupas() {
    	super("Cadastre suas Roupas");
        initInterface();
        initEvents();
    }
 
     
 
    private void initInterface() { 
        setLayout(new FlowLayout());
        
        JPanel pnTipo = new JPanel();
        add(pnTipo);
        
        JPanel pnTamanho = new JPanel();
        add(pnTamanho);
        
        JPanel pnPreco = new JPanel();
        add(pnPreco);
        
        JPanel pnButtons = new JPanel();
        add(pnButtons);
        
        
        pnTipo.add(new JLabel("Roupa: "));
        txtTipo = new JTextField(15);
        pnTipo.add(txtTipo);
        
        pnTamanho.add(new JLabel("Tamanho: "));
        txtTamanho = new JTextField(15);
        pnTamanho.add(txtTamanho);
        
        pnPreco.add(new JLabel("Preco: "));
        txtPreco = new JTextField(15);
        pnPreco.add(txtPreco);
        
        
        btnCadastrar = new JButton("Cadastrar");
        pnButtons.add(btnCadastrar);
        
        btnLimpar = new JButton("Limpar");
        pnButtons.add(btnLimpar);
        
        btnSair = new JButton("SAIR");
        pnButtons.add(btnSair); 
    } 
    
    private void initEvents() {
        btnSair.addActionListener( (ev) -> System.exit(0));
        btnLimpar.addActionListener((ev) -> {
            txtTipo.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");
        });
        
        btnCadastrar.addActionListener( (ev) -> {
            Roupas roupas = new Roupas(txtTipo.getText(),txtTamanho.getText(),txtPreco.getText());
            RoupasDAO dao = new RoupasDAO();
            dao.adiciona(roupas);
        });
    }  
}
