package com.dev.java.enumm.case4;

import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enum")
public class EnumController {


    private final EnumService enumService;

    public EnumController(EnumService enumService) {
        this.enumService = enumService;
    }
    @Bean
    public EnumMapper enumMapper() {
        EnumMapper enumMapper = new EnumMapper();
        enumMapper.put("FeeType", FeeType.class);

        return enumMapper;
    }

    @InitBinder
    private void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(EnumType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(EnumType.findByCompany(text));
            }
        });
    }

    @GetMapping("/ttt")
    public String testt() {
        return HttpStatus.OK.name();
    }

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") @Valid EnumType company) {
        return HttpStatus.OK.name();
    }

    @GetMapping
    public List<EnumMapperValue> getNoBeanCategories() {
//    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return Arrays.stream(FeeType.values())
                .map(EnumMapperValue::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/categories")
    public List<EnumMapperValue> getCategories() {
        return enumMapper().get("FeeType");
    }

    // Todo
    // No serializer found for class com.dev.java.enumm.case4.EnumMapperValue and no properties discovered to create BeanSerializer
    // 해결방법 getNoBeanCategories()에 ObjectMapper
}
