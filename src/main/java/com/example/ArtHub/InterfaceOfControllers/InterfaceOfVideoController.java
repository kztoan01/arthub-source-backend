package com.example.ArtHub.InterfaceOfControllers;

import com.example.ArtHub.DTO.ResponeVideoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/video")
public interface IVideoController {

    @PostMapping("/add")
    public ResponeVideoDTO createNewVideo(String name, MultipartFile data, String script, boolean isTrial, int sectionId  ) throws IOException;

    public List<ResponeVideoDTO> findAllVideoBySectionID();

    public ResponeVideoDTO findVideoByID();

    public List<ResponeVideoDTO> findAllVideos();

    @PostMapping("/delete")
    public int deleteVideo(int id);
}
