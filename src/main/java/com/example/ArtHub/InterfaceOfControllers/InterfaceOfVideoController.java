package com.example.ArtHub.InterfaceOfControllers;

import com.example.ArtHub.DTO.CreateVideoDTO;
import com.example.ArtHub.DTO.ResponeVideoDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/video")
public interface InterfaceOfVideoController {

    @PostMapping("/add")
    public ResponeVideoDTO createNewVideo(String name, MultipartFile data, String script, boolean isTrial, int sectionId  ) throws IOException;

    public List<ResponeVideoDTO> findAllVideoBySectionID();

    public ResponeVideoDTO findVideoByID();

    public List<ResponeVideoDTO> findAllVideos();

    @PostMapping("/delete")
    public int deleteVideo(int id);
}
