package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try { // 정상적으로 수행이 되면 커밋한다.
            Member member = new Member();
            member.setId( 1L );
            member.setName( "HelloA" );
            tx.commit();

        } catch (Exception e) { //예외가 발생하였을 땐 롤백한다.
            tx.rollback();
        } finally { //정상적으로 수행이되면 엔티티 매니저가 종료된다.
            em.close();
        } //엔티티매니저팩토리가 종료된다.
        emf.close();




    }
}
