package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateAccountDTO;
import com.example.ArtHub.DTO.CreateVideoDTO;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Video;

import java.util.List;

public interface InterfaceOfVideoService {

    Video saveVideo(CreateVideoDTO dto) throws AppServiceExeption;

    List<Video> getVideos();


}
