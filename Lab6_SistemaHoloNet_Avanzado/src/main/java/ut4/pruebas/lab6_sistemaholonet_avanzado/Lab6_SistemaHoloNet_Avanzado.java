package ut4.pruebas.lab6_sistemaholonet_avanzado;

import java.util.List;

/**
 *
 * @author SamahEva
 */
public class Lab6_SistemaHoloNet_Avanzado {

    public static void main(String[] args) {
      HoloNetControl control = new HoloNetControl();

        // naves por bando o sector galáctico
    List<Nave> navesImperio =
            control.obtenerNavesPorBandoPlaneta("Imperio");

    for (Nave nave : navesImperio) {
        System.out.println("Nave: " + nave.getNombre());
        System.out.println("Estado: " + nave.getEstadoSistema());
        
    }


    //reporte de naves y planetas asignados
   
    List<Object[]> cazas =
            control.obtenerReportePlanetasAsignados("TI-v2");

    for (Object[] fila : cazas) {
        System.out.println("Nave: " + fila[0]);
        System.out.println("Planeta: " + fila[1]);
       
    }


    // flota crítica con los planetas cargados

    List<Nave> flotaCritica =
            control.obtenerFlotaCriticaConPlaneta("TI-v2");

    for (Nave nave : flotaCritica) {
        System.out.println("Nave: " + nave.getNombre());
        System.out.println("Estado: " + nave.getEstadoSistema());

        if (nave.getPlanetaOrigen() != null) {
            System.out.println("Planeta de origen: "
                    + nave.getPlanetaOrigen().getNombrePlaneta());
        } else {
            System.out.println("Planeta de origen: Sin asignar");
        }

       
    }


        HibernateUtil.shutdown();
    }
}
