package co.com.home.misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.home.misiontic2022.model.vo.ComprasDeLiderVo;
import co.com.home.misiontic2022.util.JDBCUtilities;

public class ComprasDeLiderDao {

    public List<ComprasDeLiderVo> listarComprasDeLider() throws SQLException {

        var respuesta = new ArrayList<ComprasDeLiderVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        var query = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido LIDER,"
                + " SUM(mc.Precio_Unidad*c.Cantidad) VALOR FROM Proyecto p" + " JOIN Lider l ON p.ID_Lider = l.ID_Lider"
                + " JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto"
                + " JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion"
                + " GROUP BY 1 ORDER BY 2 LIMIT 10";
        try {
            stmt = conn.prepareStatement(query);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new ComprasDeLiderVo();
                vo.setLider(rset.getString(1));
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