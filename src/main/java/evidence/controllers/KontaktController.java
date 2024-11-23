package evidence.controllers;

import evidence.models.dto.KontaktDTO;
import evidence.models.services.KontaktService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/kontakt")
public class KontaktController {

    @Autowired
    private KontaktService kontaktService;

    @GetMapping("")
    public String renderCreateForm(@ModelAttribute KontaktDTO kontakt) {
        return "pages/home/kontakt";
    }
    @PostMapping("")
    public String createKontakt(
            @Valid @ModelAttribute KontaktDTO kontakt,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreateForm(kontakt);

        kontaktService.create(kontakt);
        redirectAttributes.addFlashAttribute("success", "Zpráva odeslána.");

        return "redirect:/kontakt";
    }
}

