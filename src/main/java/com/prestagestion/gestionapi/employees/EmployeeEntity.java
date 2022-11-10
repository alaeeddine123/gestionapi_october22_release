package com.prestagestion.gestionapi.employees;

import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
@Entity
@Slf4j
@Table(name = "employee")
public class EmployeeEntity {



    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long employeeId;

    private String employeeFamilyName;

    private String employeeFirstName;

    private String employeeProfil;

    private String clientMission;

    private String employeeDispo;

    private int employeeSoldeConge;

    private String employeeEmail;

    public EmployeeEntity() {

    }


    public EmployeeEntity(long employeeId, String employeeFamilyName, String employeeFirstName, String employeeProfil, String clientMission, String employeeDispo, int employeeSoldeConge, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeFamilyName = employeeFamilyName;
        this.employeeFirstName = employeeFirstName;
        this.employeeProfil = employeeProfil;
        this.clientMission = clientMission;
        this.employeeSoldeConge = employeeSoldeConge;
        this.employeeEmail = employeeEmail;
    }


    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeFamilyName() {
        return employeeFamilyName;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public String getEmployeeProfil() {
        return employeeProfil;
    }

    public String getClientMission() {
        return clientMission;
    }

    public String getEmployeeDispo() {
        return employeeDispo;
    }

    public int getEmployeeSoldeConge() {
        return employeeSoldeConge;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeFamilyName(String employeFamilyName) {
        this.employeeFamilyName = employeFamilyName;
    }

    public void setEmployeeFirstName(String employeFirstName) {
        this.employeeFirstName = employeFirstName;
    }

    public void setEmployeeProfil(String employeProfil) {
        this.employeeProfil = employeProfil;
    }

    public void setClientMission(String clientMission) {
        this.clientMission = clientMission;
    }

    public void setEmployeeDispo(String employeDispo) {
        this.employeeDispo = employeDispo;
    }

    public void setEmployeeSoldeConge(int employeSoldeConge) {
        this.employeeSoldeConge = employeSoldeConge;
    }

    public void setEmployeeEmail(String employeEmail) {
        this.employeeEmail = employeEmail;
    }
}



