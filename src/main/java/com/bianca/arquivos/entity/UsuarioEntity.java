package com.bianca.arquivos.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="TBD_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", unique = true, nullable = false)
    private int Id_Usuario;

    private String Nome_Usuario;

    @Column(unique=true)
    private String Email_Usuario;

    @Column(unique=true)
    private String CPF_CNPJ;

    private String RG;

    private String Telefone_usuario;

    private String Senha;

    private boolean Prestador;

    private char Sexo;

    private String Estado_Civil;

    private Date Data_Nascimento;

    @OneToMany(mappedBy = "usuarioEntity")
    private List<RecomendacoesEntity> recomendacoesEntityList;


    public UsuarioEntity() {
    }

    public UsuarioEntity(String email_Usuario, String Senha) {
        this.setEmail_Usuario(email_Usuario);
        this.setSenha(Senha);
    }

    public UsuarioEntity(int id_Usuario) {
        this.setId_Usuario(id_Usuario);
    }


    public Date getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(Date data_Nascimento) {
        Data_Nascimento = data_Nascimento;
    }

    public int getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getNome_Usuario() {
        return Nome_Usuario;
    }

    public void setNome_Usuario(String nome_Usuario) {
        Nome_Usuario = nome_Usuario;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getTelefone_usuario() {
        return Telefone_usuario;
    }

    public void setTelefone_usuario(String telefone_usuario) {
        Telefone_usuario = telefone_usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public boolean isPrestador() {
        return Prestador;
    }

    public void setPrestador(boolean prestador) {
        Prestador = prestador;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char sexo) {
        Sexo = sexo;
    }

    public String getEstado_Civil() {
        return Estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        Estado_Civil = estado_Civil;
    }

    public String getEmail_Usuario() {
        return Email_Usuario;
    }

    public void setEmail_Usuario(String email_Usuario) {
        Email_Usuario = email_Usuario;
    }
}
