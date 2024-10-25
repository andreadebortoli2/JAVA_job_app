package com.dba.JAVA_job_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dba.JAVA_job_app.model.JobPost;
import com.dba.JAVA_job_app.repository.JobRepository;

@Service
public class JobService {

        @Autowired
        private JobRepository repository;

        public void addJob(JobPost jobPost) {
                // repository.addJob(JobPost); // edit with JPA
                repository.save(jobPost);
        }

        public List<JobPost> getAllJobs() {
                // return repository.getAllJobs(); // edit with JPA
                return repository.findAll();
        }

        public JobPost getJob(int postId) {
                // return repository.getJob(postId); // edit with JPA
                return repository.findById(postId).orElse(new JobPost());
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
                                                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

                                // Frontend Developer Job Post

                                new JobPost(2, "Frontend Developer",
                                                "Experience in building responsive web applications using React",
                                                3, List.of("HTML", "CSS", "JavaScript", "React")),

                                // Data Scientist Job Post
                                new JobPost(3, "Data Scientist",
                                                "Strong background in machine learning and data analysis", 4,
                                                List.of("Python", "Machine Learning", "Data Analysis")),

                                // Network Engineer Job Post
                                new JobPost(4, "Network Engineer",
                                                "Design and implement computer networks for efficient data communication",
                                                5,
                                                List.of("Networking", "Cisco", "Routing", "Switching")),

                                // Mobile App Developer Job Post
                                new JobPost(5, "Mobile App Developer",
                                                "Experience in mobile app development for iOS and Android", 3,
                                                List.of("iOS Development", "Android Development", "Mobile App")),

                                // DevOps Engineer Job Post

                                new JobPost(6, "DevOps Engineer",
                                                "Implement and manage continuous integration and delivery pipelines",
                                                4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")),

                                // UI/UX Designer Job Post
                                new JobPost(7, "UI/UX Designer",
                                                "Create engaging user experiences and intuitive user interfaces", 2,
                                                List.of("User Experience", "User Interface Design", "Prototyping")),

                                // Cybersecurity Analyst Job Post
                                new JobPost(8, "Cybersecurity Analyst",
                                                "Protect computer systems and networks from cyber threats", 4,
                                                List.of("Cybersecurity", "Network Security", "Incident Response")),

                                // Full Stack Developer Job Post
                                new JobPost(9, "Full Stack Developer",
                                                "Experience in both front-end and back-end development", 5,
                                                List.of("JavaScript", "Node.js", "React", "Spring", "MongoDB")),

                                // Cloud Architect Job Post
                                new JobPost(10, "Cloud Architect",
                                                "Design and implement cloud infrastructure solutions", 6,
                                                List.of("Cloud Computing", "AWS", "Azure", "Google Cloud")),

                                // Job Post 11
                                new JobPost(11, "Software Tester",
                                                "Ensure software quality through testing and validation", 3,
                                                List.of("Testing", "JUnit", "Selenium", "TestNG")),

                                // Job Post 12
                                new JobPost(12, "React Native Developer",
                                                "Develop cross-platform mobile applications using React Native", 2,
                                                List.of("React Native", "JavaScript", "Mobile App Development")),

                                // Job Post 13
                                new JobPost(13, "Business Analyst",
                                                "Analyze business processes and recommend improvements", 4,
                                                List.of("Business Analysis", "Requirements Gathering",
                                                                "Process Modeling")),

                                // Job Post 14
                                new JobPost(14, "Embedded Systems Engineer",
                                                "Design and develop embedded systems for hardware applications", 5,
                                                List.of("Embedded Systems", "C/C++", "Microcontrollers", "RTOS")),

                                // Job Post 15
                                new JobPost(15, "Content Writer",
                                                "Create engaging and informative content for websites and publications",
                                                2,
                                                List.of("Content Writing", "Copywriting", "SEO", "Creative Writing")),

                                // Job Post 16
                                new JobPost(16, "Business Intelligence Analyst",
                                                "Utilize data to provide insights and support decision-making", 4,
                                                List.of("Business Intelligence", "SQL", "Data Warehousing", "Tableau")),

                                // Job Post 17
                                new JobPost(17, "UX Researcher", "Conduct user research to inform the design process",
                                                3,
                                                List.of("User Research", "Usability Testing",
                                                                "Human-Computer Interaction")),

                                // Job Post 18
                                new JobPost(18, "Backend Developer",
                                                "Build server-side logic and databases for web applications", 4,
                                                List.of("Java", "Spring", "Node.js", "MongoDB")),

                                // Job Post 19
                                new JobPost(19, "Game Developer", "Create and optimize games for various platforms", 3,
                                                List.of("Game Development", "Unity", "C#", "3D Modeling")),

                                // Job Post 20
                                new JobPost(20, "IT Project Manager",
                                                "Lead and manage IT projects from initiation to completion", 6,
                                                List.of("Project Management", "Agile", "Scrum", "Risk Management"))));

                repository.saveAll(jobs);
        }

        public List<JobPost> searchByKeyword(String keyword) {
                return repository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
        }
}
