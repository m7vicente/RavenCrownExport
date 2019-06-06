package com.bianca.arquivos.repository;

import com.bianca.arquivos.entity.RecomendacoesEntity;
import com.bianca.arquivos.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecomendacoesRepository extends JpaRepository<RecomendacoesEntity, Integer> {

    @Query("from RecomendacoesEntity where id_usuario = ?1")
    List<RecomendacoesEntity> findRecomendacoesByUsuarioId(int id);

    @Query("from UsuarioEntity where id_usuario = ?1")
    UsuarioEntity GetUser(int id);


}
