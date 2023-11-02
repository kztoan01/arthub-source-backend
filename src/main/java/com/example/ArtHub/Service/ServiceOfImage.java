package com.example.ArtHub.Service;

import com.example.ArtHub.Entity.Image;
import com.example.ArtHub.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfImage implements InterfaceOfImageService{

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image getImageByCourseID(int id) {
        return imageRepository.findByCourseId(id);
    }

   @Override
    public int deleteImageByCourseID(int id)
    {
        return imageRepository.deleteImageByCourseId(id);
    }
}
