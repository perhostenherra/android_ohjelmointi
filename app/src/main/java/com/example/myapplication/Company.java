package com.example.myapplication;

public class Company {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String businessId;
    private String registrationDate;
    private String companyForm;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCompanyForm() {
        return companyForm;
    }

    public void setCompanyForm(String companyForm) {
        this.companyForm = companyForm;
    }



    //Array List<Company> companies = new ArrayList<company>();
    //Company currentCompany = new Company();
    //companies.add(currentCompany);

}
