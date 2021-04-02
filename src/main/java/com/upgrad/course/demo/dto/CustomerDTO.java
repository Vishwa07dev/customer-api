package com.upgrad.course.demo.dto;

import com.upgrad.course.demo.customValidator.CustomEmailValidator;

import javax.validation.constraints.*;

public class CustomerDTO {

    private int customerId;
    @NotBlank(message = "First Name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    private String lastName;
    @NotBlank
    @Pattern(regexp="(^[0-9]{10})", message = "Please enter a valid mobile no")
    private String primaryMobileNo;
    @NotBlank
    @Pattern(regexp="(^[0-9]{10})", message = "Please enter a valid alternate mobile no")
    private String alternateMobileNo;
    @NotBlank
    @CustomEmailValidator
    private String emailId;
    @NotBlank
    private String mainAddress;
    @NotBlank
    private String alternateAddress;

    public CustomerDTO() {
    }

    public int getCustomerId() { return customerId; }

    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryMobileNo() {
        return primaryMobileNo;
    }

    public void setPrimaryMobileNo(String primaryMobileNo) {
        this.primaryMobileNo = primaryMobileNo;
    }

    public String getAlternateMobileNo() {
        return alternateMobileNo;
    }

    public void setAlternateMobileNo(String alternateMobileNo) {
        this.alternateMobileNo = alternateMobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(String mainAddress) {
        this.mainAddress = mainAddress;
    }

    public String getAlternateAddress() {
        return alternateAddress;
    }

    public void setAlternateAddress(String alternateAddress) {
        this.alternateAddress = alternateAddress;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", primaryMobileNo='" + primaryMobileNo + '\'' +
                ", alternateMobileNo='" + alternateMobileNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mainAddress=" + mainAddress +
                ", alternateAddress=" + alternateAddress +
                '}';
    }
}
