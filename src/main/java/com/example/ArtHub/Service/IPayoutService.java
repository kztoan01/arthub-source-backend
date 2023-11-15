package com.example.ArtHub.Service;

import com.example.ArtHub.DTO.PayoutDTO;

import java.util.List;

public interface IPayoutService {

    public PayoutDTO getPayoutInformationByInstructorID(int id);

    public List<PayoutDTO> getListPayouts();


}
