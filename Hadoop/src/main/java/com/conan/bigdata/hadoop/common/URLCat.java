package com.conan.bigdata.hadoop.common;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by huangwt on 2018/9/11.
 */
public class URLCat  {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception{
        InputStream in = null;
        try{
//            in = new URL(args[0]).openStream();
            in = new URL("hdfs://10.1.39.97:8020  /user/test/sort/cf/4fe771cf110d49f68b01fbdd57abd700").openStream();
            IOUtils.copyBytes(in,System.out,4096,false);
        }finally {
            IOUtils.closeStream(in);
        }
    }
}
