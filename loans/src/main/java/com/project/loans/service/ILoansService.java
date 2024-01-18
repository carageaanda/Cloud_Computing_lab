package com.project.loans.service;

import com.project.loans.dto.LoansDto;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoad(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);

}
