package main;


import java.util.HashSet;
import java.util.Set;

public class HospitalRoom {
    Doctor currentDoctor;
    Set<Patient> currentPatients;
    Set<Doctor> waitingDoctors;
    Set<Patient> waitingPatients;
    private static int PATIENTS_LIMIT = 3;

    public HospitalRoom() {
        this.currentPatients = new HashSet<>();
        this.waitingPatients = new HashSet<>();
        this.waitingDoctors = new HashSet<>();
    }
    public synchronized boolean doctorEnter(Doctor d) throws InterruptedException {
        if (this.currentDoctor == null) {
            this.currentDoctor = d;
            if (this.waitingDoctors.contains(d)) {
                this.waitingDoctors.remove(d);
            }
            System.out.println(d + " entered, number of doctor 1");
            return true;
        }
        
        // if it is the first time the current doctor is waiting, print string
        if (!this.waitingDoctors.contains(d)) {
            System.out.println(d + " is waiting to enter, number of doctor 1");
        }
        this.waitingDoctors.add(d);
        return false;

    }

    public boolean doctorLeave(Doctor d) throws InterruptedException {
        if (this.currentDoctor == null) {
            return false;
        }
        if (this.currentDoctor.name.equals(d.name)) {
            System.out.println(d + " left, number of doctor 0");
            this.currentDoctor = null;
            return true;
        }
        return false;
    }

    public synchronized boolean patientEnter(Patient p) throws InterruptedException {
        if (this.currentPatients.size() < HospitalRoom.PATIENTS_LIMIT) {
            this.currentPatients.add(p);
            if (this.waitingPatients.contains(p)) {
                this.waitingPatients.remove(p);
            }
            System.out.println(p + " entered, number of patients " + this.currentPatients.size());
            return true;
        }
        // if it is the first time the current patient is waiting, print string
        if (!this.waitingPatients.contains(p)) {
            System.out.println(p + " is waiting to enter, number of patients " + this.currentPatients.size());
        }
        this.waitingPatients.add(p);
        return false;
    }

    public boolean patientLeave(Patient p) throws InterruptedException {
        if (this.currentPatients.contains(p)) {
            this.currentPatients.remove(p);
            System.out.println(p + " left");
//                    + " left, number of patients " + this.currentPatients.size());
            return true;
        }
        return false;
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor " + this.name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient " + this.name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}