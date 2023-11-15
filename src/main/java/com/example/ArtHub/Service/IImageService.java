package com.example.ArtHub.Service;

import com.example.ArtHub.Entity.Image;

public interface IImageService {
    Image getImageByCourseID(int id);

    public int deleteImageByCourseID(int id);
}
