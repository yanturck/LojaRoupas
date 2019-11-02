package cadastro.maven;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GenericTableModel<T> extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private AbstractDAO<T> dao ;
	private List<T> values ;
	
	public GenericTableModel (AbstractDAO<T> dao) {
		this.dao = dao;
		values = dao.recupera();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
        T obj = values.get(0);
        Class  c = obj.getClass();
        int count = 0;
        for (Field f: c.getDeclaredFields() ) {
            if (f.isAnnotationPresent(ColunaAnnotation.class)  ) {
            	count++;
            }
        }
        return count;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		T obj = values.get(row);
		Class  c = obj.getClass();
		Field fields[] = c.getDeclaredFields();
		int colCurr = 0;
		for (Field f: fields) {
			
			
			if (f.isAnnotationPresent(ColunaAnnotation.class )) {
				ColunaAnnotation annotation = f.getDeclaredAnnotation(ColunaAnnotation.class);
				if (annotation.pos() == col) {
					String fieldName = f.getName();
					String methodName = "get"+
							fieldName.substring(0, 1).toUpperCase()
		                    + fieldName.substring(1);
					Method m;
					try {
						m = c.getMethod(methodName);
						Object value = m.invoke(obj);
						return value;
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						// TODO Auto-generated catch block
					}
				}
			}
			
		}
		
		return null;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		 Object obj = values.get(0);
	        Class  c = obj.getClass();
	        for (Field f: c.getDeclaredFields() ) {
	            if (f.isAnnotationPresent(ColunaAnnotation.class)  ) {
	            	ColunaAnnotation a = f.getDeclaredAnnotation(ColunaAnnotation.class);
	                if (a.pos() == column) {
	                    return a.name();
	                }
	            }
	        }
	        return null;
	}
}
