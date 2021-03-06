package org.pwte.example.domain;

import com.ibm.cardinal.util.KluInterface;

import javax.persistence.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;

//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonProperty;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

@Entity
@NamedNativeQuery(name="product.by.cat.or.sub",
		query="select distinct p.product_id,p.name,p.price,p.description,p.image from product as p,prod_cat as pc, category as c where (c.CAT_ID = ? or c.PARENT_CAT = ?) AND pc.CAT_ID = c.cat_id AND pc.PRODUCT_ID = p.PRODUCT_ID",
		resultClass=Product.class)


public class Product implements KluInterface, Serializable {
    //Cardinal generated attributes
    @Transient
    private String klu__referenceID = "";

    //Cardinal generated method
    public String getKlu__referenceID() {
        return klu__referenceID;
    }

    //Cardinal generated method
    public void setKlu__referenceID(String refID) {
        klu__referenceID = refID;
    }




	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="PRODUCT_ID")
	
	protected int productId;
	protected String name;
	protected BigDecimal price;
	protected String description;
	@Column(name="IMAGE")
	
	protected String imagePath;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="PROD_CAT",joinColumns={@JoinColumn(name="PRODUCT_ID")},inverseJoinColumns={@JoinColumn(name="CAT_ID")})
	
	protected Collection<Category> categories;
	
	public Product() {

	}
	
	@JsonbTransient
	public Collection<Category> getCategories() {
		return categories;
	}
	
	@JsonbTransient
	public void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}
	
	@JsonbProperty(value="id")
	public int getProductId() {
		return productId;
	}
	
	@JsonbProperty(value="id")
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonbProperty(value="image")
	public String getImagePath() {
		return imagePath;
	}
	
	@JsonbProperty(value="image")
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

}

