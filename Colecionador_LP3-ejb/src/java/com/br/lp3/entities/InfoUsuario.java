/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "INFOUSUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infousuario.findAll", query = "SELECT i FROM Infousuario i"),
    @NamedQuery(name = "Infousuario.findByIdInfousuario", query = "SELECT i FROM Infousuario i WHERE i.idInfousuario = :idInfousuario"),
    @NamedQuery(name = "Infousuario.findByNomeCompleto", query = "SELECT i FROM Infousuario i WHERE i.nomeCompleto = :nomeCompleto"),
    @NamedQuery(name = "Infousuario.findByAcessoUsuario", query = "SELECT i FROM Infousuario i WHERE i.acessoUsuario = :acessoUsuario"),
    @NamedQuery(name = "Infousuario.findBySenha", query = "SELECT i FROM Infousuario i WHERE i.senha = :senha")})
public class InfoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INFOUSUARIO")
    private Long idInfousuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ACESSO_USUARIO")
    private String acessoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SENHA")
    private String senha;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Emprestimo> emprestimoCollection;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne
    private Usuario idUsuario;

    public InfoUsuario() {
    }

    public InfoUsuario(Long idInfousuario) {
        this.idInfousuario = idInfousuario;
    }

    public InfoUsuario(Long idInfousuario, String nomeCompleto, String acessoUsuario, String senha) {
        this.idInfousuario = idInfousuario;
        this.nomeCompleto = nomeCompleto;
        this.acessoUsuario = acessoUsuario;
        this.senha = senha;
    }

    public Long getIdInfousuario() {
        return idInfousuario;
    }

    public void setIdInfousuario(Long idInfousuario) {
        this.idInfousuario = idInfousuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getAcessoUsuario() {
        return acessoUsuario;
    }

    public void setAcessoUsuario(String acessoUsuario) {
        this.acessoUsuario = acessoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(Collection<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfousuario != null ? idInfousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoUsuario)) {
            return false;
        }
        InfoUsuario other = (InfoUsuario) object;
        if ((this.idInfousuario == null && other.idInfousuario != null) || (this.idInfousuario != null && !this.idInfousuario.equals(other.idInfousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Infousuario[ idInfousuario=" + idInfousuario + " ]";
    }
    
}
