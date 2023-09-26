package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.CreateImageDTO;
import com.example.ArtHub.Entity.Image;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfImageController;
import com.example.ArtHub.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfImage implements InterfaceOfImageController {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    Path staticPath = Paths.get("static");
    Path imagePath = Paths.get("images");

    @Autowired
    ImageRepository imageRepository;



    public String getImageName(MultipartFile image) throws IOException {
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {

            os.write(image.getBytes());
        }

        return image.getOriginalFilename();
    }



    @Override
    public Image saveCourseImages(@RequestParam MultipartFile one,@RequestParam MultipartFile two,@RequestParam MultipartFile three,@RequestParam MultipartFile four,@RequestParam int courseId) throws IOException {

        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }

        String oneName  = getImageName(one);
        String twoName  = getImageName(two);
        String threeName  = getImageName(three);
        String fourName  = getImageName(four);


        Image image = new Image();
        image.setOne(oneName);
        image.setTwo(twoName);
        image.setThree(threeName);
        image.setFour(fourName);
        image.setCourseId(courseId);
        return  imageRepository.save(image);
    }
}
