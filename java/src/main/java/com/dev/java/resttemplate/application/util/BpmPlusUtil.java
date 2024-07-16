//package com.dev.java.resttemplate.application.util;
//
//public class BpmPlusUtil {
//
//    private final Configuration cfg;
//
//    public BpmPlusUtil() {
//        this.cfg = createFreemarkerConfiguration();
//    }
//
//    public static Configuration createFreemarkerConfiguration() {
//        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//        cfg.setDefaultEncoding("UTF-8");
//        return cfg;
//    }
//
//    public String generateHtmlTemplateContents(String docForm, Object htmlDto) {
//        try {
//            Template template = new Template("htmlTemplate", docForm, cfg);
//            StringWriter writer = new StringWriter();
//            template.process(htmlDto, writer);
//            return writer.toString();
//        } catch (Exception e) {
//            throw new RuntimeException("Fail to generate HTML Template Contents", e);
//        }
//    }
//}





