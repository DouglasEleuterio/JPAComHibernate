/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.douglas.jpa2.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author douglas
 */
public class EntityManagerUtil {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModeloHibernate");
    
    public static EntityManager em(){
        return emf.createEntityManager();
    }
}
