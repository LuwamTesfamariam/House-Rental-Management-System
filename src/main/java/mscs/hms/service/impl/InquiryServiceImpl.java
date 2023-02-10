package mscs.hms.service.impl;

import mscs.hms.model.Apartment;
import mscs.hms.model.Inquiry;
import mscs.hms.repository.InquiryRepository;
import mscs.hms.service.InquiryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    @Override
    public Inquiry save(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    @Override
    public Inquiry getById(Integer id) {
        return inquiryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        inquiryRepository.deleteById(id);
    }

    @Override
    public List<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }
    public Page<Inquiry> getAll(String searchString, Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page,pageSize);
        if(searchString == null || searchString.isBlank())
            return inquiryRepository.findAll(pageRequest);
        else
            return inquiryRepository.findByTitleContainsIgnoreCase(searchString, pageRequest);
    }
}
