/* 
 * Esta classe tem por Objetivo criar uma Instancia de EntityManagerFactory
 * Atribuir essa instancia em uma váriavel Estatica, a modo de garantir que seja criada apenas uma EntityManager.
 */
package br.com.douglas.jpa2.Utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author douglas
 */
public class JPAUtil {
    
    //O Nome do EntityManagerFactory deve ter o mesmo no do Persistence Uniti definido no Persistece.xml
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModeloHibernate");
    
}
