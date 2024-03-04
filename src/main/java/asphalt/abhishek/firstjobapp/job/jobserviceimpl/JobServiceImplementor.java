package asphalt.abhishek.firstjobapp.job.jobserviceimpl;

import asphalt.abhishek.firstjobapp.job.Job;
import asphalt.abhishek.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;//Ofcourse
            }
        }
        return false;
    }

}
