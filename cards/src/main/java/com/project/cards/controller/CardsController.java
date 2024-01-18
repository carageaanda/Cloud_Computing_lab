package com.project.cards.controller;

import com.project.cards.constants.CardsConstants;
import com.project.cards.dto.CardsDto;
import com.project.cards.dto.ResponseDto;
import com.project.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CardsController {

    private ICardsService iCardsService;

    private final static String CREATE_CARD = "create_card";

    private final static String SUCCESS = "success";
    private final static String CARD_DETAILS = "card_details";

    private final static String DELETE_SUCCESS = "delete_success";

    @GetMapping("/createCardPage")
    public String showCreateCardPage() {
        return CREATE_CARD;
    }

    @PostMapping("/create")
    public String createCard(@RequestParam String mobileNumber, Model model) {
        iCardsService.createCard(mobileNumber);
        model.addAttribute("message", "Card successfully created!");
        return SUCCESS;
    }


    @GetMapping("/fetch")
    public String fetchCardDetails(@RequestParam String mobileNumber, Model model) {
        CardsDto cardsDto = iCardsService.fetchCard(mobileNumber);
        model.addAttribute("cardsDto", cardsDto);
        return CARD_DETAILS;
    }

    @GetMapping("/deleteCard/{mobileNumber}")
    public String deleteCard(@PathVariable String mobileNumber) {
        iCardsService.deleteCard(mobileNumber);
        return DELETE_SUCCESS;
    }


}