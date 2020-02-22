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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author RIAJUL
 */
@Entity
@Table(name = "order_info", catalog = "BookStore", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrderInfo.findAll", query = "SELECT o FROM OrderInfo o")
    , @NamedQuery(name = "OrderInfo.findByBookID", query = "SELECT o FROM OrderInfo o WHERE o.bookID = :bookID")
    , @NamedQuery(name = "OrderInfo.findByBookType", query = "SELECT o FROM OrderInfo o WHERE o.bookType = :bookType")
    , @NamedQuery(name = "OrderInfo.findByPrice", query = "SELECT o FROM OrderInfo o WHERE o.price = :price")
    , @NamedQuery(name = "OrderInfo.findByDeliveryfee", query = "SELECT o FROM OrderInfo o WHERE o.deliveryfee = :deliveryfee")})
public class OrderInfo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Book_ID")
    private String bookID;
    @Basic(optional = false)
    @Column(name = "Book_Type")
    private String bookType;
    @Basic(optional = false)
    @Column(name = "Price")
    private String price;
    @Basic(optional = false)
    @Column(name = "Delivery_fee")
    private String deliveryfee;

    public OrderInfo() {
    }

    public OrderInfo(String bookID) {
        this.bookID = bookID;
    }

    public OrderInfo(String bookID, String bookType, String price, String deliveryfee) {
        this.bookID = bookID;
        this.bookType = bookType;
        this.price = price;
        this.deliveryfee = deliveryfee;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        String oldBookID = this.bookID;
        this.bookID = bookID;
        changeSupport.firePropertyChange("bookID", oldBookID, bookID);
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        String oldBookType = this.bookType;
        this.bookType = bookType;
        changeSupport.firePropertyChange("bookType", oldBookType, bookType);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        String oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getDeliveryfee() {
        return deliveryfee;
    }

    public void setDeliveryfee(String deliveryfee) {
        String oldDeliveryfee = this.deliveryfee;
        this.deliveryfee = deliveryfee;
        changeSupport.firePropertyChange("deliveryfee", oldDeliveryfee, deliveryfee);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookID != null ? bookID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderInfo)) {
            return false;
        }
        OrderInfo other = (OrderInfo) object;
        if ((this.bookID == null && other.bookID != null) || (this.bookID != null && !this.bookID.equals(other.bookID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookStore.OrderInfo[ bookID=" + bookID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
