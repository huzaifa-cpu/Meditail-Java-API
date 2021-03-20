package com.meditail.api.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "items_expiry")
public class ItemExpiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date date;
	private boolean isSoldOut;
	private String itemCount;

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
	@ManyToOne
	@JsonIgnoreProperties({ "createdDate", "updatedDate", "deletedDate", "createdBy", "updatedBy", "deletedBy" })
	@JoinColumn(name = "item_id")
	private Item item;

	public ItemExpiry() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isSoldOut() {
		return isSoldOut;
	}

	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
