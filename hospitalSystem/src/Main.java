import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ✅ Load hospital data from text files
        List<Patient> patients = FileHandler.loadPatients("patients.txt");
        List<Doctor> doctors = FileHandler.loadDoctors("doctors.txt", patients);
        Hospital hospital = new Hospital("City Hospital", "123rd Main St", doctors, patients);

        while (true) {
            System.out.println("\n=============== Hospital Management System ===============");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Assign Doctor to Patient");
            System.out.println("4. Add Medical Record");
            System.out.println("5. View Patients");
            System.out.println("6. View Patient Medical History");
            System.out.println("7. Save and Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> { // ✅ Add Doctor
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();

                    hospital.addDoctor(new Doctor(doctorId, doctorName, specialization));
                    System.out.println("Doctor added successfully!");
                }

                case 2 -> { // ✅ Add Patient
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();

                    hospital.registerPatient(new Patient(patientId, patientName, age, gender, new ArrayList<>()));
                    System.out.println("Patient added successfully!");
                }

                case 3 -> { // ✅ Assign Doctor to Patient
                    System.out.print("Enter Patient ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int dId = scanner.nextInt();

                    boolean assigned = hospital.assignDoctor(pId, dId);
                    if (assigned) {
                        System.out.println("Doctor assigned successfully!");
                    } else {
                        System.out.println("Failed to assign doctor. Please check the IDs.");
                    }
                }

                case 4 -> { // ✅ Add Medical Record to Patient
                    System.out.print("Enter Patient ID: ");
                    int patId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();
                    System.out.print("Enter Prescription: ");
                    String prescription = scanner.nextLine();
                    System.out.print("Enter Record ID: ");
                    int recordId = scanner.nextInt();

                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getId() == patId) {
                            patient.addMedicalRecord(recordId, diagnosis, prescription);
                            break;
                        }
                    }
                }

                case 5 -> { // ✅ View All Patients
                    System.out.println("Patients in the hospital:");
                    for (Patient patient : hospital.getPatients()) {
                        System.out.println("- " + patient.getName() + " (Age: " + patient.getAge() + ")");
                    }
                }

                case 6 -> { // ✅ View Patient Medical History
                    System.out.print("Enter Patient ID: ");
                    int patHistoryId = scanner.nextInt();
                    boolean historyFound = false;
                    for (Patient patient : hospital.getPatients()) {
                        if (patient.getId() == patHistoryId) {
                            patient.viewMedicalHistory();
                            historyFound = true;
                            break;
                        }
                    }
                    if (!historyFound) {
                        System.out.println("Patient not found.");
                    }
                }

                case 7 -> { // ✅ Save and Exit
                    hospital.saveAllData();
                    System.out.println("Data saved! Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
