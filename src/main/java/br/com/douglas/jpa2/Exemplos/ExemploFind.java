/** Exemplo de utilização do Find, o conceito é o mesmo para os demais metodos de recuperação de Objetos do banco.
 * 
 */
package br.com.douglas.jpa2.Exemplos;

import br.com.douglas.jpa2.Utils.EntityManagerUtil;
import br.com.douglas.jpa2.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author douglas
 */
public class ExemploFind {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Douglas");
        
        EntityManager em1 = EntityManagerUtil.em();
        EntityTransaction tx1 = em1.getTransaction();
        
        tx1.begin();
        em1.persist(pessoa);
        tx1.commit();
        em1.close();
        
        EntityManager em2 = EntityManagerUtil.em();
        EntityTransaction tx2 = em2.getTransaction();
        
        tx2.begin();
        
        Pessoa pessoaPersistida = em2.find(Pessoa.class, pessoa.getId());
        System.out.println("Buscando pelo Id ");
        System.out.println(pessoaPersistida.toString());
        pessoaPersistida.setNome("Douglas Eleutério");
        
        System.out.println("Antes commit");
        tx2.commit();
        System.out.println("Depois Commit");
        em2.close();
    }
  
}
