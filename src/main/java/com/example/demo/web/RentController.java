package com.example.demo.web;

import com.example.demo.model.dto.OfferAddDTO;
import com.example.demo.model.dto.OfferUpdateDTO;
import com.example.demo.model.dto.OfferViewDTO;
import com.example.demo.model.dto.RentAddDTO;
import com.example.demo.model.principal.ApplicationPrincipal;
import com.example.demo.service.OfferManagerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/rent")
@RequiredArgsConstructor
public class RentController {
    private final OfferManagerService offerManagerService;


    @GetMapping("/add/{id}")
    public String addOffer(@PathVariable("id") final String id, final Model model) {
        model.addAttribute("offerId", id);
        OfferViewDTO offer = offerManagerService.getOfferToDTO(id);
        model.addAttribute("offer", offerManagerService.getOfferToDTO(id));
        RentAddDTO rentAddDTO = new RentAddDTO();
        rentAddDTO.setOfferId(id);
        model.addAttribute("rent", rentAddDTO);
        return "rent-details";
    }

    @PostMapping("/add")
    public String rent(
            @Valid RentAddDTO rentAddDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal ApplicationPrincipal currentUser) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("rentAddModel", rentAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.rentAddModel", bindingResult);
            return "redirect:/rent/add/" + rentAddDTO.getOfferId();
        }
        offerManagerService.createRent(rentAddDTO, currentUser.getId());
        return "redirect:/offers/all";
    }
}
