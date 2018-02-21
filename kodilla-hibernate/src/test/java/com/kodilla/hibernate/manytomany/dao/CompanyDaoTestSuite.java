package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    public void testSearchEmployeesByLastname() {
        //Given
        Employee janNowak = new Employee("Jan", "Nowak");
        Employee katarzynaNowak = new Employee("Katarzyna", "Nowak");
        Employee jerzyNowacki = new Employee("Jerzy", "Nowacki");
        employeeDao.save(janNowak);
        employeeDao.save(katarzynaNowak);
        employeeDao.save(jerzyNowacki);
        //When
        List<Employee> employesByLastName = employeeDao.retrieveEmployeesWithLastname("Nowak");
        //Then
        Assert.assertEquals(2, employesByLastName.size());
        //CleanUp
        try {
            employeeDao.delete(janNowak);
            employeeDao.delete(katarzynaNowak);
            employeeDao.delete(jerzyNowacki);
        } catch (Exception e) {
            System.out.println("New excception: " + e);
        }

    }

    @Test
    public void testSearchCompanies() {
        //Given
        Company cdProject = new Company("CD Project");
        Company bitStudio = new Company("11 BIT Studio");
        Company projectAuto = new Company("Project Auto");
        companyDao.save(cdProject);
        companyDao.save(bitStudio);
        companyDao.save(projectAuto);
        //When
        int cdProjectId = cdProject.getId();
        int bitStudioId = bitStudio.getId();
        int projectAutoId = projectAuto.getId();
        List<Company> companies = companyDao.retrieveCompanies("PROJ");
        List<Company> companies1 = companyDao.retrieveCompanies("bit");
        //Then
        Assert.assertEquals(2, companies.size());
        Assert.assertEquals(1,companies1.size());
        //CleanUp
        companyDao.delete(cdProjectId);
        companyDao.delete(bitStudioId);
        companyDao.delete(projectAutoId);
    }

}