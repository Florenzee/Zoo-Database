

public class Animal {
		// deklarasi data yang akan di-input
	    private String ID;
	    private String NamaHewan;
	    private int JenisHewan;
	    private String cekJenisHewan;
	    private int Kuantitas;
	    private int TahunKedatangan;
	    private String StatusPemeriksaanHewan;
	    
	    // inisialisasi untuk mengkonstruksi hewan baru
	    public Animal(String ID, String NamaHewan, int JenisHewan, int Kuantitas, int TahunKedatangan) {
	        this.ID = ID;
	        this.NamaHewan = NamaHewan;
	        this.JenisHewan = JenisHewan;
	        this.cekJenisHewan = cekJenisHewan();
	        this.Kuantitas = Kuantitas;
	        this.TahunKedatangan = TahunKedatangan;
	        this.StatusPemeriksaanHewan = cekStatusPemeriksaan();
	    }
	    
	    private String cekJenisHewan() {
	    	if (JenisHewan == 0 || JenisHewan == 1) {
	            return "LEG";
	        } else {
	            return "LEGS";
	        }
		}

		// fungsi untuk melakukan pengecekan status pemeriksaan hewan
	    private String cekStatusPemeriksaan() {
	        if (TahunKedatangan >= 2000 && TahunKedatangan <= 2010) {
	            return "Urgent";
	        } else {
	            return "Normal";
	        }
	    }
	    
	    // fungsi untuk mendapatkan ID
	    public String getID() {
	        return ID;
	    }
	   
	    // fungsi untuk mengurangi jumlah hewan
	    public void removeKuantitas(int quantityToRemove) {
	        Kuantitas -= quantityToRemove;
	    }

	    public String toString() {
	        return "ID: " + ID + "\nNama Hewan: " + NamaHewan + "\nJenis Hewan: " + cekJenisHewan + "\nKuantitas: " + Kuantitas + "\nTahun Kedatangan: " + TahunKedatangan + "\nStatus Pemeriksaan Hewan: " + StatusPemeriksaanHewan + "\n";
	    }
	    
	    // fungsi untuk mendapatkan kuantitas
	    public int getKuantitas() {
	        return Kuantitas;
	    }
	}