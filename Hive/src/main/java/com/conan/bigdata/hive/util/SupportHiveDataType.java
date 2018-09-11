package com.conan.bigdata.hive.util;

import org.apache.hadoop.hive.ql.io.parquet.MapredParquetInputFormat;
/**
 * Created by Administrator on 2018/8/2.
 */
public enum SupportHiveDataType {
    TINYINT,
    SMALLINT,
    INT,
    BIGINT,
    FLOAT,
    DOUBLE,
    DECIMAL,

    TIMESTAMP,
    DATE,

    STRING,
    CHAR,

    BOOLEAN
}