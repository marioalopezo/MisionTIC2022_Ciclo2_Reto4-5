package co.com.home.misiontic2022.view;

import co.com.home.misiontic2022.model.vo.ProyectoBancoVo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProyectoBancoTableModel extends AbstractTableModel {

    private List<ProyectoBancoVo> listaProyectoPorBanco;

    public ProyectoBancoTableModel(List<ProyectoBancoVo> listaProyectoPorBanco) {
        this.listaProyectoPorBanco = listaProyectoPorBanco;
    }

    @Override
    public int getRowCount() {
        return listaProyectoPorBanco.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Constructora";
            case 2:
                return "Ciudad";
            case 3:
                return "Clasificación";
            case 4:
                return "Estrato";
            case 5:
                return "Líder";
        }

        return super.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
        }

        return super.getColumnClass(columnIndex); // To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var proyecto = listaProyectoPorBanco.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return proyecto.getId();
            case 1:
                return proyecto.getConstructora();
            case 2:
                return proyecto.getCiudad();
            case 3:
                return proyecto.getClasificacion();
            case 4:
                return proyecto.getEstrato();
            case 5:
                return proyecto.getLider();
        }

        return null;
    }

}
