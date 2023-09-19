package com.cenaflixjpa.cenaflixjpa.persistencia;

import jakarta.persistence.EntityManager;
import javax.swing.JOptionPane;

public class PodcastDAO {
    
 
    
    public static void cadastrar(Podcast podcast){
        EntityManager manager = JPAUtil.getEntityManager();
        try{
            manager.getTransaction().begin();
            manager.persist(podcast);
            manager.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao inserir registro!\n"+e.getMessage()+"\n"+podcast.getDuracao());
            System.out.println("Falha ao inserir registro!\n"+e.getMessage()+"\n"+podcast);
        } finally {
            manager.close();
        }
        
    }
    
    public static void excluir(int id){
        EntityManager manager = JPAUtil.getEntityManager();
        try{
        manager.getTransaction().begin();
        Podcast podcast = manager.find(Podcast.class, id);
        manager.remove(podcast);
        manager.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao excluir registro!\n"+e.getMessage());
        } finally {
            manager.close();
        }
    }
    
    public static void editar(Podcast podcastNovo, int id){
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            Podcast podcastVelho = manager.find(Podcast.class, id);
            manager.getTransaction().begin();
            podcastVelho.transpose(podcastNovo);
            manager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha ao editar registro!\n"+e.getMessage());
        } finally {
            manager.close();
        }
        
    }
}
