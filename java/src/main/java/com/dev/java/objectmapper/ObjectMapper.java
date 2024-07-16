package com.dev.java.objectmapper;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;

public class ObjectMapper {

    public  void main(String[] args) {

//            try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            String filePath = "/Users/dperformance/Developer/company/esolution/chargev/poi/documents/모두의충전/chargev/chargev-station.json";
//            File file = ResourceUtils.getFile(filePath);
//            String jsonContent = new String(Files.readAllBytes(file.toPath()));
//            EvListResponseData2 evListV2 = objectMapper.readValue(jsonContent, EvListResponseData2.class);
//
//            return mysqlSave2(evListV2);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            ClassPathResource resource = new ClassPathResource("test.json");
//
//            String json = new String(Files.readAllBytes(Paths.get(resource.getURI())));
//            EvListResponseData2 evListV2 = objectMapper.readValue(json, EvListResponseData2.class);
//            return mysqlSave2(evListV2);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    }
}
