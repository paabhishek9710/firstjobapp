package asphalt.abhishek.firstjobapp.company.companyserviceimpl;

import asphalt.abhishek.firstjobapp.company.Company;
import asphalt.abhishek.firstjobapp.company.CompanyRepository;
import asphalt.abhishek.firstjobapp.company.CompanyService;
import asphalt.abhishek.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplementor implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplementor(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company updatedCompany, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if(companyOptional.isPresent()){
            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;//Ofcourse
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
         companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            companyRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
