package com.vehiclecfg.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invId;

    private Date invDate;

//  @ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="model_id",nullable=false)
//	private Model_Master model_master;

    @Column(nullable = false)
    private Long modelId;

//  @OneToMany(fetch=FetchType.LAZY)
//	@JoinColumn(name="Id",nullable=false)
//	private User_Id user_id;
    @Column(nullable = false)
    private Long user_id;

    private Double totalAmt;      // Vehicle amount
    private Double componentAmt;  // Component amount
    private Double tax;
    private Double netAmt;

    private String paymentMode;   // Cash, Card, Online
    private String status;        // Paid, Pending, Cancelled

    public Invoice() {}

    public Invoice(Date invDate, Long modelId, Long user_id,
                   Double totalAmt, Double componentAmt,
                   String paymentMode, String status) {
        this.invDate = invDate;
        this.modelId = modelId;
        this.user_id = user_id;
        this.totalAmt = totalAmt;
        this.componentAmt = componentAmt;
        this.paymentMode = paymentMode;
        this.status = status;
    }

    // Getters and Setters
    public Long getInvId() { return invId; }
    public void setInvId(Long invId) { this.invId = invId; }

    public Date getInvDate() { return invDate; }
    public void setInvDate(Date invDate) { this.invDate = invDate; }

    public Long getModelId() { return modelId; }
    public void setModelId(Long modelId) { this.modelId = modelId; }

    public Long getuser_id() { return user_id; }
    public void setuser_id(Long user_id) { this.user_id = user_id; }

    public Double getTotalAmt() { return totalAmt; }
    public void setTotalAmt(Double totalAmt) { this.totalAmt = totalAmt; }

    public Double getComponentAmt() { return componentAmt; }
    public void setComponentAmt(Double componentAmt) { this.componentAmt = componentAmt; }

    public Double getTax() { return tax; }
    public void setTax(Double tax) { this.tax = tax; }

    public Double getNetAmt() { return netAmt; }
    public void setNetAmt(Double netAmt) { this.netAmt = netAmt; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    
    }

