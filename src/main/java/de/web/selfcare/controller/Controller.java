package de.web.selfcare.controller;

import de.web.selfcare.models.Post;
import de.web.selfcare.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@org.springframework.stereotype.Controller
public class Controller {

    private Long id;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/deleteall")
    public String deleteAll(Model model) {
        //postRepository.deleteAll();
        return "index.html";
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("postList", postRepository.findAll());
        return "index.html";
    }

    @GetMapping("index.html")
    public String indexre(Model model) {
        return "redirect:/";
    }

    @GetMapping("/post")
    public String addPost(Model model) {
        return "post.html";
    }

    @GetMapping("/detail.html/{id}")
    public String detailed(Model model, @PathVariable(value = "id") Long id) {
        this.id = id;
        return "redirect:/detail.html";
    }

    @GetMapping("/detail.html")
    public String detailedd(Model model) {
        model.addAttribute("post", postRepository.findById(id).orElse(new Post()));
        return "detail.html";
    }

    @PostMapping("/post")
    public String formControllPost(Model model,
            @RequestParam("titel") String titel,
            @RequestParam("datum") String datum,
            @RequestParam("beschreibung") String beschreibung,
            @RequestParam("bild") MultipartFile bild,
            @RequestParam("meditation") String meditation,
            @RequestParam("sport") String sport,
            @RequestParam("schlaf") String schlaf,
            @RequestParam("skincare") boolean skincare,
            RedirectAttributes redirectAttributes) throws IOException {

        Post post = new Post();
        postRepository.save(post);
        String path = "/Users/cumali/Documents/Studium/WEB/uploads/"
                + post.getId();
        post.setTitel(titel);
        if (!datum.isEmpty()) post.setDatum(LocalDate.parse(datum));
        post.setBeschreibung(beschreibung);
        post.setBild(path);
        post.setMeditation(meditation);
        post.setSport(sport);
        post.setSchlaf(schlaf);
        post.setSkincare(skincare);
        Files.write(Paths.get(path), bild.getBytes());
        postRepository.save(post);

        model.addAttribute("posts", postRepository.findAll());

        redirectAttributes.addFlashAttribute("titel", titel);
        redirectAttributes.addFlashAttribute("message", "Upload hat geklappt!");
        return "redirect:/post";
    }

}
