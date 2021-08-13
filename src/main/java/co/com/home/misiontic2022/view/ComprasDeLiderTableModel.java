package co.com.home.misiontic2022.view;

import co.com.home.misiontic2022.model.vo.ComprasDeLiderVo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ComprasDeLiderTableModel extends AbstractTableModel {

    private List<ComprasDeLiderVo> listaComprasDeLider;

    public ComprasDeLiderTableModel(List<ComprasDeLiderVo> listaComprasDeLider) {
        this.listaComprasDeLider = listaComprasDeLider;
    }

    @Override
    public int getRowCount() {
        return listaComprasDeLider.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "Líder";
            case 1:
                return "Valor";
        }

        return super.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Double.class;
        }

        return super.getColumnClass(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var compraDeLider = listaComprasDeLider.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return compraDeLider.getLider();
            case 1:
                return compraDeLider.getValor();
        }

        return null;
    }

}
