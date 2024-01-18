package com.project.loans.controller;

import com.project.loans.constants.LoanConstants;
import com.project.loans.dto.LoansDto;
import com.project.loans.dto.ResponseDto;
import com.project.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@AllArgsConstructor
public class LoansController {

    private ILoansService iLoansService;

    private final static String CREATE_LOAN = "create_loan";

    private final static String SUCCESS = "success";
    private final static String LOAN_DETAILS = "loan_details";

    private final static String DELETE_SUCCESS = "delete_success";

    @GetMapping("/createLoanPage")
    public String showCreateCardPage() {
        return CREATE_LOAN;
    }


    @PostMapping("/create")
    public String createLoan(@RequestParam String mobileNumber, Model model) {
        iLoansService.createLoan(mobileNumber);
        model.addAttribute("message", "Loan successfully created!");
        return SUCCESS;
    }


    @GetMapping("/fetch")
    public String fetchLoanDetails(@RequestParam String mobileNumber, Model model) {
        LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
        model.addAttribute("loansDto", loansDto);
        return LOAN_DETAILS;
    }

    @GetMapping("/deleteLoan/{mobileNumber}")
    public String deleteLoan(@PathVariable String mobileNumber) {
        iLoansService.deleteLoan(mobileNumber);
        return DELETE_SUCCESS;
    }


}
