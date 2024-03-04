package asphalt.abhishek.firstjobapp.job.jobserviceimpl;

import asphalt.abhishek.firstjobapp.job.Job;
import asphalt.abhishek.firstjobapp.job.JobRepository;
import asphalt.abhishek.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImplementor implements JobService {

    //private  List<Job> jobs = new ArrayList<>();
    //private Long nextID = 1L;
    JobRepository jobRepository;

    public JobServiceImplementor(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }//because jobRepository is a bean(managed by spring), and will be autowired at runtime thnx to this constructor

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextID++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
        jobRepository.deleteById(id);
        return true;}catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            job.setMinSalary(updatedJob.getMinSalary());
            job.setMaxSalary(updatedJob.getMaxSalary());
            job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;//Ofcourse
        }

        return false;
    }

}
