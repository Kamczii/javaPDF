package pl.primigemius.ade.report;

import java.util.List;

/**
 *
 * @author bartoszk
 */
public class VerificationResult {
    
    private VerificationType type;
    private String typeString;
    private boolean success;
    private String successMessage;
    private List<String> errors;

    public VerificationResult() {
    }

    
    public VerificationResult(VerificationType type, boolean success, String successMessage, List<String> errors, String typeString) {
        this.typeString = typeString;
        this.type = type;
        this.success = success;
        this.successMessage = successMessage;
        this.errors = errors;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    
    public VerificationType getType() {
        return type;
    }

    public void setType(VerificationType type) {
        this.type = type;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
    
}
