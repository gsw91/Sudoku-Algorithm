package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyFacadeTestSuite {

    @Autowired
    private ManyToManyFacade manyToManyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private Company cdProject = new Company("CD Project");
    private Company bitStudio = new Company("11 BIT Studio");
    private Company projectAuto = new Company("Project Auto");
    private Employee janNowak = new Employee("Jan", "Nowak");
    private Employee katarzynaNowak = new Employee("Katarzyna", "Nowak");
    private Employee jerzyNowacki = new Employee("Jerzy", "Nowacki");

    @Before
    public void setRecords() {
        companyDao.save(cdProject);
        companyDao.save(bitStudio);
        companyDao.save(projectAuto);
        employeeDao.save(janNowak);
        employeeDao.save(katarzynaNowak);
        employeeDao.save(jerzyNowacki);
    }

    @After
    public void cleanUpDatabase() {
        companyDao.delete(cdProject);
        companyDao.delete(bitStudio);
        companyDao.delete(projectAuto);
        employeeDao.delete(janNowak);
        employeeDao.delete(katarzynaNowak);
        employeeDao.delete(jerzyNowacki);
    }

    @Test
    public void shouldFindNoCompany() {
        //Given
        List<Company> results = new ArrayList<>();
        //When
        try {
            results = manyToManyFacade.checkCompany("%polsat%");
        } catch (ProcessingException e) {
            //to handle by business
        }
        //Then
        Assert.assertEquals(0, results.size());
    }

    @Test
    public void shouldFindTwoCompany() {
        //Given
        List<Company> results = new ArrayList<>();
        //When
        try {
            results = manyToManyFacade.checkCompany("%proj%");
        } catch (ProcessingException e) {
            //to handle by business
        }
        //Then
        Assert.assertEquals(2, results.size());

    }

    @Test
    public void shouldFindThreeCompany() {
        //Given
        List<Company> results = new ArrayList<>();
        //When
        try {
            results = manyToManyFacade.checkCompany("%ma%");
        } catch (ProcessingException e) {
            //to handle by business
        }
        //Then
        Assert.assertEquals(3, results.size());

    }

    @Test
    public void shouldFindNoEmployee() {
        //Given
        List<Employee> results = new ArrayList<>();
        //When
        try {
            results = manyToManyFacade.checkEmployee("%wojc%");
        } catch (ProcessingException e) {
            //to handle by business
        }
        //Then
        Assert.assertEquals(0, results.size());
    }

    @Test
    public void shouldFindThreeEmployee() {
        //Given
        List<Employee> results = new ArrayList<>();
        //When
        try {
            results = manyToManyFacade.checkEmployee("%owak%");
        } catch (ProcessingException e) {
            //to handle by business
        }
        //Then
        Assert.assertEquals(2, results.size());
    }

}
