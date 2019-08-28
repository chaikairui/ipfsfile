package com.ckr.ipfsfile;

import com.ckr.ipfsfile.util.IpfsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @Description
 * @Author chaikairui
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/28
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpfsTest {

    @Autowired
    private  IpfsUtil ipfsUtil;

    @Test
    public void ipfsTest() {
        File file = new File("E:\\Oray\\HskDDNS\\HskDDNS.exe");
        String hash = ipfsUtil.upLoadFile(file);
        System.out.println(hash);
    }



}
