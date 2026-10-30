package ut4.pruebas.lab6_sistemaholonet_avanzado;

import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author SamahEva
 */
public class HoloNetControl {
    public List<Nave> obtenerNavesPorBandoPlaneta(String bando) {
    String hql = "FROM Nave n INNER JOIN n.planetaOrigen p "
               + "WHERE p.sectorGalactico = :Imperio "
               + "AND n.estadoSistema != 'Mantenimiento'";
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Query<Nave> query = session.createQuery(hql, Nave.class);
        query.setParameter("Imperio", bando);
        return query.getResultList();
    }
}
    
    public List<Nave> obtenerFlotaCriticaConPlaneta(String tIv2) {
    // FETCH JOIN fuerza la carga inmediata del objeto relacionado en memoria
    String hql = "FROM Nave n INNER JOIN FETCH n.planetaOrigen WHERE n.estadoSistema = 'Critico'";
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery(hql, Nave.class).getResultList();
    }
}
    
    
    public List<Object[]> obtenerReportePlanetasAsignados(String tIv2) {
    String hql = "SELECT n.nombre,"
            + " p.nombrePlaneta FROM Nave n LEFT JOIN n.planetaOrigen p";
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        return query.getResultList();
    } 
    }
    
    
}