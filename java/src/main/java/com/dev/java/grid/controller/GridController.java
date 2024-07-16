package com.dev.java.grid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Controller
@RequestMapping("/grid")
public class GridController {

    @GetMapping("/default")
    public String main() {
        return "main";
    }

    @GetMapping("/dev")
    public String dev() {
        return "dev";
    }

//    public String createObjectToXml(User user) throws Exception {
//        StringWriter sw = new StringWriter();
//        Result returnXML = new StreamResult(sw);
//
//        try {
//            JAXBContext context = JAXBContext.newInstance(User.class);
//            Marshaller m = context.createMarshaller();
//
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            m.marshal(user, returnXML);
//        } catch (JAXBException e) {
//
//        }
//
//        return sw.toString();
//    }
}
