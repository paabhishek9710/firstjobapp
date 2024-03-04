package asphalt.abhishek.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobByID(Long id);

    boolean deleteJobById(Long id);
}
