package net.beotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PACKAGE")
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=Service.class)
	@JoinColumn(name = "SERVICE_ID")
	private Service service;

	@Column(name="STATUS")
	private int status;

	@ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=Price.class)
	@JoinColumn(name = "PRICE_ID")
	private Price price;
	
	@Column(name="DURATION_MONTHS")
	private String durationMonths;
	
	/* private int serviceId; */
	
	public Package () {
		
	}

	public Package(String name, Service service, int status, Price price, String durationMonths) {
		super();
		this.name = name;
		this.service = service;
		this.status = status;
		this.price = price;
		this.durationMonths = durationMonths;
	}
	
	/*
	 * public Package(String name, int serviceId, int techParamId, String status,
	 * int priceId, String durationMonths) { super(); this.name = name;
	 * this.serviceId = serviceId; this.techParamId = techParamId; this.status =
	 * status; this.priceId = priceId; this.durationMonths = durationMonths; }
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(String durationMonths) {
		this.durationMonths = durationMonths;
	}

	/*
	 * public int getServiceId() { return serviceId; }
	 * 
	 * public void setServiceId(int serviceId) { this.serviceId = serviceId; }
	 */
	
	

}
