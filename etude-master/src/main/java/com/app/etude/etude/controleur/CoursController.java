package com.app.etude.etude.controleur;



import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.etude.etude.ConfigFile.ImageStorage;
import com.app.etude.etude.dto.CoursDto;
import com.app.etude.etude.dto.Labelvalueclasse;
import com.app.etude.etude.dto.ListCour;
import com.app.etude.etude.dto.Listeprof;
import com.app.etude.etude.services.CoursService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cours")
@RequiredArgsConstructor
public class CoursController {




    private final CoursService coursService;
    private final ImageStorage imageStorage;




    @GetMapping("/all")
    public List<CoursDto> findAllCours() {
        return coursService.findAllCours();
    }


    @GetMapping("/getById/{id}")
    public CoursDto findCourById(@PathVariable Long id) {
        return coursService.findCourById(id);
    }


    @PostMapping("/create")
    public CoursDto createCours(@RequestBody CoursDto coursDto, Authentication connectedUser) {
        return coursService.createCours(coursDto, connectedUser);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCourById(@PathVariable Long id) {
        coursService.deleteCourById(id);
    }
    @PostMapping("/uploadFile/{IdCoursDto}")
	public CoursDto uploadImageCoursDto(@PathVariable Long IdCoursDto, @RequestParam MultipartFile image) {
		return coursService.uploadcoursfile(IdCoursDto, image);
	}
	
	@GetMapping("/downloadcoursFile/{imageName}")
	public ResponseEntity<Resource> downloadTeacherImage(@PathVariable String imageName, HttpServletRequest request) {
		return this.imageStorage.downloadUserImage(imageName, request);
	}
    @GetMapping("/listallcoursbyclassandmatiere/{idclasse}/{idmatiere}")
    public List<ListCour> listecourByClasse (@PathVariable Long idclasse , @PathVariable Long idmatiere) {
        return coursService.findAllCoursByclasseAndmatiere(idclasse, idmatiere);
    }
    
    @GetMapping("/listerprof")
    public List<Listeprof> findAllprof() {
        return coursService.findAllprof();
       
    }

    
    





}





