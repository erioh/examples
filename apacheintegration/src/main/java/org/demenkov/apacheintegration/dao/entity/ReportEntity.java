package org.demenkov.apacheintegration.dao.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "reportenity")
@XmlRootElement
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "test_case")
    String testCase;

    @Column(name = "success")
    String success;

    @Column(name = "error_message")
    String errorMessage;

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }

    public String getTestCase() {
        return testCase;
    }

    @XmlElement
    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public String getSuccess() {
        return success;
    }

    @XmlElement
    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @XmlElement
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReportEntity{");
        sb.append("id=").append(id);
        sb.append(", testCase='").append(testCase).append('\'');
        sb.append(", success='").append(success).append('\'');
        sb.append(", errorMessage='").append(errorMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
