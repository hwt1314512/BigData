package com.conan.bigdata.hbase.common;

import com.conan.bigdata.hadoop.util.HadoopConf;
import com.conan.bigdata.hbase.util.HBaseUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */
public class HBaseAdminOperate {

    public static boolean createTable(String tableName, byte[][] splitKeys) {
        HTableDescriptor htd = new HTableDescriptor(TableName.valueOf(tableName));
        HColumnDescriptor hcd1 = new HColumnDescriptor("info");
        hcd1.setMaxVersions(2);
        hcd1.setBlockCacheEnabled(true);
        htd.addFamily(hcd1);
        boolean isSuccess = false;
        try {
            HBaseUtils.getHbaseAdmin().createTable(htd, splitKeys);
            isSuccess = true;
        } catch (IOException e) {
            isSuccess = false;
            e.printStackTrace();
        }
        return isSuccess;
    }

    public static void getTableRegionInfo(String tableName) throws IOException {
        List<HRegionInfo> regionInfos = HBaseUtils.getHbaseAdmin().getTableRegions(TableName.valueOf(tableName));
        for (HRegionInfo regionInfo : regionInfos) {
            System.out.println(regionInfo.getRegionNameAsString());
        }
    }

    public static void deleteTable(String tableName) throws IOException {
        HBaseUtils.getHbaseAdmin().disableTable(TableName.valueOf(tableName));
        HBaseUtils.getHbaseAdmin().deleteTable(TableName.valueOf(tableName));
    }
}