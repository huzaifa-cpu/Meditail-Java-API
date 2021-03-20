package com.meditail.api.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String expiryDate;
	private String costPerItem;
	private String totalCount;

	private String status;
	private boolean state;

	private Date createdDate;
	private Date updatedDate;
	private Date deletedDate;

	@OneToOne
	@JoinColumn(name = "created_by_id")
	@JsonIgnoreProperties({ "meditailId", "name", "email", "password", "phoneNumber", "image", "status", "state",
			"createdDate", "updatedDate", "deletedDate", "role", "medicalStore" })
	private User createdBy;

	@OneToOne
	@JoinColumn(name = "updated_by_id")
	@JsonIgnoreProperties({ "meditailId", "name", "email", "password", "phoneNumber", "image", "status", "state",
			"createdDate", "updatedDate", "deletedDate", "role", "medicalStore" })
	private User updatedBy;

	@OneToOne
	@JoinColumn(name = "deleted_by_id")
	@JsonIgnoreProperties({ "meditailId", "name", "email", "password", "phoneNumber", "image", "status", "state",
			"createdDate", "updatedDate", "deletedDate", "role", "medicalStore" })
	private User deletedBy;

	// RELATIONS
	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "createdDate", "updatedDate", "deletedDate", "createdBy", "updatedBy", "deletedBy" })
	private List<ItemCategory> itemCategory = new ArrayList<ItemCategory>();

	@ManyToOne
	@JsonIgnoreProperties({ "createdDate", "updatedDate", "deletedDate", "createdBy", "updatedBy", "deletedBy" })
	@JoinColumn(name = "medical_store_id")
	private MedicalStore medicalStore;

	public Item() {
		super();
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

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCostPerItem() {
		return costPerItem;
	}

	public void setCostPerItem(String costPerItem) {
		this.costPerItem = costPerItem;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public User getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(User deletedBy) {
		this.deletedBy = deletedBy;
	}

	public List<ItemCategory> getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(List<ItemCategory> itemCategory) {
		this.itemCategory = itemCategory;
	}

	public MedicalStore getMedicalStore() {
		return medicalStore;
	}

	public void setMedicalStore(MedicalStore medicalStore) {
		this.medicalStore = medicalStore;
	}

}
