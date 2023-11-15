package com.example.ArtHub.Controller;

import com.example.ArtHub.DTO.CreateVideoDTO;
import com.example.ArtHub.DTO.ResponeVideoDTO;
import com.example.ArtHub.Entity.Video;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfVideoController;
import com.example.ArtHub.Repository.VideoRepository;
import com.example.ArtHub.Service.ServiceOfFile;
import com.example.ArtHub.Service.ServiceOfVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfVideo implements InterfaceOfVideoController {
    Path staticPath = Paths.get("static");
    Path videoPath = Paths.get("videos");

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    ServiceOfFile serviceOfFile;

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

        serviceOfFile.uploadFile(data);
        CreateVideoDTO createVideoDTO = new CreateVideoDTO();
        createVideoDTO.setSectionId(sectionId);
        createVideoDTO.setData(data.getOriginalFilename());
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

    @Override
    public int deleteVideo(int id) {
        //moi sua
        int delete = videoRepository.deleteVideo(id);
        return delete;
    }
}
