package tonghop.run;

import tonghop.run.decriptionMethod.ProductMethod;
import tonghop.run.desgine.PMethod;

import java.util.Scanner;

public class ManageProduct {
    PMethod productMethod = new ProductMethod();
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;

    public void managerProduct() {
        do {
            System.out.println("*******************PRODUCT MANAGEMENT***************** \n" +
                    "1. Nhập thông tin các sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp các sản phẩm theo giá \n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm \n" +
                    "5. Xóa sản phẩm theo mã sản phẩm \n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm \n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn \n" +
                    "phím) \n" +
                    "8. Thoát");
            System.out.print("choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productMethod.add();
                    break;
                case 2:
                    productMethod.displayData();
                    break;
                case 3:
                    productMethod.sort();
                    break;
                case 4:
                    productMethod.edit();
                    break;
                case 5:
                    productMethod.delete();
                    break;
                case 6:
                    productMethod.FindByName();
                    break;
                case 7:
                    productMethod.FindByPrice();
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }
        while (flag);
    }
}
