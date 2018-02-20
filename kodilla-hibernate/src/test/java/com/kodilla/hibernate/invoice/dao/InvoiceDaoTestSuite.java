package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given

            //Insert&save new products
        Product product = new Product("Glass");
        Product product1 = new Product("Wood");
        Product product2 = new Product("Water");
        productDao.save(product);
        productDao.save(product1);
        productDao.save(product2);

            //Insert&save new invoice
        Invoice invoice = new Invoice("1/02/2018");
        invoiceDao.save(invoice);

            //Insert&save new items
        Item item = new Item(product, new BigDecimal(19), 10, new BigDecimal(190), invoice);
        Item item1 = new Item(product1, new BigDecimal(15), 10, new BigDecimal(150), invoice);
        Item item2 = new Item(product2, new BigDecimal(10), 10, new BigDecimal(100), invoice);
        itemDao.save(item);
        itemDao.save(item1);
        itemDao.save(item2);

        //When
        int productId = product.getId();
        int product1Id = product1.getId();
        int product2Id = product2.getId();
        int invoiceId = invoice.getId();
        int itemId = item.getId();
        int item1Id = item1.getId();
        int item2Id = item2.getId();

        //Then
        Assert.assertEquals(3, productDao.count());
        Assert.assertEquals(3, itemDao.count());
        Assert.assertEquals(1, invoiceDao.count());
        Assert.assertEquals(productId, productDao.findOne(productId).getId());
        Assert.assertEquals(product1Id, productDao.findOne(product1Id).getId());
        Assert.assertEquals(product2Id, productDao.findOne(product2Id).getId());
        Assert.assertEquals(invoiceId, invoiceDao.findOne(invoiceId).getId());
        Assert.assertEquals(itemId, itemDao.findOne(itemId).getId());
        Assert.assertEquals(item1Id, itemDao.findOne(item1Id).getId());
        Assert.assertEquals(item2Id, itemDao.findOne(item2Id).getId());

        //CleanUp
        try {
            itemDao.delete(itemId);
            itemDao.delete(item1Id);
            itemDao.delete(item2Id);
            productDao.delete(productId);
            productDao.delete(product1Id);
            productDao.delete(product2Id);
            invoiceDao.delete(invoiceId);
        } catch (Exception e) {
            System.out.println("Cleaning exception: " + e);
        }

    }


}
