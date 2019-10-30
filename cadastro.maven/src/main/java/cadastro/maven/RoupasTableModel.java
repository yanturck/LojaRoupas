package cadastro.maven;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class RoupasTableModel extends AbstractTableModel implements TableModelListener{
	private RoupasDAO dao;
	private List<Roupas> roupas;
	private List<String> colunas;
	
	public RoupasTableModel (RoupasDAO dao){
			//dao.openConnection();
		this.dao = dao;
		roupas = dao.recupera();
		colunas = Arrays.asList("Roupa", "Tamanho", "Preço");
		this.addTableModelListener(this);
			//dao.closeConnection();
		}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return roupas.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.size();
	}

	@Override
	public Object getValueAt(int r, int c) {
		// TODO Auto-generated method stub
		Roupas roupa = roupas.get(r);
		switch  (c) {
			case 0: return roupa.getTipo();
			case 1: return roupa.getTam();
			case 2: return roupa.getPreco();
		}
		return null;
	}
	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		return colunas.get(c);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return columnIndex != 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Roupas roupa = roupas.get(rowIndex);
		
	switch  (columnIndex) {
		case 0:  
			roupa.setTipo((String)aValue);
			break;
		case 1:  
			roupa.setTam((String)aValue);
			break;
		case 2: 
			roupa.setPreco((String)aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		
		fireTableCellUpdated(rowIndex, columnIndex);
	}



	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		int i = e.getFirstRow();
		Roupas roupa = roupas.get(i);
		//System.out.println(i);
		dao.atualiza(roupa);
	}
	/*public void addRoupa() {
		Roupas r = new Roupas();
		roupas.add(r);
		dao.adiciona(r);
		fireTableDataChanged();
	}*/
}
