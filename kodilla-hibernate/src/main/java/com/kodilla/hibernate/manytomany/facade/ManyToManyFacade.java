package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CheckResultsSize checkResultsSize;

    private static final Logger LOGGER = LoggerFactory.getLogger(ManyToManyFacade.class);

    public List<Company> checkCompany(String lastname) throws ProcessingException {
        List<Company> results = companyDao.retrieveCompanies(lastname);
        if (results.size() == 0) {
            LOGGER.error(ProcessingException.ERR_NO_COMPANY);
            throw new ProcessingException(ProcessingException.ERR_NO_COMPANY);
        }
        LOGGER.info("Shearching found: " + results.size() + checkResultsSize.checkCompaniesQuantity(results.size()));
        return results;
    }

    public List<Employee> checkEmployee(String name) throws ProcessingException {
        List<Employee> results = employeeDao.retrieveEmployeesWithLastname(name);
        if (results.size() == 0) {
            LOGGER.error(ProcessingException.ERR_NO_EMPLOYEE);
            throw new ProcessingException(ProcessingException.ERR_NO_EMPLOYEE);
        }
        LOGGER.info("Shearching found: " + results.size() + checkResultsSize.checkEmployeesQuantity(results.size()));
        return results;
    }
}
