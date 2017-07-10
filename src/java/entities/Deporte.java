/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gamalyon
 */
@Entity
@Table(name = "deporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deporte.findAll", query = "SELECT d FROM Deporte d")
    , @NamedQuery(name = "Deporte.findByIdDeporte", query = "SELECT d FROM Deporte d WHERE d.idDeporte = :idDeporte")
    , @NamedQuery(name = "Deporte.findByNombre", query = "SELECT d FROM Deporte d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Deporte.findByCupos", query = "SELECT d FROM Deporte d WHERE d.cupos = :cupos")
    , @NamedQuery(name = "Deporte.findByFechaIni", query = "SELECT d FROM Deporte d WHERE d.fechaIni = :fechaIni")
    , @NamedQuery(name = "Deporte.findByFechaFin", query = "SELECT d FROM Deporte d WHERE d.fechaFin = :fechaFin")
    , @NamedQuery(name = "Deporte.findByTotalClases", query = "SELECT d FROM Deporte d WHERE d.totalClases = :totalClases")})
public class Deporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deporte")
    private Integer idDeporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupos")
    private int cupos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_clases")
    private int totalClases;
    @OneToMany(mappedBy = "idDeporte")
    private List<Inscripcion> inscripcionList;

    public Deporte() {
    }

    public Deporte(Integer idDeporte) {
        this.idDeporte = idDeporte;
    }

    public Deporte(Integer idDeporte, String nombre, int cupos, Date fechaIni, Date fechaFin, int totalClases) {
        this.idDeporte = idDeporte;
        this.nombre = nombre;
        this.cupos = cupos;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.totalClases = totalClases;
    }

    public Integer getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(Integer idDeporte) {
        this.idDeporte = idDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalClases() {
        return totalClases;
    }

    public void setTotalClases(int totalClases) {
        this.totalClases = totalClases;
    }

    @XmlTransient
    public List<Inscripcion> getInscripcionList() {
        return inscripcionList;
    }

    public void setInscripcionList(List<Inscripcion> inscripcionList) {
        this.inscripcionList = inscripcionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDeporte != null ? idDeporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deporte)) {
            return false;
        }
        Deporte other = (Deporte) object;
        if ((this.idDeporte == null && other.idDeporte != null) || (this.idDeporte != null && !this.idDeporte.equals(other.idDeporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Deporte[ idDeporte=" + idDeporte + " ]";
    }
    
}
