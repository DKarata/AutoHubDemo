package com.example.demo.web;


import jakarta.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.dto.OfferAddDTO;
import com.example.demo.model.dto.OfferFilterDTO;
import com.example.demo.model.dto.OfferUpdateDTO;
import com.example.demo.model.principal.ApplicationPrincipal;
import com.example.demo.service.OfferManagerService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Controller
@RequestMapping("/offers")
@RequiredArgsConstructor
public class OfferController {
    private final OfferManagerService offerManagerService;
    private final SessionScopeOfferFilter filter;


    @ModelAttribute("offerAddModel")
    public OfferAddDTO initModel() {
        return new OfferAddDTO();
    }


    @GetMapping("/all")
    public String allOffers(
            Model model,
            @PageableDefault(
                    sort = "id",
                    size = 3)
            Pageable pageable) {
        model.addAttribute("offerFilter", filter.getFilter());
        model.addAttribute("brands", offerManagerService.getAllBrandsToDTO());
        model.addAttribute("offers", offerManagerService.getAllOffersToDTO(pageable, filter.getFilter()));
        return "offers";
    }


    @PostMapping("/filter")
    public String filter(final OfferFilterDTO dto, @RequestParam(value = "action") String action) {
        if ("Филтрирай".equals(action)) {
            filter.setFilter(dto);
        } else {
            filter.setFilter(null);
        }
        return "redirect:/offers/all";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable final String id,
            @AuthenticationPrincipal ApplicationPrincipal currentUser
    ) {
        if (!isAdminOrOwner(currentUser.getId(), id)){
            return "redirect:/offers/all/";
        }
        offerManagerService.delete(id);
        return "redirect:/offers/all";
    }


    @GetMapping("/{id}")
    public String offer(
            @PathVariable("id") String id,
            Model model,
            @AuthenticationPrincipal ApplicationPrincipal currentUser
    ) {
        model.addAttribute("offerDetails", offerManagerService.getOfferToDTO(id));
        model.addAttribute("isAdminOrOwner", isAdminOrOwner(currentUser.getId(), id));
        return "details";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/add")
    public String addOffer(Model model) {
        model.addAttribute("brands", offerManagerService.getAllBrandsToDTO());
        return "offer-add";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public String addOffer(
            @Valid OfferAddDTO offerAddDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal ApplicationPrincipal currentUser) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerAddModel", offerAddDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddModel", bindingResult);
            return "redirect:/offers/add";
        }
        offerManagerService.addOffer(offerAddDTO, currentUser.getId());
        return "redirect:/offers/add";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/update/{id}")
    public String update(
            @PathVariable String id,
            Model model,
            @AuthenticationPrincipal ApplicationPrincipal currentUser
    ) {
        if (!isAdminOrOwner(currentUser.getId(), id)){
            return "redirect:/offers/all/";
        }
        model.addAttribute("offerId", id);
        model.addAttribute("brands", offerManagerService.getAllBrandsToDTO());
        if (!model.containsAttribute("offerUpdateModel")) {
            model.addAttribute("offerUpdateModel", offerManagerService.getOfferToDTO(id));
        }
        return "update";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/update/{id}")
    public String update(
            @PathVariable String id,
            @Valid OfferUpdateDTO offerUpdateDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @AuthenticationPrincipal ApplicationPrincipal currentUser) {
        if (!isAdminOrOwner(currentUser.getId(), offerUpdateDTO.getId())){
            return "redirect:/offers/all/";
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerUpdateModel", offerUpdateDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerUpdateModel", bindingResult);
            return "redirect:/offers/update/" + id;
        }
        offerManagerService.updateOffer(offerUpdateDTO);
        return "redirect:/offers/" + id;
    }

    private boolean isAdminOrOwner(
            final String userId,
            final String offerId
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<? extends GrantedAuthority> optional = authentication.getAuthorities().stream().filter(a -> "ROLE_ADMIN".equals(a.getAuthority())).findAny();
        if (optional.isPresent()){
            return true;
        }
        return offerManagerService.isOwner(userId, offerId);
    }
}
