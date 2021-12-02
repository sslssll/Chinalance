package com.chinafree.auth.service.impl;

import com.chinafree.auth.service.MessageSendService;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;

public class MessageSendServiceImpl implements MessageSendService {

    final static String accessKeyId="accessKeyId";
    final static String accessKeySecret = "accessKeySecret";


    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dysmsapi20170525.Client client = MessageSendServiceImpl.createClient(accessKeyId, accessKeySecret);


        AddShortUrlRequest addShortUrlRequest = new AddShortUrlRequest()
                .setResourceOwnerAccount("test")
                .setResourceOwnerId(1L)
                .setSourceUrl("test")
                .setShortUrlName("test");
        // 复制代码运行请自行打印 API 的返回值
        client.addShortUrl(addShortUrlRequest);
    }

}
