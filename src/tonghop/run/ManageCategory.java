package tonghop.run;

import tonghop.run.decriptionMethod.CategoriesMethod;
import tonghop.run.desgine.CMethod;

import java.util.Scanner;

public class ManageCategory {
    CMethod categoryMethod = new CategoriesMethod();
    boolean flag = true;
    Scanner scanner = new Scanner(System.in);

    public void managerCategory() {
        do {
            System.out.println("********************CATEGORIES MENU*********** \n" +
                    "1. Nhập thông tin các danh mục \n" +
                    "2. Hiển thị thông tin các danh mục \n" +
                    "3. Cập nhật thông tin danh mục \n" +
                    "4. Xóa danh mục \n" +
                    "5. Cập nhật trạng thái danh mục \n" +
                    "6. Thoát ");
            System.out.print("choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    categoryMethod.add();
                    break;
                case 2:
                    categoryMethod.displayData();
                    break;
                case 3:
                    categoryMethod.edit();
                    break;
                case 4:
                    categoryMethod.delete();
                    break;
                case 5:
                    categoryMethod.editStatus();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
        while (flag);
    }
}
