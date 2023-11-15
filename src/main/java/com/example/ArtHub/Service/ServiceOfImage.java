package com.example.ArtHub.Service;

import com.example.ArtHub.DTO.ResponeImageDTO;
import com.example.ArtHub.Entity.Image;
import com.example.ArtHub.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOfImage implements IImageService {

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


    public ResponeImageDTO fromImagetoResponeImageDTO(Image image)
    {
        ResponeImageDTO responeImageDTO = new ResponeImageDTO();

        if(image == null)
        {
            return responeImageDTO;
        }
        else
        {
            responeImageDTO.setId(image.getId());

            responeImageDTO.setOne(image.getOne());

            responeImageDTO.setTwo(image.getTwo());

            responeImageDTO.setThree(image.getThree());

            responeImageDTO.setFour(image.getFour());

            responeImageDTO.setCourseId(image.getCourse().getId());
        }

        return  responeImageDTO;
    }
}
