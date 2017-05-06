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
@Table(name = "books", catalog = "library_managment", schema = "")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b"),
    @NamedQuery(name = "Books.findById", query = "SELECT b FROM Books b WHERE b.id = :id"),
    @NamedQuery(name = "Books.findByCallno", query = "SELECT b FROM Books b WHERE b.callno = :callno"),
    @NamedQuery(name = "Books.findByName", query = "SELECT b FROM Books b WHERE b.name = :name"),
    @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author"),
    @NamedQuery(name = "Books.findByPublisher", query = "SELECT b FROM Books b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "Books.findByQuantity", query = "SELECT b FROM Books b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Books.findByIssued", query = "SELECT b FROM Books b WHERE b.issued = :issued"),
    @NamedQuery(name = "Books.findByAddedDate", query = "SELECT b FROM Books b WHERE b.addedDate = :addedDate")})
public class Books implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "callno")
    private String callno;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @Column(name = "publisher")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "issued")
    private int issued;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public Books() {
    }

    public Books(Integer id) {
        this.id = id;
    }

    public Books(Integer id, String callno, String name, String author, String publisher, int quantity, int issued, Date addedDate) {
        this.id = id;
        this.callno = callno;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.issued = issued;
        this.addedDate = addedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCallno() {
        return callno;
    }

    public void setCallno(String callno) {
        String oldCallno = this.callno;
        this.callno = callno;
        changeSupport.firePropertyChange("callno", oldCallno, callno);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        String oldPublisher = this.publisher;
        this.publisher = publisher;
        changeSupport.firePropertyChange("publisher", oldPublisher, publisher);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        changeSupport.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        int oldIssued = this.issued;
        this.issued = issued;
        changeSupport.firePropertyChange("issued", oldIssued, issued);
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        Date oldAddedDate = this.addedDate;
        this.addedDate = addedDate;
        changeSupport.firePropertyChange("addedDate", oldAddedDate, addedDate);
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
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library.management.Books[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
