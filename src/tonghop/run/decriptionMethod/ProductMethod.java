package tonghop.run.decriptionMethod;

import tonghop.run.desgine.PMethod;
import tonghop.run.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import static tonghop.run.decriptionMethod.CategoriesMethod.categories;
import static tonghop.run.decriptionMethod.CategoriesMethod.count;

public class ProductMethod implements PMethod {
    public static Product[] productList = new Product[100];
    int countProduct = 0;
    Scanner scanner = new Scanner(System.in);
    boolean checkEdit;

    public Product inputData() {
        if(count == 0 ){
            System.err.println("chưa có category , phải thêm category trước");
            return null;
        };
        Product product = new Product();
        boolean flag;
        String regexID = "^(C|S|A)(?!.*\\1)[A-Za-z0-9]{3}$";
        checkEdit = true;
        if (checkEdit) {
            do {
                flag = false;
                System.out.println("Input ID:");
                String ID = scanner.nextLine();

                if (ID.matches(regexID)){
                    for (int i = 0; i < countProduct; i++) {
                        if(productList[i].getProductid().equals(ID)){
                            System.err.println("ID đã tồn tại");
                            flag = true;
                        }
                    }
                    if (flag == false) {
                        product.setProductid(ID);
                    }
                }else{
                    System.err.println("ID sai định dạng, phải bắt đầu bằng C|S|A và có 4 kí tự");
                    flag = true;
                }

            } while (flag);
        }
        do {
            flag = false;
            System.out.println("Input name:");
            String newName = scanner.nextLine();
            String regex = "^[a-zA-Z0-9\\s]+$";

            if (newName.matches(regex) & newName.length() < 50 & newName.length() > 10 & !newName.isBlank() ){
                for (int i = 0; i < countProduct ; i++) {
                    if (productList[i].getProductName().equals(newName)){
                        System.err.println("Name đã tồn tại");
                        flag = true;
                    }
                } if (flag == false) {
                    product.setProductName(newName);
                }
            }
            else{
                System.err.println("Name sai định dạng, phải có từ 10-50 kí tự");
                flag = true;
            }
        } while (flag);


        System.out.println("input price");
        float price;
        do {
            price = Float.parseFloat(scanner.nextLine());
            product.setPrice(price);
        } while (price <= 0);


        System.out.println("description");
        product.setDescription(scanner.nextLine());
        System.out.println("create");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            product.setCreated(sdf.parse(scanner.nextLine()));
        } catch (ParseException e) {
            System.err.println("lỗi định dạng ");

        }
        for (int i = 0; i < count; i++) {
            System.out.println(categories[i].toString());;
        }
        System.out.println("chọn ID categories");
        int chooseID = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            if (categories[i].getCatalogId() == chooseID) {
                product.setCatalogId(categories[i].getCatalogName());
            }
        }
        System.out.println("nhập trạng thái(0/1/2)");
        product.setProductStatus(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    @Override
    public void displayData() {
        for (int i = 0; i < countProduct; i++) {
            System.out.printf("price : %s | create : %s | catalog: %s |\n", productList[i].getPrice(), productList[i].getCreated().toString(), productList[i].getCatalogId());
            System.out.printf("ID : %s | Name : %s | Description : %s | Status : %s |\n",
                    productList[i].getProductid(),
                    productList[i].getProductName(),
                    productList[i].getDescription(),
                    ((productList[i].getProductStatus() == 0) ? "đang bán" :
                            (productList[i].getProductStatus() == 1) ? "hết hàng" :
                                    (productList[i].getProductStatus() == 2) ? "không bán" : "không hợp lệ"));

            System.out.println("================================================");
        }
    }

    @Override
    public void add() {
        productList[countProduct] = inputData();
        countProduct++;
    }

    @Override
    public void edit() {
        checkEdit = false;
        System.out.println("input editID");
        String editIndex = scanner.nextLine();
        for (int i = 0; i < countProduct; i++) {
            if (productList[i].getProductid().equals(editIndex)) {
                inputData();
            }
        }
    }

    @Override
    public void delete() {
        System.out.println("input DelID");
        String delID = scanner.nextLine();
        int startDel = 0;
        for (int i = 0; i < countProduct; i++) {
            if (productList[i].getProductid().equals(delID)) {
                startDel = i;
            }
        }
        for (int i = startDel; i < countProduct; i++) {
            productList[i] = productList[i + 1];
        }
        productList[countProduct - 1] = null;
        countProduct--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < countProduct-1; i++) {
            for (int j = i+1; j < countProduct; j++) {
                Product temp = new Product();
                if(productList[i].getPrice()>productList[j].getPrice()){
                    temp = productList[i];
                    productList[i] = productList[j];
                    productList[j]= temp;
                }
            }
        }
    }

    @Override
    public void FindByName() {
        System.out.println("nhập tên sản phẩm muốn tìm");
        String FindName = scanner.nextLine().toLowerCase();
        for (int i = 0; i < countProduct; i++) {
            if (productList[i].getProductName().toLowerCase().equals(FindName)){
                System.out.println(productList[i].toString());;
            }
        }
    }

    @Override
    public void FindByPrice() {
        System.out.println("nhập giá bắt đầu muốn tìm:");
        float startPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("nhập giá lớn nhất muốn tìm:");
        float endPrice = Float.parseFloat(scanner.nextLine());
        for (int i = 0; i < countProduct; i++) {
            if(productList[i].getPrice() > startPrice & productList[i].getPrice() < endPrice){
                System.out.println(productList[i].toString());
            }
        }
    }
}
