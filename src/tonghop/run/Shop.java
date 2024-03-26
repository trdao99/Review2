package tonghop.run;

import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ManageCategory category = new ManageCategory();
        ManageProduct product = new ManageProduct();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*****************SHOP MENU******************* \n" +
                    "1. Quản lý danh mục sản phẩm \n" +
                    "2. Quản lý sản phẩm \n" +
                    "3. Thoát ");
            System.out.print("choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    category.managerCategory();
                    break;
                case 2:
                    product.managerProduct();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
