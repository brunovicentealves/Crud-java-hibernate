import dominio.Lembrete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CrudLembrete {

    public  void  adicionar( Lembrete lembrete, EntityManager em){

        try {

            em.getTransaction().begin();
            em.persist(lembrete);
            em.getTransaction().commit();

        }catch (Exception e){

            em.getTransaction().rollback();
            System.out.println("insert "+e.getMessage());

        }finally {

            em.close();

        }
    }


    public void listarTodosLembretes(EntityManager em){


        List<Lembrete> lembreteslist = null;


        try {
            lembreteslist = em.createQuery("from Lembrete").getResultList();
        }catch (Exception e ){
            System.out.println("List AL"+e.getMessage());

        }finally {
            em.close();
        }

        if(lembreteslist != null){
            lembreteslist.forEach(System.out::println);
        }

    }


    public void  buscarporId(EntityManager em){

        Lembrete lembrete1 = null;


        try {
            lembrete1 = em.find(Lembrete.class,1L);
            System.out.println(lembrete1);

        }catch (Exception e ){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }

    public void buscarporTitulo(EntityManager em){

        List<Lembrete> lembreteList = null;

        try {
            lembreteList = em.createQuery("from Lembrete l where l.titulo LIKE'%comprar%'").getResultList();

        }catch (Exception e ){
            System.out.println("LIST ALL: "+e.getMessage());
        }finally {
            em.close();
        }

        if(lembreteList != null){
            lembreteList.forEach(System.out::println);
        }
    }

    public void atualizaLembrete (EntityManager em){

        try {
            Lembrete lembrete2 = em.find(Lembrete.class,1l);
            lembrete2.setTitulo("comprar feijao ");

            em.getTransaction().begin();
            em.merge(lembrete2);
            em.getTransaction().commit();

        }catch (Exception e ){
            System.out.println("UPDATE :" +e.getMessage());
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }


    public void deleteLembrete(EntityManager em){

        try {
            Lembrete lembrete3 =em.find(Lembrete.class,4L);
            em.getTransaction().begin();
            em.remove(lembrete3);
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("DELETE :"+e.getMessage());
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
