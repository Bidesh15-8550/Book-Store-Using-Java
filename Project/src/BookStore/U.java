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
@Table(name = "u", catalog = "BookStore", schema = "")
@NamedQueries({
    @NamedQuery(name = "U.findAll", query = "SELECT u FROM U u")
    , @NamedQuery(name = "U.findByName", query = "SELECT u FROM U u WHERE u.name = :name")
    , @NamedQuery(name = "U.findByEmail", query = "SELECT u FROM U u WHERE u.email = :email")
    , @NamedQuery(name = "U.findByPhone", query = "SELECT u FROM U u WHERE u.uPK.phone = :phone")
    , @NamedQuery(name = "U.findByPassword", query = "SELECT u FROM U u WHERE u.uPK.password = :password")
    , @NamedQuery(name = "U.findByConfirm", query = "SELECT u FROM U u WHERE u.confirm = :confirm")
    , @NamedQuery(name = "U.findByAddress", query = "SELECT u FROM U u WHERE u.address = :address")})
public class U implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UPK uPK;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Confirm")
    private String confirm;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;

    public U() {
    }

    public U(UPK uPK) {
        this.uPK = uPK;
    }

    public U(UPK uPK, String name, String email, String confirm, String address) {
        this.uPK = uPK;
        this.name = name;
        this.email = email;
        this.confirm = confirm;
        this.address = address;
    }

    public U(String phone, String password) {
        this.uPK = new UPK(phone, password);
    }

    public UPK getUPK() {
        return uPK;
    }

    public void setUPK(UPK uPK) {
        this.uPK = uPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        String oldConfirm = this.confirm;
        this.confirm = confirm;
        changeSupport.firePropertyChange("confirm", oldConfirm, confirm);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uPK != null ? uPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof U)) {
            return false;
        }
        U other = (U) object;
        if ((this.uPK == null && other.uPK != null) || (this.uPK != null && !this.uPK.equals(other.uPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.U[ uPK=" + uPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
