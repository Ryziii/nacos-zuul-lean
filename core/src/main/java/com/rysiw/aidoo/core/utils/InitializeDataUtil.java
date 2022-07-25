//package com.rysiw.aidoo.core.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.*;
//
///**
// * @author Rysiw
// * @date 2022/7/22 11:13
// */
//public class InitializeDataUtil {
//    private static ObjectMapper jackSon = new ObjectMapper();
//
//    public static Map<String, Object> initializeData(List<FieldInfo> fieldInfoList, String row) {
//        HashMap<String, Object> map = new HashMap<>(fieldInfoList.size());
//        //切割
//        String[] fields = row.split("\\u0001", -1);
//        fieldInfoList.forEach(v -> {
//            //String
//            if (v.getWorkFieldType() == 1) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), field);
//                } else {
//                    map.put(v.getWorkFieldName(), "");
//                }
//            }
//            // integer
//            else if (v.getWorkFieldType() == 2) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseInt(field));
//                } else {
//                    map.put(v.getWorkFieldName(), 0);
//                }
//            }
//            //Double
//            else if (v.getWorkFieldType() == 3) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseDouble(field));
//                } else {
//                    map.put(v.getWorkFieldName(), 0.0);
//                }
//            }
//            //Long
//            else if (v.getWorkFieldType() == 4) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseLong(field));
//                } else {
//                    map.put(v.getWorkFieldName(), 0L);
//                }
//            }
//            //数组
//            else if (v.getWorkFieldType() == 5) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    List<String> list = Arrays.asList(field.split("\\u0003", -1));
//                    map.put(v.getWorkFieldName(), list);
//                } else {
//                    map.put(v.getWorkFieldName(), null);
//                }
//            }
//            //时间
//            else if (v.getWorkFieldType() == 6) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseDate(field));
//                } else {
//                    map.put(v.getWorkFieldName(), 0L);
//                }
//            }
//            //NULL
//            else if (v.getWorkFieldType() == 7) {
//                map.put(v.getWorkFieldName(), null);
//            }
//            //json List
//            else if (v.getWorkFieldType() == 8) {
//                String field = fields[v.getGpFieldSite() - 1];
//                field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseJsonList(field));
//                } else {
//                    map.put(v.getWorkFieldName(), new ArrayList<>());
//                }
//            }
//            //json Path
//            else if (v.getWorkFieldType() == 9) {
//                String field = fields[v.getGpFieldSite() - 1];
//                //field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    PathDTO pathDTO = parseJsonPath(field);
//                    map.put(v.getWorkFieldName(), pathDTO);
//                } else {
//                    map.put(v.getWorkFieldName(), null);
//                }
//            }
//            //object
//            else if (v.getWorkFieldType() == 0) {
//                String field = fields[v.getGpFieldSite() - 1];
//                //field = preProcessor(field);
//                if (StringUtils.isNotBlank(field)) {
//                    map.put(v.getWorkFieldName(), parseObject(field));
//                } else {
//                    map.put(v.getWorkFieldName(), null);
//                }
//            }
//        });
//        return map;
//    }
//
//    private static Object parseObject(String field) {
//        try {
//            return jackSon.readValue(field, Object.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static List<Object> parseJsonList(String string) {
//        try {
//            return JSON.parseObject(string, new TypeReference<List<Object>>() {
//            });
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return new ArrayList<>();
//        }
//    }
//
//    private static PathDTO parseJsonPath(String field) {
//        try {
//            return GsonUtil.getGson().fromJson(field, PathDTO.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static Long parseLong(String string) {
//        try {
//            return Long.parseLong(string);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return 0L;
//        }
//    }
//
//
//    public static Integer parseInt(String string) {
//        try {
//            return Integer.parseInt(string);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//
//    public static Double parseDouble(String string) {
//        try {
//            return Double.parseDouble(string);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//            return 0.0;
//        }
//    }
//
//    public static Long parseDate(String date) {
//        SimpleDateFormatPoolKit.SimpleDateFormatSub formator = SimpleDateFormatPoolKit.getFormator(SimpleDateFormatPoolKit.PatternType.YEAR_TO_DAY);
//        try {
//            return formator.parse(date).getTime();
//        } catch (Exception e) {
//            System.err.println("Failed to parse date string : " + date);
//            return 0L;
//        } finally {
//            SimpleDateFormatPoolKit.free(formator);//释放资源
//        }
//    }
//
//    public static String preProcessor(String fields) {
//        if (!fields.startsWith("V1!")) {
//            fields = fields.replace("null", "")
//                    .replace("1900-01-01", "")
//                    .replace("\\\\N", "")
//                    .replace("\\N", "");
//        }
//        return fields;
//    }
//}
