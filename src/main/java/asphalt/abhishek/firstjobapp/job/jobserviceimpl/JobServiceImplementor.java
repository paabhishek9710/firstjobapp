package asphalt.abhishek.firstjobapp.job.jobserviceimpl;

import asphalt.abhishek.firstjobapp.job.Job;
import asphalt.abhishek.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImplementor implements JobService {

    private  List<Job> jobs = new ArrayList<>();
    private Long nextID = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextID++);
        jobs.add(job);
    }

    @Override
    public Job getJobByID(Long id) {
        for(Job job : jobs){
            if (job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

}
