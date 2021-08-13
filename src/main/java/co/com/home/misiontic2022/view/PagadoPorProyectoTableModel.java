package co.com.home.misiontic2022.view;

import co.com.home.misiontic2022.model.vo.PagadoPorProyectoVo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PagadoPorProyectoTableModel extends AbstractTableModel {

    private List<PagadoPorProyectoVo> listaPagadoPorProyecto;

    public PagadoPorProyectoTableModel(List<PagadoPorProyectoVo> listaPagadoPorProyecto) {
        this.listaPagadoPorProyecto = listaPagadoPorProyecto;
    }

    @Override
    public int getRowCount() {
        return listaPagadoPorProyecto.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID_Proyecto";
            case 1:
                return "Valor";
        }

        return super.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
        }

        return super.getColumnClass(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var pagadoPorProyecto = listaPagadoPorProyecto.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pagadoPorProyecto.getId();
            case 1:
                return pagadoPorProyecto.getValor();
        }

        return null;
    }

}
