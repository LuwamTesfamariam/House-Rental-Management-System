package mscs.hms.service;


import mscs.hms.model.Landlord;

public interface LandlordService {
    public Landlord save(Landlord landlord);
    public Landlord getById(Integer id);
    public void deleteById(Integer id);
    public Iterable<Landlord> findAll();
}