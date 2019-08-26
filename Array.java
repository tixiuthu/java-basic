import java.util.Scanner;

/**
 * Created by nththuy on 12/5/18.
 */
public class Array {


    static int soDong, soCot;

    public static int[] nhapmangA() {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng A: ");
        int n = in.nextInt();

        int[] A = new int[n];// tạo ra một mảng mới luôn
        for (int i = 0; i < n; i++) {
            System.out.print("A[" + i + "] = ");
            A[i] = in.nextInt();
        }
        return A;
    }

    public static int xuatmang(int array[]) {
        System.out.print("Danh sách mảng: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("\t" + array[i]);
        }
        System.out.println("----");
        return 0;
    }

    public static void sortDESC(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void sortASC(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * chèn phần tử vào mảng số nguyên tăng dần
     * sau khi chèn mảng vẫn duy trì thứ tự tăng dần
     *
     * @param arr: mảng số nguyên tăng dần
     * @param k:   phần tử chèn vào mảng arr
     */
    public static int[] insert(int[] arr, int k) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > k) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = k;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

    public static int[][] tonghaimatrang(int[][] a, int[][] b) {
        int[][] c = new int[soDong][soCot];
        // Để tính tổng hai ma trận
        // ta sẽ sử dụng 2 vòng lặp for
        // để duyệt i từ 0 đến m và j từ 0 đến n
        // sau đó tính tổng hai phần tử
        // tại vị trí i, j tương ứng của 2 ma trận A, B
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }


    public static void nhapsodongsocot() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào số dòng của mảng: ");
        soDong = scanner.nextInt();
        System.out.println("Nhập vào số cột của mảng: ");
        soCot = scanner.nextInt();

    }


    public static int[][] nhapmanghaichieu() {

        // khai báo và cấp phát bộ nhớ cho mảng
        int[][] A = new int[soDong][soCot];
        Scanner scanner = new Scanner(System.in);
        // Để nhập giá trị các phần tử cho mảng
        // chúng ta sẽ sử dụng 2 vòng lặp for
        // vòng lặp for bên ngoài sẽ duyệt i từ 0 đến soDong - 1
        // và vòng lặp for bên trong sẽ duyệt j từ 0 đến soCot - 1
        // mỗi lần như vậy thì sẽ nhập vào phần tử tại vị trí i, j
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("Nhập phần tử thứ [" + i + ", " + j + "]: ");
                A[i][j] = scanner.nextInt();
            }
        }

        // hiển thị các phần tử trong mảng vừa nhập
        // chúng ta cũng sử dụng 2 vòng lặp for như khi nhập
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(A[i][j] + "\t");
            }
            // sau khi viết xong 1 dòng thi xuống hàng
            System.out.println("\n");
        }
        return A;

    }

    public static void xuatmanghaichieu(int[][] e) {
        // hiển thị ma trận tổng C
        System.out.println("Ma trận tổng C:");
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(e[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args) {
       /* int[] array = null;
        array = nhapmangA();
        System.out.println("----the array before ordering ----");
        xuatmang(array);
        System.out.println("----the array after ordering ----");
        sortDESC(array);
        xuatmang(array);
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap gia tri can insert vao: ");
        int k = in.nextInt();
        array = insert(array, k);
        sortDESC(array);
        System.out.println("----the array after inserting ----");
        xuatmang(array);*/

        nhapsodongsocot();
        System.out.println("nhap hai ma trang C,D");
        int[][] C = null;
        C = nhapmanghaichieu();
        int[][] D = null;
        D = nhapmanghaichieu();

        int[][] E = null;
        E = tonghaimatrang(C, D);
        xuatmanghaichieu(E);


    }
}
