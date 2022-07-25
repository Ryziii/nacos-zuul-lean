package com.rysiw.aidoo.core.controller;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.rysiw.aidoo.core.config.SftpClient;
import com.rysiw.aidoo.core.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Vector;

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
