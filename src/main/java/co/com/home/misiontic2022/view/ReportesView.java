package co.com.home.misiontic2022.view;

import java.sql.SQLException;

import co.com.home.misiontic2022.controller.ReportesController;

public class ReportesView {

    private ReportesController reportesController;

    public ReportesView() {
        reportesController = new ReportesController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO " + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD",
                    "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            try {
                var respuesta = reportesController.listadoDeProyectoPorBanco(banco);
                for (var r : respuesta) {
                    System.out.println(String.format("%3d %-25s %-20s %-15s %7d %-30s", r.getId(), r.getConstructora(),
                            r.getCiudad(), r.getClasificacion(), r.getEstrato(), r.getLider()));
                }

            } catch (SQLException ex) {
                System.out.println("Ocurrio un error " + ex.getMessage());
            }
        }
    }

    public void totalPagadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL PAGADO POR PROYECTO " + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR  "));
            System.out.println(repitaCaracter('-', 29));

            try {
                var respuesta = reportesController.listadoDePagoPorProyecto(limiteInferior);
                for (var r : respuesta) {
                    System.out.println(String.format("%3d %,15.1f", r.getId(), r.getValor()));
                }

            } catch (SQLException ex) {
                System.out.println("Ocurrio un error " + ex.getMessage());
            }
        }
    }

    public void lideresQueMenosGastan() {
        System.out.println(repitaCaracter('=', 5) + " 10 LIDERES MENOS COMPRADORES " + repitaCaracter('=', 6));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR  "));
        System.out.println(repitaCaracter('-', 41));

        try {
            var respuesta = reportesController.listadoDeComprasDeLider();
            for (var r : respuesta) {
                System.out.println(String.format("%-25s %,15.1f", r.getLider(), r.getValor()));
            }

        } catch (SQLException ex) {
            System.out.println("Ocurrio un error " + ex.getMessage());
        }
    }
}