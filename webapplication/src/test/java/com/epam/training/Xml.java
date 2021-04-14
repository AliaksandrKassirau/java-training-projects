package com.epam.training;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.stream.XMLInputFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Xml {

    @Test
    public void parseXmlFromFile() throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Contact contact;
        try (InputStream data = getClass().getResource("/Sample.xml").openStream()) {
            contact = (Contact) jaxbUnmarshaller.unmarshal(data);
        }
        Assert.assertNotNull(contact);

    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement
    static class Contact {
        @XmlAttribute(name = "type")
        private ContactType contactType;
        @XmlElement
        private ContactDetails contactDetails;
    }

    @XmlRootElement
    static class ContactDetails {

        private String addressLine1;
        private String addressLine2;
        private LocalDateTime dateTime;

        @XmlElement
        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        @XmlElement
        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        @XmlElement
        @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
        public void setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
        }
    }

    enum ContactType {
        PHONE, EMAIL;
    }

    static class LocalDateAdapter extends XmlAdapter<String, LocalDateTime> {
        public LocalDateTime unmarshal(String v) throws Exception {
            return LocalDateTime.parse(v);
        }

        public String marshal(LocalDateTime v) throws Exception {
            return v.toString();
        }
    }
}
