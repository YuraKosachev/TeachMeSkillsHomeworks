package Homework_lesson14;

public class ValidationResult {
    private boolean isValid;
    private StringBuilder reasons;

    {
        this.isValid = true;
        this.reasons = new StringBuilder();
    }

    public void setReasons(String reason) {
        this.reasons.append(reason+",");
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean getValid(){
        return isValid;
    }

    public String getReasons() {
        return reasons.toString();
    }
}
