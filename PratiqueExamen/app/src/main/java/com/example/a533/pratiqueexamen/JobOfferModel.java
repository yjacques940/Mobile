package com.example.a533.pratiqueexamen;

public class JobOfferModel {
    String JobTitle;
    String JobDescription;
    String Salary;

    public JobOfferModel(String jobTitle, String jobDescription, String salary) {
        JobTitle = jobTitle;
        JobDescription = jobDescription;
        Salary = salary;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
