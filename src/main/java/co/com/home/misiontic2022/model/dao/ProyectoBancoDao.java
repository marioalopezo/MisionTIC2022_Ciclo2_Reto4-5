package co.com.home.misiontic2022.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.home.misiontic2022.model.vo.ProyectoBancoVo;
import co.com.home.misiontic2022.util.JDBCUtilities;

public class ProyectoBancoDao {

    public List<ProyectoBancoVo> listarProyectoPorBanco(String banco) throws SQLException {

        var respuesta = new ArrayList<ProyectoBancoVo>();

        var conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;

        var query = "SELECT p.ID_Proyecto ID, p.Constructora, p.Ciudad, p.Clasificacion,"
                + " t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido LIDER"
                + " FROM Proyecto p" + " JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo"
                + " JOIN Lider l ON p.ID_Lider = l.ID_Lider" + " WHERE p.Banco_Vinculado = ?"
                + " ORDER BY p.Fecha_Inicio DESC, p.Ciudad, p.Constructora";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, banco);
            rset = stmt.executeQuery();

            while (rset.next()) {
                var vo = new ProyectoBancoVo();
                vo.setId(rset.getInt(1));
                vo.setConstructora(rset.getString(2));
                vo.setCiudad(rset.getString(3));
                vo.setClasificacion(rset.getString(4));
                vo.setEstrato(rset.getInt(5));
                vo.setLider(rset.getString(6));

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