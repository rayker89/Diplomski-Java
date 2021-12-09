package net.beotel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AGREEMENT")
public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=Client.class)
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=Package.class)
    @JoinColumn(name = "PACKAGE_ID")
    private Package pack;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

    @Column(name = "DATE_SIGNED")
    private Date dateSigned;

    @Column(name = "DATE_EXPIRE")
    private Date dateExpire;

    @ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=AgreementStatus.class)
    @JoinColumn(name = "AGREEMENT_STATUS_ID")
    private AgreementStatus agreementStatus;

    @ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=TechnicianStatus.class)
    @JoinColumn(name = "AGREEMENT_TECHNICIAN_STATUS_ID")
    private TechnicianStatus technicianStatus;

    @Column(name = "INSTALLATION_ADDRESS")
    private String installationAddress;

    @Column(name = "PHONE")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(Date dateSigned) {
        this.dateSigned = dateSigned;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public AgreementStatus getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(AgreementStatus agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public TechnicianStatus getTechnicianStatus() {
        return technicianStatus;
    }

    public void setTechnicianStatus(TechnicianStatus technicianStatus) {
        this.technicianStatus = technicianStatus;
    }

    public String getInstallationAddress() {
        return installationAddress;
    }

    public void setInstallationAddress(String installationAddress) {
        this.installationAddress = installationAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
