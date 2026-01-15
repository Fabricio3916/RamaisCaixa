package caixa.ramaiscaixa.controller;

import caixa.ramaiscaixa.model.Ramal;
import caixa.ramaiscaixa.service.RamalService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ramais")
public class RamalController {

    private final RamalService service;

    public RamalController(RamalService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(
            @RequestParam(value = "busca", required = false) String busca,
            Model model
    ) {

        if (busca == null || busca.isBlank()) {
            model.addAttribute("ramais", service.listarTodos());
        } else {
            model.addAttribute("ramais", service.buscar(busca));
        }

        model.addAttribute("busca", busca);
        return "ramais";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("ramal", new Ramal());
        return "ramal-form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("ramal", service.buscarPorId(id));
        return "ramal-form";
    }

    @PostMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute Ramal ramal,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("ramal", ramal);
            return "ramal-form";
        }

        service.salvar(ramal);
        return "redirect:/ramais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/ramais";
    }
}
