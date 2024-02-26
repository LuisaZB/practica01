package com.practica01.controller;

import com.practica01.domain.Tipo;
import com.practica01.service.TipoService;
import com.practica01.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var tipos = tipoService.getTipos(false);
        model.addAttribute("tipos", tipos);
        model.addAttribute("totalTipos", tipos.size());
        return "/tipo/listado";
    }

    @GetMapping("/nuevo")
    public String tipoNuevo(Tipo tipo) {
        return "/tipo/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String tipoGuardar(Tipo tipo,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            tipoService.save(tipo);
            tipo.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "tipo",
                            tipo.getIdArbol()));
        }
        tipoService.save(tipo);
        return "redirect:/tipo/listado";
    }

    @GetMapping("/eliminar/{idTipo}")
    public String tipoEliminar(Tipo tipo) {
        tipoService.delete(tipo);
        return "redirect:/tipo/listado";
    }

    @GetMapping("/modificar/{idTipo}")
    public String tipoModificar(Tipo tipo, Model model) {
        tipo = tipoService.getTipo(tipo);
        model.addAttribute("tipo", tipo);
        return "/tipo/modifica";
    }

}
