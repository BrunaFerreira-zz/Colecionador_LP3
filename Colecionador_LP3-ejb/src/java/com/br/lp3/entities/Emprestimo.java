/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "EMPRESTIMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e"),
    @NamedQuery(name = "Emprestimo.findByIdEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.idEmprestimo = :idEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByDataEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByIdAutor", query = "SELECT e FROM Emprestimo e WHERE e.idAutor = :idAutor")})
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EMPRESTIMO")
    private Long idEmprestimo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA_EMPRESTIMO")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;
    @Column(name = "ID_AUTOR")
    private BigInteger idAutor;
    @JoinColumn(name = "ID_OBRA", referencedColumnName = "ID_OBRA")
    @ManyToOne
    private Obra idObra;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_INFOUSUARIO")
    @ManyToOne
    private InfoUsuario idUsuario;

    public Emprestimo() {
    }

    public Emprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Emprestimo(Long idEmprestimo, Date dataEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public BigInteger getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(BigInteger idAutor) {
        this.idAutor = idAutor;
    }

    public Obra getIdObra() {
        return idObra;
    }

    public void setIdObra(Obra idObra) {
        this.idObra = idObra;
    }

    public InfoUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(InfoUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmprestimo != null ? idEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.idEmprestimo == null && other.idEmprestimo != null) || (this.idEmprestimo != null && !this.idEmprestimo.equals(other.idEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Emprestimo[ idEmprestimo=" + idEmprestimo + " ]";
    }
    
}
