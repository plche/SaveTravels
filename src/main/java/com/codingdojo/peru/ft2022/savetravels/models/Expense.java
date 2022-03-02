package com.codingdojo.peru.ft2022.savetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull(message = "Name must not be blank")
	@Size(min = 1, message = "Name must not be blank")
    private String name;
	
	@NotNull(message = "Vendor must not be blank")
	@Size(min = 1, message = "Vendor must not be blank")
	private String vendor;
	
	@NotNull(message = "Amount must not be blank")
	@Positive(message = "Amount must be greater than 0")
	private Double amount;
	
	@NotNull(message = "Description must not be blank")
	@Size(min = 1, message = "Description must not be blank")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(value = GenerationTime.INSERT)
	@Column(name = "created", 
    updatable = false, insertable = false, nullable = false,
    columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Generated(value = GenerationTime.ALWAYS)
	@Column(name = "updated", updatable = false, insertable = false, nullable = false,
	columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date updated;

	public Expense(String name, String vendor, Double amount, String description) {
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}
	
	@PrePersist
    protected void onCreate() {
        this.created = new Date();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.updated = new Date();
    }
}
