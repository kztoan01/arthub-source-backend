package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.CreateVideoDTO;
import com.example.ArtHub.DTO.ResponeVideoDTO;
import com.example.ArtHub.Entity.Video;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfVideoController;
import com.example.ArtHub.Repository.VideoRepository;
import com.example.ArtHub.Service.ServiceOfVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
public class ControllerOfVideo implements InterfaceOfVideoController {
    Path staticPath = Paths.get("static");
    Path videoPath = Paths.get("videos");

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    ServiceOfVideo serviceOfVideo;


    public ResponeVideoDTO fromVideoIntoResponeVideoDTO(Video video) {

        ResponeVideoDTO videoDTO = new ResponeVideoDTO();
        videoDTO.setId(video.getId());
        videoDTO.setName(video.getName());
        videoDTO.setData(video.getData());
        videoDTO.setDate(video.getDate());
        videoDTO.setScript(video.getScript());
        videoDTO.setSectionId(video.getSectionId());
        videoDTO.setTrial(video.isTrial());

        return videoDTO;
    }

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));





    @Override
    public ResponeVideoDTO createNewVideo(@RequestParam String name, @RequestParam MultipartFile data, @RequestParam String script, @RequestParam boolean isTrial, @RequestParam int sectionId) throws IOException {


        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(videoPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(videoPath));
        }


        String randomName = UUID.randomUUID().toString().substring(0, 5) +data.getOriginalFilename();
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(videoPath).resolve(randomName);
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(data.getBytes());
        }

        //saved videos can be access via http://localhost:8080\\videos\\VideoForTest.mp4

        CreateVideoDTO createVideoDTO = new CreateVideoDTO();
        createVideoDTO.setSectionId(sectionId);
        createVideoDTO.setData(randomName);
        createVideoDTO.setName(name);
        createVideoDTO.setTrial(isTrial);
        createVideoDTO.setScript(script);

        return  fromVideoIntoResponeVideoDTO(serviceOfVideo.saveVideo(createVideoDTO));
    }

    @Override
    public List<ResponeVideoDTO> findAllVideoBySectionID() {
        return null;
    }

    @Override
    public ResponeVideoDTO findVideoByID() {
        return null;
    }

    @Override
    public List<ResponeVideoDTO> findAllVideos() {
        return null;
    }
}
