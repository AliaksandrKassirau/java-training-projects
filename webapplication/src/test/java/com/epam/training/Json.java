package com.epam.training;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Iterator;

public class Json {

    @Test
    public void parseJsonFromnFile() throws IOException {
        ObjectMapper om = configureOM();

        Contact contact = null;
        try (InputStream data = getClass().getResource("/Sample.json").openStream()) {
            contact = om.readValue(data, Contact.class);
        }
        Assert.assertNotNull(contact);

        om.writeValue(new File("test.json"), contact);


    }

    @Test
    public void parseJsonListFromnFile() throws IOException {
        ObjectMapper om = configureOM();

        JsonFactory jfactory = new JsonFactory();

        try (InputStream data = getClass().getResource("/SampleList.json").openStream()) {
            JsonParser parser = jfactory
                    .createParser(data);
            parser.setCodec(om);
            parser.nextToken();
            parser.nextToken();
            Contact ctn = parser.readValuesAs(Contact.class).next();
            Contact ctn2 = parser.readValuesAs(Contact.class).next();
            Assert.assertTrue(ctn.getContactType().equals(ContactType.PHONE));
            Assert.assertTrue(ctn2.getContactType().equals(ContactType.EMAIL));
        }
    }

    private ObjectMapper configureOM() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.registerModule(new JavaTimeModule());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        om.setDateFormat(df);
        return om;
    }

    @Data
    static class Contact {
        @JsonProperty("type")
        private ContactType contactType;
        private ContactDetails contactDetails;
    }

    @Data
    static class ContactDetails {
        private String addressLine1;
        private String addressLine2;
        private String addressLine3;
        private String city;
        private String state;
        private String province;
        private String country;
        private String zip;
        private String email;
        private String phone;
        private LocalDateTime dateTime;
    }

    enum ContactType {
        PHONE, EMAIL;
    }
}
