/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author gulshaneng
 */
@Entity
@Table(name = "issuebooks", catalog = "library_managment", schema = "")
@NamedQueries({
    @NamedQuery(name = "Issuebooks.findAll", query = "SELECT i FROM Issuebooks i"),
    @NamedQuery(name = "Issuebooks.findById", query = "SELECT i FROM Issuebooks i WHERE i.id = :id"),
    @NamedQuery(name = "Issuebooks.findByBookcallno", query = "SELECT i FROM Issuebooks i WHERE i.bookcallno = :bookcallno"),
    @NamedQuery(name = "Issuebooks.findByStudentid", query = "SELECT i FROM Issuebooks i WHERE i.studentid = :studentid"),
    @NamedQuery(name = "Issuebooks.findByStudentname", query = "SELECT i FROM Issuebooks i WHERE i.studentname = :studentname"),
    @NamedQuery(name = "Issuebooks.findByStudentcontact", query = "SELECT i FROM Issuebooks i WHERE i.studentcontact = :studentcontact"),
    @NamedQuery(name = "Issuebooks.findByIssueddate", query = "SELECT i FROM Issuebooks i WHERE i.issueddate = :issueddate")})
public class Issuebooks implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bookcallno")
    private String bookcallno;
    @Basic(optional = false)
    @Column(name = "studentid")
    private int studentid;
    @Basic(optional = false)
    @Column(name = "studentname")
    private String studentname;
    @Basic(optional = false)
    @Column(name = "studentcontact")
    private String studentcontact;
    @Basic(optional = false)
    @Column(name = "issueddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueddate;

    public Issuebooks() {
    }

    public Issuebooks(Integer id) {
        this.id = id;
    }

    public Issuebooks(Integer id, String bookcallno, int studentid, String studentname, String studentcontact, Date issueddate) {
        this.id = id;
        this.bookcallno = bookcallno;
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentcontact = studentcontact;
        this.issueddate = issueddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getBookcallno() {
        return bookcallno;
    }

    public void setBookcallno(String bookcallno) {
        String oldBookcallno = this.bookcallno;
        this.bookcallno = bookcallno;
        changeSupport.firePropertyChange("bookcallno", oldBookcallno, bookcallno);
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        int oldStudentid = this.studentid;
        this.studentid = studentid;
        changeSupport.firePropertyChange("studentid", oldStudentid, studentid);
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        String oldStudentname = this.studentname;
        this.studentname = studentname;
        changeSupport.firePropertyChange("studentname", oldStudentname, studentname);
    }

    public String getStudentcontact() {
        return studentcontact;
    }

    public void setStudentcontact(String studentcontact) {
        String oldStudentcontact = this.studentcontact;
        this.studentcontact = studentcontact;
        changeSupport.firePropertyChange("studentcontact", oldStudentcontact, studentcontact);
    }

    public Date getIssueddate() {
        return issueddate;
    }

    public void setIssueddate(Date issueddate) {
        Date oldIssueddate = this.issueddate;
        this.issueddate = issueddate;
        changeSupport.firePropertyChange("issueddate", oldIssueddate, issueddate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Issuebooks)) {
            return false;
        }
        Issuebooks other = (Issuebooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library.management.Issuebooks[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
