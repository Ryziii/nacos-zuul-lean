package com.rysiw.nacoslean.core.controller;

import com.jcraft.jsch.SftpException;
import com.rysiw.nacoslean.core.config.SftpClient;
import com.rysiw.nacoslean.core.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Rysiw
 * @date 2022/7/19 15:11
 */
@RestController("/test")
public class TestController {

    @Resource
    private SftpClient sftpClient;

    @Resource
    private TestService testService;

    @GetMapping("/sftp")
    public String testSftpClient() throws SftpException {
        List<String> list = sftpClient.ls("/root/nacos/");
        return "123";
    }

    @GetMapping("/testUnZip")
    public void testUnZip(@RequestParam("path") String path){
        testService.testUnzipInputStream(path);
    }
}
