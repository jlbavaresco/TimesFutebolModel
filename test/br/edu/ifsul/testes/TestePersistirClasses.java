package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Posicao;
import br.edu.ifsul.modelo.Time;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirClasses {
    
    public TestePersistirClasses() {
    }
    
    @Test
    public void teste(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TimesFutebolModelPU");
        EntityManager em = emf.createEntityManager();
        
        Posicao p = new Posicao();
        p.setNome("Zagueiro");
        Cidade c = new Cidade();
        c.setNome("Porto Alegre");
        Time time = new Time();
        time.setCidade(c);
        time.setAnoFundacao(1903);
        time.setNome("Grêmio FBPA");
        Jogador j = new Jogador();
        j.setPosicao(p);
        j.setNome("Geromel");
        time.adicionarJogador(j);
        em.getTransaction().begin();
        em.persist(p);
        em.persist(c);
        em.persist(time);
        em.getTransaction().commit();
        
    }
    
}
