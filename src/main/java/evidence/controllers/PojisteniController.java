package evidence.controllers;

import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.PojisteniDTO;
import evidence.models.dto.mappers.PojisteniMapper;
import evidence.models.services.PojistenecService;
import evidence.models.services.PojisteniService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pojisteni")
public class PojisteniController {

    @Autowired
    private PojisteniService pojisteniService;

    @Autowired
    private PojistenecService pojistenecService;

    @Autowired
    private PojisteniMapper pojisteniMapper;

    @GetMapping("/novy/{pojistenecId}")
    public String renderCreateForm(
            @PathVariable Long pojistenecId,
            Model model
    ) {
        PojisteniDTO pojisteni = new PojisteniDTO();
        pojisteni.setPojistenecId(pojistenecId);  // Set pojistenecId on the DTO
        model.addAttribute("pojisteni", pojisteni);
        model.addAttribute("pojistenec", pojistenecService.getById(pojistenecId));
        return "pages/pojisteni/novy";
    }

    @PostMapping("/novy/{pojistenecId}")
    public String createPojisteni(
            @PathVariable Long pojistenecId,
            @Valid @ModelAttribute("pojisteni") PojisteniDTO pojisteni,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {

            model.addAttribute("pojistenec", pojistenecService.getById(pojistenecId));
            return "pages/pojisteni/novy";
        }


        pojisteni.setPojistenecId(pojistenecId);
        pojisteniService.create(pojisteni);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo úspěšně vytvořeno.");

        return "redirect:/pojistenci/" + pojistenecId;
    }

    @GetMapping("/editovat/{pojisteniId}")
    public String renderEditForm(
            @PathVariable Long pojisteniId,
            PojisteniDTO pojisteni,
            Model model
    ) {

        PojisteniDTO fetchedPojisteni = pojisteniService.getById(pojisteniId);
        pojisteniMapper.updatePojisteniDTO(fetchedPojisteni, pojisteni);



        model.addAttribute("pojisteni", fetchedPojisteni);
        model.addAttribute("pojistenec", pojistenecService.getById(fetchedPojisteni.getPojistenecId()));


        return "pages/pojisteni/editovat";
    }

    @PostMapping("/editovat/{pojisteniId}")
    public String editPojisteni(
            @PathVariable long pojisteniId,
            @RequestParam Long pojistenecId,
            @Valid PojisteniDTO pojisteni,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model
    ) {
        if (result.hasErrors())
            return renderEditForm(pojisteniId, pojisteni, model);

        pojisteni.setPojisteniId(pojisteniId);
        pojisteniService.edit(pojisteni);
        redirectAttributes.addFlashAttribute("success", "Pojištění upraveno.");

        return "redirect:/pojistenci/" + pojistenecId;
    }
    @DeleteMapping("/{pojisteniId}")
    public String deletePojisteni(
            @PathVariable long pojisteniId,
            @RequestParam Long pojistenecId,
            RedirectAttributes redirectAttributes
    ) {
        pojisteniService.remove(pojisteniId);
        redirectAttributes.addFlashAttribute("success", "Pojištění smazáno.");
        return "redirect:/pojistenci/" + pojistenecId;
    }
}