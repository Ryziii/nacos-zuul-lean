package com.rysiw.aidoo.core.config;

import com.jcraft.jsch.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * @author Rysiw
 * @date 2022/7/19 14:48
 */
@Component
public class SftpClient {

    @Resource
    private SftpProperties sftpProperties;

    private static ThreadLocal<ChannelSftp> localClient = new ThreadLocal<>();

    public ChannelSftp getConnection(){
        ChannelSftp channelSftp = localClient.get();
        if(Objects.nonNull(channelSftp)&&channelSftp.isConnected()){
            return channelSftp;
        }
        try {
            channelSftp = initClient();
            localClient.set(channelSftp);
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }
        return channelSftp;
    }

    private ChannelSftp initClient() throws JSchException {
        Session session = new JSch().getSession(sftpProperties.username,sftpProperties.host,22);
        session.setPassword(sftpProperties.password);
        Properties config = new Properties();
        config.setProperty("StrictHostKeyChecking","no");
        session.setConfig(config);
        session.connect();
        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        return channelSftp;
    }

    public void close(){
        ChannelSftp channelSftp = localClient.get();
        if(Objects.isNull(channelSftp)){
            return;
        }
        try {
            if(channelSftp.getSession().isConnected()){
                channelSftp.getSession().disconnect();
            }
            channelSftp.disconnect();
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }finally {
            localClient.remove();
        }
    }

    public List<String> ls(String s) {
        try {
            ChannelSftp channelSftp = getConnection();
            Vector<ChannelSftp.LsEntry> list = channelSftp.ls(s);
            return list.stream()
                    .map(ChannelSftp.LsEntry::getFilename)
                    .filter(v->!(v.equals(".")||v.equals("..")))
                    .collect(Collectors.toList());
        } catch (SftpException e) {
            throw new RuntimeException(e);
        }
    }
}
