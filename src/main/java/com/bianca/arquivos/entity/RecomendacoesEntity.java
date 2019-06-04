package com.bianca.arquivos.entity;

import javax.persistence.*;

@Entity
@Table(name="TBD_RECOMENDACAO")
public class RecomendacoesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECOMENDACAO", unique = true, nullable = false)
    private int Id_Recomendacao;
    private String Nome_funcao;
    private String Quanto_tempo;
    private String Descricao;
    private String Nome_recomendacao;
    private String Telefone;

    @JoinColumn(referencedColumnName = "ID_USUARIO",name = "ID_USUARIO")
    @ManyToOne(cascade = CascadeType.DETACH)
    UsuarioEntity usuarioEntity;

  public RecomendacoesEntity(String nome_funcao, String quanto_tempo, String descricao, String nome_recomendacao, String telefone, UsuarioEntity usuarioEntity) {
    Nome_funcao = nome_funcao;
    Quanto_tempo = quanto_tempo;
    Descricao = descricao;
    Nome_recomendacao = nome_recomendacao;
    Telefone = telefone;
    this.usuarioEntity = usuarioEntity;
  }

  public RecomendacoesEntity(int id_recomendacao, String nome_funcao, String quanto_tempo, String descricao, String nome_recomendacao, String telefone, UsuarioEntity usuarioEntity) {
    Id_Recomendacao = id_recomendacao;
    Nome_funcao = nome_funcao;
    Quanto_tempo = quanto_tempo;
    Descricao = descricao;
    Nome_recomendacao = nome_recomendacao;
    Telefone = telefone;
    this.usuarioEntity = usuarioEntity;
  }

  public int getId_Recomendacao() {
    return Id_Recomendacao;
  }

  public void setId_Recomendacao(int id_Recomendacao) {
    Id_Recomendacao = id_Recomendacao;
  }

  public String getNome_funcao() {
    return Nome_funcao;
  }

  public void setNome_funcao(String nome_funcao) {
    Nome_funcao = nome_funcao;
  }

  public String getQuanto_tempo() {
    return Quanto_tempo;
  }

  public void setQuanto_tempo(String quanto_tempo) {
    Quanto_tempo = quanto_tempo;
  }

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String descricao) {
    Descricao = descricao;
  }

  public String getNome_recomendacao() {
    return Nome_recomendacao;
  }

  public void setNome_recomendacao(String nome_recomendacao) {
    Nome_recomendacao = nome_recomendacao;
  }

  public String getTelefone() {
    return Telefone;
  }

  public void setTelefone(String telefone) {
    Telefone = telefone;
  }

  public UsuarioEntity getUsuarioEntity() {
    return usuarioEntity;
  }

  public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
    this.usuarioEntity = usuarioEntity;
  }
}
