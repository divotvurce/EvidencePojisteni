package evidence.controllers;

import evidence.models.dto.PojistenecDTO;
import evidence.models.dto.mappers.PojistenecMapper;
import evidence.models.exceptions.PojistenecNotFoundException;
import evidence.models.services.PojistenecService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pojistenci")
public class PojistenecController {

    @Autowired
    private PojistenecService pojistenecService;

    @Autowired
    private PojistenecMapper pojistenecMapper;

    @GetMapping
    public String renderIndex(Model model) {
        List<PojistenecDTO> pojistenec = pojistenecService.getAll();
        model.addAttribute("pojistenec", pojistenec);

        return "pages/pojistenci/pojistenci";
    }
    @GetMapping("novy")
    public String renderCreateForm(@ModelAttribute PojistenecDTO pojistenec) {
        return "pages/pojistenci/novy";
    }
    @PostMapping("novy")
    public String vytvoritPojistence(
            @Valid @ModelAttribute PojistenecDTO pojistenec,
            BindingResult result,
            RedirectAttributes redirectAttributes

    ) {
        if (result.hasErrors())
            return renderCreateForm(pojistenec);

        pojistenecService.create(pojistenec);
        redirectAttributes.addFlashAttribute("success", "Pijištěnec vytvořen.");

        return "redirect:/pojistenci";
    }
    @GetMapping("{pojistenecId}")
    public String renderDetail(
            @PathVariable long pojistenecId,
            Model model
    ) {
        PojistenecDTO pojistenec = pojistenecService.getById(pojistenecId);
        model.addAttribute("pojistenec", pojistenec);

        return "pages/pojistenci/detail";
    }
    @GetMapping("editovat/{pojistenecId}")
    public String renderEditForm(
            @PathVariable Long pojistenecId,
            PojistenecDTO pojistenec
    ) {
        PojistenecDTO fetchedPojistenec = pojistenecService.getById(pojistenecId);
        pojistenecMapper.updatePojistenecDTO(fetchedPojistenec, pojistenec);

        return "pages/pojistenci/editovat";
    }
    @PostMapping("editovat/{pojistenecId}")
    public String editPojistenec(
            @PathVariable long pojistenecId,
            @Valid PojistenecDTO pojistenec,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(pojistenecId, pojistenec);

        pojistenec.setPojistenecId(pojistenecId);
        pojistenecService.edit(pojistenec);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec upraven.");

        return "redirect:/pojistenci";
    }
    @DeleteMapping("/{pojistenecId}")
    public String deletePojistenec(
            @PathVariable long pojistenecId,
            RedirectAttributes redirectAttributes
    ) {
        pojistenecService.remove(pojistenecId);
        redirectAttributes.addFlashAttribute("success", "Pojištěnec smazán.");
        return "redirect:/pojistenci";
    }
    @ExceptionHandler({PojistenecNotFoundException.class})
    public String handlePojistenecNotFoundException(
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", "Pojištěnec nenalezen.");
        return "redirect:/pojistenci";
    }
}

