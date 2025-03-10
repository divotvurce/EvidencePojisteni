package evidence.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import evidence.models.dto.UzivatelDTO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ucet")
public class UcetController {
    @GetMapping("prihlaseni")
    public String renderLogin() {
        return "/pages/ucet/prihlaseni.html";
    }

    @GetMapping("registrace")
    public String renderRegister(@ModelAttribute UzivatelDTO uzivatelDTO) {
        return "/pages/ucet/registrace";
    }
    @PostMapping("registrace")
    public String register(
            @Valid @ModelAttribute UzivatelDTO uzivatelDTO,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderRegister(uzivatelDTO);


        redirectAttributes.addFlashAttribute("success", "Uživatel zaregistrován.");
        return "redirect:/ucet/prihlaseni";
    }

}

