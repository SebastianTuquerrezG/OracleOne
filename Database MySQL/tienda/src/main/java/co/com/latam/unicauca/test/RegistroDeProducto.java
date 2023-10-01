package co.com.latam.unicauca.test;

import co.com.latam.unicauca.modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class RegistroDeProducto {
    public static void main(String[] args) {
        Producto celular = new Producto();
        celular.setNombre("Celular");
        celular.setDescripcion("Celular de alta gama");
        celular.setPrecio(BigDecimal.valueOf(1000000L));
        celular.setStock(10L);
        celular.setId_categoria(1L);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("control_de_stock");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
