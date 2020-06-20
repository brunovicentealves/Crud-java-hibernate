import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoHibernate {

    private static EntityManagerFactory entityManagerFactory;

    public   EntityManager entityManager (){

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernatejpa");

        return  entityManagerFactory.createEntityManager();
    }
}
