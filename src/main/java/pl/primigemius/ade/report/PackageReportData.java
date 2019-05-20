package pl.primigemius.ade.report;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Raport z weryfikacji materiałów archiwalnych
 * @author bartoszk
 */
public class PackageReportData {
    
    //Archiwum pństwowe
    private Archive stateArchive;
    
    //jednostka przekazująca
    private Archive transferigUnit;
    
    //Dane użytkownika przekazującego materiały archiwalne
    private User transferedBy;
    
    //Datę sporządzenia wniosku
    private LocalDateTime createDateTime;
    
    //Datę sporządzenia spisu z-o
    private LocalDateTime handOverReportDateTime;
    
    //Ilość materiałów archiwalnych
    private BigDecimal packageSizeMB;
    
    //Znak sprawy w archiwum
    private String caseId;
    
    //Datę przeprowadzenia weryfikacji
    private LocalDateTime verifyDateTime;
    
    //Identyfikator paczki archiwalnej 
    private String packageIdentifier;
    
    //Nazwa pliku paczki archiwalnej będącego przedmiotem weryfikacji.
    private String packageFileName;
    
    //Informacja o wynikach wszystkich kroków weryfikacji:
    private List<VerificationResult> verificationResultList;
    
    private User verifiedBy;
    
    private String comment;

    public PackageReportData(Archive stateArchive, Archive transferigUnit, User transferedBy, LocalDateTime createDateTime, LocalDateTime handOverReportDateTime, BigDecimal packageSizeMB, String caseId, LocalDateTime verifyDateTime, String packageIdentifier, String packageFileName, List<VerificationResult> verificationResultList, User verifiedBy, String comment) {
        this.stateArchive = stateArchive;
        this.transferigUnit = transferigUnit;
        this.transferedBy = transferedBy;
        this.createDateTime = createDateTime;
        this.handOverReportDateTime = handOverReportDateTime;
        this.packageSizeMB = packageSizeMB;
        this.caseId = caseId;
        this.verifyDateTime = verifyDateTime;
        this.packageIdentifier = packageIdentifier;
        this.packageFileName = packageFileName;
        this.verificationResultList = verificationResultList;
        this.verifiedBy = verifiedBy;
        this.comment = comment;
    }

    
    public Archive getStateArchive() {
        return stateArchive;
    }

    public void setStateArchive(Archive stateArchive) {
        this.stateArchive = stateArchive;
    }

    public Archive getTransferigUnit() {
        return transferigUnit;
    }

    public void setTransferigUnit(Archive transferigUnit) {
        this.transferigUnit = transferigUnit;
    }

    public User getTransferedBy() {
        return transferedBy;
    }

    public void setTransferedBy(User transferedBy) {
        this.transferedBy = transferedBy;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getHandOverReportDateTime() {
        return handOverReportDateTime;
    }

    public void setHandOverReportDateTime(LocalDateTime handOverReportDateTime) {
        this.handOverReportDateTime = handOverReportDateTime;
    }

    public BigDecimal getPackageSizeMB() {
        return packageSizeMB;
    }

    public void setPackageSizeMB(BigDecimal packageSizeMB) {
        this.packageSizeMB = packageSizeMB;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public LocalDateTime getVerifyDateTime() {
        return verifyDateTime;
    }

    public void setVerifyDateTime(LocalDateTime verifyDateTime) {
        this.verifyDateTime = verifyDateTime;
    }

    public String getPackageIdentifier() {
        return packageIdentifier;
    }

    public void setPackageIdentifier(String packageIdentifier) {
        this.packageIdentifier = packageIdentifier;
    }

    public String getPackageFileName() {
        return packageFileName;
    }

    public void setPackageFileName(String packageFileName) {
        this.packageFileName = packageFileName;
    }

    public List<VerificationResult> getVerificationResultList() {
        return verificationResultList;
    }

    public void setVerificationResultList(List<VerificationResult> verificationResultList) {
        this.verificationResultList = verificationResultList;
    }

    public User getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(User verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
