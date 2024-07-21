package baiTap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		//Câu a: Viết hàm nhập, hàm xuất
		int[] mang = nhapMang();
		xuatMang(mang);
		
		//Câu b: Tìm số lớn nhất, vị trí của nó trong mảng
		max(mang);
		
		//Câu c: Tìm số âm đầu tiên, vị trí của nó trong mảng
		soAm(mang);
		
		//Câu d: Tìm số âm lớn nhất, vị trí của nó trong mảng
		soAmMax(mang);
		
		//Câu e: Tính tổng các số chẵn
		tongChan(mang);
		
		//Câu f: Đếm có bao nhiêu số âm
		demSoAm(mang);
		
		//Câu g: Tổng các số âm
		tongAm(mang);
		
		//Câu h: Cho người dùng nhập vào x, tìm x có trong mảng hay ko?
		timX(mang);
	}

	public static int[] nhapMang() {
		Scanner scanner = new Scanner(System.in);

		// B1: Người dùng nhập số n
		int n;
		do {
			System.out.println("Xin vui lòng nhập số n: ");
			n = scanner.nextInt();
		} while (n <= 0);

		// B2: Người dùng nhập n số nguyên, lưu trữ trong mảng
		int[] mang = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("mang[" + i + "] = ");
			mang[i] = scanner.nextInt();
		}

		return mang;
	}

	public static void xuatMang(int[] mang) {
		System.out.println("Mảng đã nhập là: ");
		for (int i:mang) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void max(int[] mang) {
		int max = mang[0];
		List<Integer> indexes = new ArrayList<Integer>();
		
		//B1: Tìm max
		for (int i : mang) {
			if (max < i) {
				max = i;
			}
		}
		
		//B2: Tìm vị trí số lớn nhất
		for (int i = 0; i < mang.length; i++) {
			if (max == mang[i]) {
				indexes.add(i + 1);
			}
		}
		
		//B3: In ra kết quả
		System.out.println("Số lớn nhất là: " + max);
		System.out.print("Vị trí số lớn nhất là: ");
		for (int i : indexes) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void soAm(int[] mang) {
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] < 0) {
				System.out.println("Số âm đầu tiên là: " + mang[i] + ". Vị trí là: " + (i + 1));
				return;
			}
		}
		
		//Trường hợp không có số âm
		System.out.println("Mảng không có số âm!");
	}
	
	public static void soAmMax(int[] mang) {
		List<Integer> listSoAm = new ArrayList<Integer>();
		List<Integer> indexes = new ArrayList<Integer>();
		
		//B1: Tìm các số âm
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] < 0) {
				listSoAm.add(mang[i]);
			}
		}
		
		//B2: Tìm số âm lớn nhất và vị trí trong mảng
		if (listSoAm.size() == 0) {
			System.out.println("Mảng không có số âm!");
			return;
		}		
		int soAmMax = listSoAm.get(0);
		for (int i:listSoAm) {
			if (soAmMax < i) soAmMax = i;
		}
		for (int i = 0; i < mang.length; i++) {
			if (mang[i] == soAmMax) {
				indexes.add(i + 1);
			}
		}
		
		//B3: In ra kết quả
		System.out.println("Số âm lớn nhất là: " + soAmMax);
		System.out.println("Vị trí của số âm lớn nhất là: ");
		for (int i:indexes) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
	
	public static void tongChan(int[] mang) {
		int tong = 0;
		
		//B1: Tính tổng
		for (int i:mang) {
			if (i % 2 == 0) {
				tong += i;
			}
		}
		
		//B2: In ra kết quả
		System.out.println("Tổng các số chẵn là: " + tong);
	}
	
	public static void demSoAm(int[] mang) {
		int count = 0;
		
		for (int i:mang) {
			if (i < 0) count++;
		}
		
		System.out.println("Số các số âm là: " + count);
	}
	
	public static void tongAm(int[] mang) {
		int sum = 0;
		
		for (int i:mang) {
			if (i < 0) sum += i;
		}
		
		System.out.println("Tổng các số âm là: " + sum);
	}
	
	public static void timX(int[] mang) {
		Scanner scanner = new Scanner(System.in);

		//B1: Người dùng nhập x
		System.out.print("Xin vui lòng nhập số x: ");
		int x = scanner.nextInt();
		
		//B2: Tìm x trong mảng
		for (int i:mang) {
			if (x == i) {
				System.out.println("Số x có trong mảng!");
				return;
			}
		}
		//Trường hợp không có x trong mảng
		System.out.println("Số x không có trong mảng!");
	}
}
