import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Collections
         * Tujuan: Memahami ArrayList, generics, operasi CRUD, iterasi, dan Collections utilities
         */

        // ===== PERBEDAAN ARRAY VS ARRAYLIST =====
        System.out.println("=== PERBEDAAN ARRAY VS ARRAYLIST ===");

        int[] arrayInt = new int[3];
        ArrayList<Integer> listInt = new ArrayList<>();

        arrayInt[0] = 10;
        arrayInt[1] = 20;
        arrayInt[2] = 30;
        // arrayInt[3] = 40; // tidak bisa, ukuran tetap

        listInt.add(10);
        listInt.add(20);
        listInt.add(30);
        listInt.add(40);
        listInt.add(50);

        System.out.println("Panjang array: " + arrayInt.length);
        System.out.println("Ukuran ArrayList: " + listInt.size());
        System.out.println("ArrayList bisa menambah elemen secara dinamis.\n");

        // ===== GENERICS DASAR =====
        System.out.println("=== GENERICS DASAR ===");

        ArrayList rawList = new ArrayList(); // tanpa generics
        rawList.add("Teks");
        rawList.add(123);
        rawList.add(45.6);

        ArrayList<String> listString = new ArrayList<>();
        listString.add("Satu");
        listString.add("Dua");

        ArrayList<Double> listDouble = new ArrayList<>();
        listDouble.add(2.5);
        listDouble.add(3.14);

        System.out.println("Raw list: " + rawList);
        System.out.println("List String: " + listString);
        System.out.println("List Double: " + listDouble + "\n");

        // ===== OPERASI CRUD =====
        System.out.println("=== OPERASI CRUD PADA ARRAYLIST ===");

        ArrayList<String> daftarMahasiswa = new ArrayList<>();
        daftarMahasiswa.add("Andi");
        daftarMahasiswa.add("Budi");
        daftarMahasiswa.add("Citra");
        daftarMahasiswa.add("Dewi");
        daftarMahasiswa.add("Eka");
        daftarMahasiswa.add(2, "Fajar");

        System.out.println("Daftar Mahasiswa: " + daftarMahasiswa);

        System.out.println("Mahasiswa pertama: " + daftarMahasiswa.get(0));
        System.out.println("Mahasiswa terakhir: " + daftarMahasiswa.get(daftarMahasiswa.size() - 1));
        System.out.println("Apakah ada 'Budi'? " + daftarMahasiswa.contains("Budi"));
        System.out.println("Index 'Citra': " + daftarMahasiswa.indexOf("Citra"));
        System.out.println("Jumlah mahasiswa: " + daftarMahasiswa.size());

        daftarMahasiswa.set(1, "Bayu");
        System.out.println("Setelah update: " + daftarMahasiswa);

        daftarMahasiswa.remove(0);
        daftarMahasiswa.remove("Eka");
        System.out.println("Setelah penghapusan: " + daftarMahasiswa);

        daftarMahasiswa.clear();
        System.out.println("Kosong setelah clear? " + daftarMahasiswa.isEmpty() + "\n");

        // ===== ITERASI ARRAYLIST =====
        System.out.println("=== ITERASI ARRAYLIST ===");

        ArrayList<Integer> angka = new ArrayList<>();
        Collections.addAll(angka, 10, 20, 30, 40, 50);

        System.out.println("For loop:");
        for (int i = 0; i < angka.size(); i++) {
            System.out.print(angka.get(i) + " ");
        }
        System.out.println();

        System.out.println("For-each:");
        for (int a : angka) {
            System.out.print(a + " ");
        }
        System.out.println();

        System.out.println("While loop:");
        int i = 0;
        while (i < angka.size()) {
            System.out.print(angka.get(i) + " ");
            i++;
        }
        System.out.println();

        System.out.println("Iterator:");
        Iterator<Integer> it = angka.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");

        // ===== ARRAYLIST DENGAN TIPE DATA KOMPLEKS =====
        System.out.println("=== ARRAYLIST DENGAN TIPE DATA KOMPLEKS ===");

        ArrayList<String[]> dataMahasiswa = new ArrayList<>();
        dataMahasiswa.add(new String[]{"Andi", "123", "TI"});
        dataMahasiswa.add(new String[]{"Budi", "124", "SI"});
        dataMahasiswa.add(new String[]{"Citra", "125", "MI"});

        System.out.println("Nama\tNIM\tJurusan");
        for (String[] mhs : dataMahasiswa) {
            System.out.println(mhs[0] + "\t" + mhs[1] + "\t" + mhs[2]);
        }
        System.out.println();

        // ===== UTILITY METHODS COLLECTIONS =====
        System.out.println("=== UTILITY METHODS COLLECTIONS ===");

        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 64, 34, 25, 12, 22, 11, 90);

        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Frekuensi angka 22: " + Collections.frequency(numbers, 22) + "\n");

        // ===== SEARCHING DAN SORTING =====
        System.out.println("=== SEARCHING DAN SORTING ===");

        ArrayList<String> buah = new ArrayList<>();
        Collections.addAll(buah, "Apel", "Jeruk", "Mangga", "Pisang", "Anggur");

        Collections.sort(buah);
        System.out.println("Buah (sorted): " + buah);

        int idx = Collections.binarySearch(buah, "Mangga");
        System.out.println("Binary Search 'Mangga': index " + idx);

        System.out.println("Linear Search 'Durian': " + linearSearch(buah, "Durian") + "\n");

        // ===== ARRAYLIST 2D =====
        System.out.println("=== ARRAYLIST 2D ===");

        ArrayList<ArrayList<Integer>> matrix2D = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            matrix2D.add(new ArrayList<>());
            for (int c = 0; c < r + 2; c++) {
                matrix2D.get(r).add((r + 1) * 10 + c);
            }
        }
        printMatrix2D(matrix2D);
    }

    // ===== HELPER METHODS =====

    public static int linearSearch(ArrayList<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void printMatrix2D(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
