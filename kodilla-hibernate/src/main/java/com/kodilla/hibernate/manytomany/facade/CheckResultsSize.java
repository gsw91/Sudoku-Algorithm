package com.kodilla.hibernate.manytomany.facade;

import org.springframework.stereotype.Component;

@Component
public class CheckResultsSize {

    public String checkCompaniesQuantity(int resultsSize) {
        if (resultsSize ==1) {
            return " company";
        } else {
            return " companies";
        }
    }

    public String checkEmployeesQuantity(int resultsSize) {
        if (resultsSize ==1) {
            return " employee";
        } else {
            return " employees";
        }
    }

}
