import java.util.Scanner;

public class parkir {

    private boolean[] parkingSlots = new boolean[10];

    public parkir() {
        for (int i = 0; i < 10; i++) {
            parkingSlots[i] = false;
        }
    }

    public void parkVehicle(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= 10) {
            if (!parkingSlots[slotNumber - 1]) {
                parkingSlots[slotNumber - 1] = true;
                System.out.println("Kendaraan anda sekarang parkir di slot" + slotNumber);
            } else {
                System.out.println("Slot " + slotNumber + " sudah terisi. Mohon pilih slot yang lain.");
            }
        } else {
            System.out.println("Slot angka tidak valid. pilih 1 dan 10 bro.");
        }
    }

    public void leaveVehicle(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= 10) {
            if (parkingSlots[slotNumber - 1]) {
                parkingSlots[slotNumber - 1] = false;
                System.out.println("Sisa slot :" + slotNumber);
            } else {
                System.out.println("Anda telah keluar dari slot" + slotNumber + ", Terima Kasih.");
            }
        } else {
            System.out.println("Slot angka tidak valid broo, pilih 1-10.");
        }
    }

    public void displayParkingStatus() {
        System.out.println("Slot Parkir:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Slot " + (i + 1) + ": ");
            if (parkingSlots[i]) {
                System.out.println("Terisi");
            } else {
                System.out.println("Kosong");
            }
        }
    }

    public static void main(String[] args) {
        parkir parkingSystem = new parkir();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Parkir kendaraan");
            System.out.println("2. Keluar Parkiran");
            System.out.println("3. Tampilkan status parkiran");
            System.out.println("4. Keluar");
            System.out.print("Pilih Opsi: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Pilih Slot (1-10): ");
                    int parkSlot = scanner.nextInt();
                    parkingSystem.parkVehicle(parkSlot);
                    break;

                case 2:
                    System.out.print("Pilih Slot: ");
                    int leaveSlot = scanner.nextInt();
                    parkingSystem.leaveVehicle(leaveSlot);
                    break;

                case 3:
                    parkingSystem.displayParkingStatus();
                    break;

                case 4:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Opsi tidak valid bos, pilih yg bener.");
                    break;
            }
        }
    }
}