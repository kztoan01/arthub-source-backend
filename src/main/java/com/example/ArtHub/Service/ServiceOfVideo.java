package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateVideoDTO;
import com.example.ArtHub.Entity.Video;
import com.example.ArtHub.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceOfVideo implements InterfaceOfVideoService {


    @Autowired
    VideoRepository videoRepository;


    @Override
    public Video saveVideo(CreateVideoDTO dto) {
        Video video = new Video();
        video.setName(dto.getName());
        video.setSectionId(dto.getSectionId());
        video.setData(dto.getData());
        video.setScript(dto.getScript());
        video.setTrial(dto.isTrial());
        return videoRepository.save(video) ;
    }


    public int DeleteVideoByCourseID(int id)
    {
      return videoRepository.deleteVideosBySectionID(id);
    }



    @Override
    public List<Video> getVideos() {

        return null;
    }
}
