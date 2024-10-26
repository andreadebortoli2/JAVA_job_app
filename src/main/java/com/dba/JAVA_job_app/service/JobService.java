package com.dba.JAVA_job_app.service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dba.JAVA_job_app.model.JobPost;
import com.dba.JAVA_job_app.repository.JobRepository;

@Service
public class JobService {

        @Autowired
        private JobRepository repository;

        public List<JobPost> getAllJobs() {
                // return repository.getAllJobs(); // edit with JPA
                return repository.findAll();
        }

        public JobPost getJob(int postId) {
                // return repository.getJob(postId); // edit with JPA
                return repository.findById(postId).get();
        }

        public List<JobPost> searchByKeyword(String keyword) {
                return repository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
        }

        public JobPost addJob(JobPost jobPost, MultipartFile image) throws IOException {
                // repository.addJob(JobPost); // edit with JPA
                jobPost.setImageName(image.getOriginalFilename());
                jobPost.setImageType(image.getContentType());
                jobPost.setImageData(image.getBytes());
                return repository.save(jobPost);
        }

        public void updateJob(JobPost jobPost) {
                // repository.updateJob(jobPost); // edit with JPA
                repository.save(jobPost);
        }

        public void deleteJob(int postId) {
                // repository.deleteJob(postId); // edit with JPA
                repository.deleteById(postId);
                ;
        }

        public void load() {
                List<JobPost> jobs = new ArrayList<>(List.of(
                                // Java Developer Job Post
                                new JobPost(1, "Java Developer",
                                                "Must have good experience in core Java and advanced Java", 2,
                                                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate"),
                                                Date.from(Instant.now()), null, null, null),

                                // Frontend Developer Job Post

                                new JobPost(2, "Frontend Developer",
                                                "Experience in building responsive web applications using React",
                                                3, List.of("HTML", "CSS", "JavaScript", "React"),
                                                Date.from(Instant.now()), null, null, null),

                                // Data Scientist Job Post
                                new JobPost(3, "Data Scientist",
                                                "Strong background in machine learning and data analysis", 4,
                                                List.of("Python", "Machine Learning", "Data Analysis"),
                                                Date.from(Instant.now()), null, null, null),
                                // Network Engineer Job Post
                                new JobPost(4, "Network Engineer",
                                                "Design and implement computer networks for efficient data communication",
                                                5,
                                                List.of("Networking", "Cisco", "Routing", "Switching"),
                                                Date.from(Instant.now()), null, null, null),

                                // Mobile App Developer Job Post
                                new JobPost(5, "Mobile App Developer",
                                                "Experience in mobile app development for iOS and Android", 3,
                                                List.of("iOS Development", "Android Development", "Mobile App"),
                                                Date.from(Instant.now()), null, null, null),

                                // DevOps Engineer Job Post

                                new JobPost(6, "DevOps Engineer",
                                                "Implement and manage continuous integration and delivery pipelines",
                                                4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes"),
                                                Date.from(Instant.now()), null, null, null),

                                // UI/UX Designer Job Post
                                new JobPost(7, "UI/UX Designer",
                                                "Create engaging user experiences and intuitive user interfaces", 2,
                                                List.of("User Experience", "User Interface Design", "Prototyping"),
                                                Date.from(Instant.now()), null, null, null),

                                // Cybersecurity Analyst Job Post
                                new JobPost(8, "Cybersecurity Analyst",
                                                "Protect computer systems and networks from cyber threats", 4,
                                                List.of("Cybersecurity", "Network Security", "Incident Response"),
                                                Date.from(Instant.now()), null, null, null),

                                // Full Stack Developer Job Post
                                new JobPost(9, "Full Stack Developer",
                                                "Experience in both front-end and back-end development", 5,
                                                List.of("JavaScript", "Node.js", "React", "Spring", "MongoDB"),
                                                Date.from(Instant.now()), null, null, null),

                                // Cloud Architect Job Post
                                new JobPost(10, "Cloud Architect",
                                                "Design and implement cloud infrastructure solutions", 6,
                                                List.of("Cloud Computing", "AWS", "Azure", "Google Cloud"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 11
                                new JobPost(11, "Software Tester",
                                                "Ensure software quality through testing and validation", 3,
                                                List.of("Testing", "JUnit", "Selenium", "TestNG"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 12
                                new JobPost(12, "React Native Developer",
                                                "Develop cross-platform mobile applications using React Native", 2,
                                                List.of("React Native", "JavaScript", "Mobile App Development"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 13
                                new JobPost(13, "Business Analyst",
                                                "Analyze business processes and recommend improvements", 4,
                                                List.of("Business Analysis", "Requirements Gathering",
                                                                "Process Modeling"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 14
                                new JobPost(14, "Embedded Systems Engineer",
                                                "Design and develop embedded systems for hardware applications", 5,
                                                List.of("Embedded Systems", "C/C++", "Microcontrollers", "RTOS"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 15
                                new JobPost(15, "Content Writer",
                                                "Create engaging and informative content for websites and publications",
                                                2,
                                                List.of("Content Writing", "Copywriting", "SEO", "Creative Writing"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 16
                                new JobPost(16, "Business Intelligence Analyst",
                                                "Utilize data to provide insights and support decision-making", 4,
                                                List.of("Business Intelligence", "SQL", "Data Warehousing", "Tableau"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 17
                                new JobPost(17, "UX Researcher", "Conduct user research to inform the design process",
                                                3,
                                                List.of("User Research", "Usability Testing",
                                                                "Human-Computer Interaction"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 18
                                new JobPost(18, "Backend Developer",
                                                "Build server-side logic and databases for web applications", 4,
                                                List.of("Java", "Spring", "Node.js", "MongoDB"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 19
                                new JobPost(19, "Game Developer", "Create and optimize games for various platforms", 3,
                                                List.of("Game Development", "Unity", "C#", "3D Modeling"),
                                                Date.from(Instant.now()), null, null, null),

                                // Job Post 20
                                new JobPost(20, "IT Project Manager",
                                                "Lead and manage IT projects from initiation to completion", 6,
                                                List.of("Project Management", "Agile", "Scrum", "Risk Management"),
                                                Date.from(Instant.now()), null, null, null)));

                repository.saveAll(jobs);

                JobPost job3 = repository.findById(3).get();
                job3.setImageName("Project-test-image2.jpg");
                job3.setImageType("image/jpeg");
                String imageData = "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";
                job3.setImageData(imageData.getBytes());
                repository.save(job3);

        }

}
