/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author RIAJUL
 */
@Entity
@Table(name = "deliver_man", catalog = "BookStore", schema = "")
@NamedQueries({
    @NamedQuery(name = "DeliverMan.findAll", query = "SELECT d FROM DeliverMan d")
    , @NamedQuery(name = "DeliverMan.findById", query = "SELECT d FROM DeliverMan d WHERE d.deliverManPK.id = :id")
    , @NamedQuery(name = "DeliverMan.findByName", query = "SELECT d FROM DeliverMan d WHERE d.name = :name")
    , @NamedQuery(name = "DeliverMan.findByPassword", query = "SELECT d FROM DeliverMan d WHERE d.deliverManPK.password = :password")})
public class DeliverMan implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeliverManPK deliverManPK;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;

    public DeliverMan() {
    }

    public DeliverMan(DeliverManPK deliverManPK) {
        this.deliverManPK = deliverManPK;
    }

    public DeliverMan(DeliverManPK deliverManPK, String name) {
        this.deliverManPK = deliverManPK;
        this.name = name;
    }

    public DeliverMan(String id, String password) {
        this.deliverManPK = new DeliverManPK(id, password);
    }

    public DeliverManPK getDeliverManPK() {
        return deliverManPK;
    }

    public void setDeliverManPK(DeliverManPK deliverManPK) {
        this.deliverManPK = deliverManPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverManPK != null ? deliverManPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliverMan)) {
            return false;
        }
        DeliverMan other = (DeliverMan) object;
        if ((this.deliverManPK == null && other.deliverManPK != null) || (this.deliverManPK != null && !this.deliverManPK.equals(other.deliverManPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.DeliverMan[ deliverManPK=" + deliverManPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
