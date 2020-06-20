import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;
import com.sun.webkit.dom.EntityImpl;
import dominio.Lembrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {

        ConexaoHibernate conexaoHibernate = new ConexaoHibernate();


        Lembrete lembrete = new Lembrete();
        lembrete.setTitulo(" massa");
        lembrete.setDescricao("hoje ,11h30");

        CrudLembrete crudLembrete = new CrudLembrete();

        EntityManager em1 = conexaoHibernate.entityManager();
        crudLembrete.adicionar(lembrete,em1);

        EntityManager em2 = conexaoHibernate.entityManager();
        crudLembrete.listarTodosLembretes(em2);

        EntityManager em3 = conexaoHibernate.entityManager();
        crudLembrete.buscarporId(em3);

        EntityManager em4 = conexaoHibernate.entityManager();
        crudLembrete.buscarporTitulo(em4);

        EntityManager em5 = conexaoHibernate.entityManager();
        crudLembrete.atualizaLembrete(em5);

        EntityManager em6 = conexaoHibernate.entityManager();
        crudLembrete.deleteLembrete(em6);

    }
}
