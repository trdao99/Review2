package tonghop.run.decriptionMethod;

import tonghop.run.desgine.CMethod;
import tonghop.run.entity.Categories;

import java.util.Scanner;

public class CategoriesMethod implements CMethod {
    public static Categories[] categories = new Categories[100];
    public static int count = 0;

    Scanner scanner = new Scanner(System.in);


    public Categories inputData() {
        Categories categorie = new Categories();
        boolean flag;
        do {
            flag = false;
            System.out.println("input name");
            String newName = scanner.nextLine();
            String regex = "^[a-zA-Z0-9\\s]+$";

            if (newName.matches(regex) & newName.length() < 50 & !newName.isBlank() ){
                for (int i = 0; i < count ; i++) {
                    if (categories[i].getCatalogName().equals(newName)){
                        System.err.println("Name đã tồn tại");
                        flag = true;
                    }
                }if (flag == false) {
                    categorie.setCatalogName(newName);
                }
            }
            else{
                System.err.println("Name sai định dạng và phải < 50 kí tự");
                flag = true;
            }
        } while (flag);
        System.out.println("input decription");
        categorie.setDescriptions(scanner.nextLine());
        System.out.println("input status");
        categorie.setCatalogStatus(Boolean.parseBoolean(scanner.nextLine()));
        return categorie;
    }
    @Override
    public void displayData() {
        for (int i = 0; i < count; i++) {
            categories[i].setCatalogId(i + 1);
            System.out.printf("ID : %d | Name : %s | Description : %s | Status : %s |\n", categories[i].getCatalogId(), categories[i].getCatalogName(), categories[i].getDescriptions(),(categories[i].isCatalogStatus() ? "active" : "non-active"));
        }
    }
    @Override
    public void add() {
        categories[count] = inputData();
        count++;
    }

    @Override
    public void edit() {
        System.out.println("input editIndex");
        int editIndex = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            if (categories[i].getCatalogId() == editIndex) {
                categories[i] = inputData();
            }
        }
    }

    @Override
    public void delete() {
        System.out.println("input DelIndex");
        int delIndex = Integer.parseInt(scanner.nextLine());
        for (int i = delIndex; i < count; i++) {
            categories[i] = categories[i + 1];
        }
        count--;
    }

    @Override
    public void editStatus(){
        System.out.println("input editIndex");
        int editIndex = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            if (categories[i].getCatalogId() == editIndex) {
                if(categories[i].isCatalogStatus() == true){
                    categories[i].setCatalogStatus(false);
                }
                else{
                    categories[i].setCatalogStatus(true);
                }
            }
        }
    }
}

