package com.example.ex12_valid_annotation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;

@Controller
public class MyController {

    @RequestMapping("/")
    public @ResponseBody String root() {
        return "Validation (1)";
    }

    @RequestMapping("/insert-form")
    public String insert1(@ModelAttribute("dto") ContentDTO contentDto) {
        return "createPage";
    }

    @RequestMapping("/create")
    public String insert2(@ModelAttribute("dto") @Valid ContentDTO contentDto, BindingResult result) {
        String page = "createDonePage";

        System.out.println("valitadion result: " + result.hasErrors());

        if (result.hasErrors()) {
            page = "createPage";
        }

        return page;
    }
}