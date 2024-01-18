package com.project.accounts.controller;


import com.project.accounts.constants.AccountsConstants;
import com.project.accounts.dto.CustomerDto;
import com.project.accounts.dto.ResponseDto;
import com.project.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path="/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@AllArgsConstructor
public class AccountsController {

    private final static String CREATE_ACCOUNT = "create_account";

    private final static String SUCCESS = "success";
    private final static String ACCOUNT_DETAILS = "account_details";

    private final static String DELETE_SUCCESS = "delete_success";

    private IAccountsService iAccountsService;

    @GetMapping("/createAccountPage")
    public String showCreateAccountPage() {
        return CREATE_ACCOUNT;
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute CustomerDto customerDto, RedirectAttributes attributes) {
        attributes.addFlashAttribute("yourPhoneNumber", customerDto.getMobileNumber());
        iAccountsService.createAccount(customerDto);
        attributes.addFlashAttribute("successMessage", "Account created successfully!");
        return SUCCESS;
    }


    @GetMapping("/fetch")
    public String fetchAccountDetails(@RequestParam String mobileNumber, Model model) {
        CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
        model.addAttribute("customerDto", customerDto);
        return ACCOUNT_DETAILS;
    }

    @GetMapping("/deleteAccount/{mobileNumber}")
    public String deleteAccount(@PathVariable String mobileNumber) {
        iAccountsService.deleteAccount(mobileNumber);
        return DELETE_SUCCESS;
    }



}
