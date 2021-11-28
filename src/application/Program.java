package application;

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(6);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        list.forEach(obj -> {
            System.out.println(obj);
        });

        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        list.forEach(obj -> {
            System.out.println(obj);
        });

        /*System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg Grey", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());*/
        
        System.out.println("\n=== TEST 4: seller update ===");
        seller = sellerDao.findById(8);
        seller.setName("Damian Wayne");
        seller.setEmail("damian@gmail.com");
        seller.setBirthDate(new Date());
        seller.setBaseSalary(3500.0);
        sellerDao.update(seller);
        
        
        System.out.println("Update Completed! New Data: \n" + seller);
        

    }

}
