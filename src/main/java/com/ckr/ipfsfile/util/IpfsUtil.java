package com.ckr.ipfsfile.util;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Description
 * @Author chaikairui
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/27
 */
@Component
public class IpfsUtil {


    @Value("${ipfs.ip}")
    private String ipfsIp;
    @Value("${ipfs.port}")
    private String port;

    private static IPFS ipfsClient = null;

    private IPFS getIpfs() {
        if (ipfsClient != null) {
            return ipfsClient;
        } else {
            return new IPFS("/ip4/" + ipfsIp + "/tcp/" + port);
        }
    }

    public String upLoadFile(File file) {
        try {
            NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);
            MerkleNode addResult = getIpfs().add(fileWrapper).get(0);
            return addResult.hash.toString();
        } catch (IOException io) {
            io.printStackTrace();
        }
        return null;
    }


    public byte[] getFile(String hash) {
        try {
            Multihash filePointer = Multihash.fromBase58(hash);
            byte[] fileContents = getIpfs().cat(filePointer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
