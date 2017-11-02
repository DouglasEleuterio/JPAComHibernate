/**
 * Exemplo do uso do Metodo Merge.
 *  Utilizando o Merge, você consegue fazer alterações nos dados que jé estão como "detached", onde o PersistenceContext já está "Morto"
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
public class ExemploMerge {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Douglas");
        
        EntityManager em1 = EntityManagerUtil.em();
        EntityTransaction tx1 = em1.getTransaction();
        
        //Metodo de persistenci Iniciado, inserção do objeto através do PersistenceContex e posteriormente fechado o EntityManager e matando o PersistenceContext.
        tx1.begin();
        em1.persist(pessoa);
        tx1.commit();
        em1.close();
        
        //Alteração do Nome após o arquivo ser salvo no banco, já com a extinção do PersistenceContex. 
        pessoa.setNome("Dougas Eleutério");
        
        EntityManager em2 = EntityManagerUtil.em();
        EntityTransaction tx2 =  em2.getTransaction();
        tx2.begin();
        
        System.out.println("Antes merge");
        em2.merge(pessoa);
        System.out.println("Depois merge");
        System.out.println("Antes Commit");
        tx2.commit();
        System.out.println("Depois Commit");
        em2.close();
    }
    
}
