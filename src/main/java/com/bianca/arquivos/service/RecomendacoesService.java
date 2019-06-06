package com.bianca.arquivos.service;

import com.bianca.arquivos.entity.RecomendacoesEntity;
import com.bianca.arquivos.entity.UsuarioEntity;
import com.bianca.arquivos.repository.RecomendacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecomendacoesService {

    @Autowired
    private RecomendacoesRepository recomendacoesRepository;

    public List<RecomendacoesEntity> listaRecomendacoes(int userId) {
        System.out.println("\nAQUI\n");
        List<RecomendacoesEntity> lista2 = recomendacoesRepository.findRecomendacoesByUsuarioId(userId);
        List<RecomendacoesEntity> lista = new ArrayList<>();

        for (RecomendacoesEntity re : lista2) {
            lista.add(new RecomendacoesEntity(re.getNome_funcao(), re.getQuanto_tempo(),re.getDescricao(),re.getNome_recomendacao(), re.getTelefone()));
        }

        return lista;
    }
}