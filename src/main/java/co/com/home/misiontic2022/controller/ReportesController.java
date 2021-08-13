package co.com.home.misiontic2022.controller;

import java.sql.SQLException;
import java.util.List;

import co.com.home.misiontic2022.model.dao.ComprasDeLiderDao;
import co.com.home.misiontic2022.model.dao.PagadoPorProyectoDao;
import co.com.home.misiontic2022.model.dao.ProyectoBancoDao;
import co.com.home.misiontic2022.model.vo.ComprasDeLiderVo;
import co.com.home.misiontic2022.model.vo.PagadoPorProyectoVo;
import co.com.home.misiontic2022.model.vo.ProyectoBancoVo;

public class ReportesController {

    private ComprasDeLiderDao comprasDeLiderDao;
    private PagadoPorProyectoDao pagadoPorProyectoDao;
    private ProyectoBancoDao proyectoBancoDao;

    public ReportesController() {
        comprasDeLiderDao = new ComprasDeLiderDao();
        pagadoPorProyectoDao = new PagadoPorProyectoDao();
        proyectoBancoDao = new ProyectoBancoDao();
    }

    public List<ComprasDeLiderVo> listadoDeComprasDeLider() throws SQLException {
        return comprasDeLiderDao.listarComprasDeLider();
    }

    public List<PagadoPorProyectoVo> listadoDePagoPorProyecto(Double limiteInferior) throws SQLException {
        return pagadoPorProyectoDao.listarPagoPorProyecto(limiteInferior);
    }

    public List<ProyectoBancoVo> listadoDeProyectoPorBanco(String banco) throws SQLException {
        return proyectoBancoDao.listarProyectoPorBanco(banco);
    }
}