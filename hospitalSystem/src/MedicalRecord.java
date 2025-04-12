import java.io.Serializable;

public class MedicalRecord implements Serializable{
    // defining the fields
    private int recordId;
    private Patient patient;
    private String diagnosis;
    private String prescription;

    // default contructor
    public MedicalRecord() {
    }

    public MedicalRecord(String diagnosis, Patient patient, String prescription, int recordId) {
        this.diagnosis = diagnosis;
        this.patient = patient;
        this.prescription = prescription;
        this.recordId = recordId;
    }

    // setter methods
    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }


    // getter methods
    public int getRecordId() {
        return recordId;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MedicalRecord{");
        sb.append("recordId=").append(recordId);
        sb.append(", patient=").append(patient);
        sb.append(", diagnosis=").append(diagnosis);
        sb.append(", prescription=").append(prescription);
        sb.append('}');
        return sb.toString();
    }
}
