package asphalt.abhishek.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){

        return new ResponseEntity<>(jobservice.findAll(),HttpStatus.OK);
        /*
        or do this
        return ResponseEntity.ok(jobservice.findAll());
        */
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobservice.createJob(job);
        //return new ResponseEntity<String>("Job added successfully.",HttpStatus.OK);
        return ResponseEntity.ok("Job added successfully.");
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobservice.getJobByID(id);
        if(job != null) return new ResponseEntity<>(job,HttpStatus.OK);
        return new ResponseEntity<>(job,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobservice.deleteJobById(id);
        if(deleted) return ResponseEntity.ok("Job posting is deleted successfully.");
        return new ResponseEntity<>("Job posting was not found to be deleted.",HttpStatus.NOT_FOUND);
    }
}
