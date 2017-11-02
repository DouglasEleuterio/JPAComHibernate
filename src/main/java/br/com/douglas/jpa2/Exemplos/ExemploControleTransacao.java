/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class ExemploControleTransacao {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.em();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();

            Pessoa pessoa = new Pessoa("Douglas");
            
 
            em.persist(pessoa);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

}
