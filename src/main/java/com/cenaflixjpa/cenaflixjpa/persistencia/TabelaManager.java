package com.cenaflixjpa.cenaflixjpa.persistencia;

import static com.cenaflixjpa.cenaflixjpa.GUI.TelaListaPodcast.TabPodcast;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaManager {
        
        
        public static int getRowCount() {
            EntityManager manager = JPAUtil.getEntityManager();  
            
            Query query = manager.createQuery("SELECT COUNT(p) FROM Podcast p");
            
            Long count = (Long) query.getSingleResult();
            
            return count != null ? count.intValue() : 0;
        
    }
        
        public static void popularTabela(JTable tabela) {
        EntityManager manager = JPAUtil.getEntityManager();

        try {
            // Consulta todos os registros da tabela "podcast"
            TypedQuery<Podcast> query = manager.createQuery("SELECT p FROM Podcast p", Podcast.class);
            List<Podcast> podcasts = query.getResultList();

            // Limpa a tabela
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);

            // Preenche a tabela com os resultados da consulta
            for (Podcast podcast : podcasts) {
                Object[] rowData = {
                    podcast.getId(),
                    podcast.getProdutor(),
                    podcast.getNome(),
                    podcast.getNumero(),
                    podcast.getDuracao(),
                    podcast.getUrl()
                };
                model.addRow(rowData);
            }
        } finally {
            manager.close();
        }
    }
        
        public static void buscar(JTable tabela, String termoPesquisa) {
    EntityManager manager = JPAUtil.getEntityManager();

    try {
        // Construir a consulta JPA com base no termo de pesquisa
        String consulta = "SELECT p FROM Podcast p WHERE p.produtor LIKE :termo";
        TypedQuery<Podcast> query = manager.createQuery(consulta, Podcast.class);
        query.setParameter("termo", "%" + termoPesquisa + "%"); // Use LIKE com % para pesquisa parcial
        List<Podcast> podcasts = query.getResultList();

        // Limpar a tabela
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        model.setRowCount(0);

        // Preencher a tabela com os resultados da consulta
        for (Podcast podcast : podcasts) {
            Object[] rowData = {
                podcast.getId(),
                podcast.getProdutor(),
                podcast.getNome(),
                podcast.getNumero(),
                podcast.getDuracao(),
                podcast.getUrl()
            };
            model.addRow(rowData);
        }
    } finally {
        manager.close();
    }
}
}
