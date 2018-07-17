package org.demenkov.apacheintegration;

import org.demenkov.apacheintegration.dao.entity.ReportEntity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Checker {
    public static void main(String[] args) {
        ReportEntity entity = new ReportEntity();
        entity.setId(12L);
        entity.setErrorMessage("Error message");
        entity.setSuccess("SUCCESS");
        entity.setTestCase("Test Case");
        try {
            File file = new File("resources/input/test.xml");
            JAXBContext context = JAXBContext.newInstance(ReportEntity.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(entity, file);
            marshaller.marshal(entity, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
