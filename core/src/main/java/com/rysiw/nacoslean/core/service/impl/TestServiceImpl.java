package com.rysiw.nacoslean.core.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rysiw.nacoslean.core.service.TestService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author Rysiw
 * @date 2022/7/21 16:22
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void testUnzipInputStream(String path) {
        InputStream inputStream = null;
        ZipInputStream zipInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = new FileInputStream(path);
            zipInputStream = new ZipInputStream(inputStream);
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            inputStreamReader = new InputStreamReader(zipInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            Gson gson = new GsonBuilder().serializeNulls().create();
            while((line = bufferedReader.readLine()) != null){
//                String message = gson.toJson(InitializeDataUtil.initializeData(fieldInfos, StringsUtil.getString(line, secretKey)));
//                dataToMongo.saveToMongo(message, requests, jackSon, shardKey);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
