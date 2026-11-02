
public class DFSIlustrasi1 {

     // jumlah simpul
    static int n = 8;     
    // matriks ketetanggaan dan indeks 0 tidak dipakai agar  simpul 1-8 pas             
    static int[][] A = new int[n + 1][n + 1]; 
    // penanda simpul sudah dikunjungi atau belum 
    static boolean[] dikunjungi = new boolean[n + 1]; 
    // Fungsi bantu buat nambah sisi, krn graf tidak berarah jadi dua arah
    static void tambahSisi(int a, int b) {
        A[a][b] = 1;
        A[b][a] = 1;
    }

    // Fungsi bantu buat nyetak garis di bawah judul kolom dan panjangnya mengikuti lebar tabel
    static void garis() {
        System.out.print("--+");
        for (int j = 1; j <= n; j++) {
            System.out.print("--");
        }
        System.out.println();
    }

    // Algoritma DFS (rekursif), sesuai pseudocode di slide materi 
    static void DFS(int v) {
        // cetak simpul yang sedang dikunjungi
        System.out.print(v + " ");  
        // tandai sudah dikunjungi
        dikunjungi[v] = true;      

        // cek semua simpul w dari 1 sampai n
        for (int w = 1; w <= n; w++) {
            // jika w bertetangga dengan v dan belum dikunjungi, lanjut DFS ke w
            if (A[v][w] == 1 && !dikunjungi[w]) {
                DFS(w);
            }
        }
        // jika semua tetangga sudah dikunjungi, otomatis balik ke pemanggil
    }

    public static void main(String[] args) {
        // Bangun graf sesuai gambar di ilustrasi
        tambahSisi(1, 2);
        tambahSisi(1, 3);
        tambahSisi(2, 4);
        tambahSisi(2, 5);
        tambahSisi(3, 6);
        tambahSisi(3, 7);
        tambahSisi(4, 8);
        tambahSisi(5, 8);
        tambahSisi(6, 8);
        tambahSisi(7, 8);

        // menmapilkan matriks ketetanggaan
        System.out.println("\n=== Matriks Ketetanggaan (Adjacency Matrix) ===\n");
        System.out.print("v |");
        for (int j = 1; j <= n; j++) {
            // nomor kolom
            System.out.print(" " + j);        
        }
        System.out.println();
        garis();
        for (int i = 1; i <= n; i++) {
            // nomor baris
            System.out.print(i + " |");         
            for (int j = 1; j <= n; j++) {
                System.out.print(" " + A[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n=============================================\n");

        // Jalankan DFS mulai dari simpul 1
        System.out.print("Urutan simpul yang dikunjungi: ");
        DFS(1);
        System.out.println();
    }
}