
import java.io.Serializable;
import java.util.List;

public class Hospital implements Serializable {
    // defining the fields for the hospital
    private String name;
    private String address;
    private List<Doctor> doctors;
    private List<Patient> patients;

    // defualt contructor
    public Hospital(){};

    public Hospital(String name, String address, List<Doctor> doctors, List<Patient> patients) {
        this.name = name;
        this.address = address;
        this.doctors = doctors;
        this.patients = patients;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void  setDoctorList(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void  setPatientList(List<Patient> patient) {
        this.patients = patient;
    }


    // getter methods
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return  this.address;
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    @Override
    public String toString() {
        return "Hospital [name=" + name + ", address=" + address + ", doctors=" + doctors + ", patients=" + patients
                + "]";
    }

    

    // method to add a new doctor
    public void addDoctor(Doctor doctor) {
        if (doctors.contains(doctor)) {
            System.out.println("Doctor already exists in the hospital.");
        }
        doctors.add(doctor);
    }

    

    // remove a doctor
    public boolean removeDoctor(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                doctors.remove(doctor);
                return true;
            }
        }
        return false;
    }

    // method to register a patient
    public void registerPatient(Patient patient) {
        for (Patient p: patients) {
            if (p.getId() == patient.getId()) {
                System.out.println("Patient with ID " + patient.getId() + " is already registered.");
            }
        }

        patients.add(patient);
        System.out.println("Patient registered successfully: " + patient.getName());
    }

    // method to assign a doctor to a patient
    public boolean assignDoctor(int patientId, int doctorId) {
        Patient selectedPatient = null;
        Doctor selectedDoctor = null;

        // finding the doctor
        for (Doctor doctor : doctors) {
            if (doctorId == doctor.getId()) {
                selectedDoctor = doctor;
                break;
            }
        }

        // finding the patient
        for (Patient patient : patients) {
            if (patientId == patient.getId()) {
                selectedPatient = patient;
                break;
            }
        }

        if (selectedDoctor == null) {
            return false;
        }
        if (selectedPatient == null) {
            return false;
        }

        // assigning the doctor
        selectedPatient.setDoctor(selectedDoctor);

        return true;
    }

    public void saveAllData() {
        FileHandler.saveDoctors("doctors.txt", doctors);
        FileHandler.savePatients("patients.txt", patients);
    }

    public void loadAllData() {
        patients = FileHandler.loadPatients("patients.txt");
        doctors = FileHandler.loadDoctors("doctors.txt", patients);
    }


}
