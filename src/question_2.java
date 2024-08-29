import java.util.ArrayList;
import java.util.Scanner;

public class question_2 {
    private static ArrayList<Animal> database = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu sistem:");
            System.out.println("1. Memasukkan Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Hapus Semua Data");
            System.out.println("4. Tampilkan Semua Data Kebun Binatang");
            System.out.println("5. Keluar");

            System.out.print("Pilih menu (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    hapusSemuaData();
                    break;
                case 4:
                    tampilkanSemuaData();
                    break;
                case 5:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
            }
        }
    }
    
    
// fungsi untuk menambahkan hewan baru
    private static void tambahData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println("======================");
        System.out.println("Menu : Input Data");
        System.out.println("======================");
        
        System.out.println("Masukkan data Animal:");
        
        // input id
        System.out.print("ID (001-020): ");
        String id = scanner.nextLine();

        // input nama hewan
        System.out.println();
        System.out.print("Nama Hewan: ");
        String namaHewan = scanner.nextLine();

        // input jenis hewan
        System.out.println();
        System.out.println("Jenis Hewan: ");
        System.out.println("Masukan 0 jika hewan tidak memiliki kaki");
        System.out.println("Masukan 1 jika hewan memiliki kaki");
        System.out.print("Jawaban: ");
        int jenisHewan = scanner.nextInt();

        // input kuantitas
        System.out.println();
        System.out.print("Kuantitas (1-10): ");
        int kuantitas = scanner.nextInt();

        //input tahun kedatangan
        System.out.println();
        System.out.print("Tahun Kedatangan (2000-2020): ");
        int tahunKedatangan = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // memasukan data yang di-input ke database
        Animal Animal = new Animal(id, namaHewan, jenisHewan, kuantitas, tahunKedatangan);
        database.add(Animal);

        System.out.println("--- Data telah ditambahkan ---");
        System.out.println();
    }

// fungsi untuk menghapus data
    private static void hapusData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println("======================");
        System.out.println("Menu : Hapus Data");
        System.out.println("======================");
        
        // input ID dari hewan yg ingin dihapus
        System.out.print("Masukkan ID hewan yang akan dihapus: ");
        String idToRemove = scanner.nextLine();

        // input jumlah hewan yang ingin dihapus
        System.out.print("Masukkan jumlah hewan yang akan dihapus: ");
        int quantityToRemove = scanner.nextInt();
        
        // mencari ID hewan yang ingin dihapus pada database
        Animal AnimalToRemove = null;
        for (Animal Animal : database) {
            if (Animal.getID().equals(idToRemove)) {
                AnimalToRemove = Animal; //ID ditemukan, maka set AnimalToRemove = Animal
                break;
            }
        }

        // jika AnimalToRemove tdk null
        if (AnimalToRemove != null) {
            AnimalToRemove.removeKuantitas(quantityToRemove); // kurangi jumlah hewan yang dihapus
            if (AnimalToRemove.getKuantitas() <= 0) {
                database.remove(AnimalToRemove);
                System.out.println("Data hewan dengan ID " + idToRemove + " telah dihapus sebanyak");
            } else {
                System.out.println(quantityToRemove + " hewan telah dihapus dari ID " + idToRemove + ".");
            }
        // jika Id tdk ditemukan (AnimalToRemove = null)
        } else {
            System.out.println("Tidak ada data dengan ID " + idToRemove + ".");
        }
        System.out.println();
    }

// fungsi untuk menghapus semua data
    private static void hapusSemuaData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println("======================");
        System.out.println("Menu : Hapus Semua Data");
        System.out.println("======================");

        inputLoop: while(true) {
        	System.out.print("Anda yakin ingin menghapus semua data? (ya/tidak): ");
        	String konfirmasi = scanner.nextLine();
        	 // jika input "ya"
            if (konfirmasi.equalsIgnoreCase("ya")) {
                database.clear();
                System.out.println("Seluruh data telah dihapus.");
                break;
            // jika input "tidak"
            } else if (konfirmasi.equalsIgnoreCase("tidak")){
                System.out.println("Penghapusan data dibatalkan.");
                break;
            // jika input diluar "ya" atau "tidak"
            } else {
            	System.out.println("Input tidak sesuai, silahkan input kembali.");
            	
            }
        }
        System.out.println();
    }

// menampilkan semua data yang ada
    private static void tampilkanSemuaData() {
    	 System.out.println();
         System.out.println("=============================");
         System.out.println("Menu : Tampilkan Semua Data");
         System.out.println("=============================");
         
        if (database.isEmpty()) {
        	System.out.println("");
            System.out.println("Data Kebun Binatang X kosong.");
            return;
        }

        database.sort((a, b) -> a.getID().compareTo(b.getID()));
        System.out.println("");
        System.out.println("--- Data Kebun Binatang X ---");
        for (Animal Animal : database) {
            System.out.println(Animal);
        }
    }
}