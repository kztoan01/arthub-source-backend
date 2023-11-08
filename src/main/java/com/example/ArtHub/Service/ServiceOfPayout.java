package com.example.ArtHub.Service;

import com.example.ArtHub.DTO.PayoutDTO;
import com.example.ArtHub.Entity.Payout;
import com.example.ArtHub.Repository.PayoutRepository;
import com.example.ArtHub.utils.ModelMapperObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfPayout implements InterfaceOfPayoutService {

    @Autowired
    ModelMapperObject mapperObject;


    @Autowired
    ServiceOfAccount serviceOfAccount;

    @Autowired
    PayoutRepository payoutRepository;

    @Override
    public PayoutDTO getPayoutInformationByInstructorID(int id) {
       PayoutDTO payoutDTO = mapperObject.modelMapper().map(payoutRepository.findPayoutByAccountId(id), PayoutDTO.class);
       payoutDTO.setFirstname(serviceOfAccount.getAccountByID(id).getFirstname());
       payoutDTO.setLastname(serviceOfAccount.getAccountByID(id).getLastname());
       payoutDTO.setEmail(serviceOfAccount.getAccountByID(id).getEmail());
       payoutDTO.setPhone(serviceOfAccount.getAccountByID(id).getPhone());
       payoutDTO.setImage(serviceOfAccount.getAccountByID(id).getImage());
       return payoutDTO;
    }

    public PayoutDTO fromPayoutToPayoutDTO(Payout payout) {
        PayoutDTO payoutDTO = mapperObject.modelMapper().map(payout, PayoutDTO.class);
        payoutDTO.setFirstname(serviceOfAccount.getAccountByID(payout.getAccountId()).getFirstname());
        payoutDTO.setLastname(serviceOfAccount.getAccountByID(payout.getAccountId()).getLastname());
        payoutDTO.setEmail(serviceOfAccount.getAccountByID(payout.getAccountId()).getEmail());
        payoutDTO.setPhone(serviceOfAccount.getAccountByID(payout.getAccountId()).getPhone());
        payoutDTO.setImage(serviceOfAccount.getAccountByID(payout.getAccountId()).getImage());
        return payoutDTO;
    }

    @Override
    public List<PayoutDTO> getListPayouts() {
        return payoutRepository.findAll().stream().map(this::fromPayoutToPayoutDTO).toList() ;
    }
}
