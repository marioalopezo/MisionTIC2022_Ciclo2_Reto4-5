package co.com.home.misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.home.misiontic2022.model.vo.PagadoPorProyectoVo;
import co.com.home.misiontic2022.util.JDBCUtilities;

public class PagadoPorProyectoDao {

    public List<PagadoPorProyectoVo> listarPagoPorProyecto(Double limiteInferior) throws SQLException {

        var respuesta = new ArrayList<PagadoPorProyectoVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        var query = "SELECT p.ID_Proyecto, SUM(mc.Precio_Unidad*c.Cantidad) VALOR"
                + " FROM Proyecto p JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto"
                + " JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion"
                + " WHERE c.Pagado = 'Si' GROUP by p.ID_Proyecto" + " HAVING VALOR > ? ORDER BY VALOR DESC";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setDouble(1, limiteInferior);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new PagadoPorProyectoVo();
                vo.setId(rset.getInt(1));
                vo.setValor(rset.getDouble(2));
                respuesta.add(vo);
            }

        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return respuesta;
    }
}