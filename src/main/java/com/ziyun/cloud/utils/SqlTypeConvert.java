package com.ziyun.cloud.utils;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.PropertyInfo;

/**
 * Sql 字段类型转换自定义
 * @Author:cxy
 * @Date:2018/11/29 17:21
 */
public class SqlTypeConvert extends MySqlTypeConvert {

    @Override
    public PropertyInfo processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("char")) {
            return DbColumnType.STRING;
        }else if(t.contains("enum")){
            return DbColumnType.STRING;
        }else if (t.contains("bigint")) {
            return DbColumnType.LONG;
        } else if (t.contains("tinyint(1)")) {
            return DbColumnType.BOOLEAN;
        } else if (t.contains("int")) {
            return DbColumnType.INTEGER;
        } else if (t.contains("text")) {
            return DbColumnType.STRING;
        } else if (t.contains("bit")) {
            return DbColumnType.BOOLEAN;
        } else if (t.contains("decimal")) {
            return DbColumnType.BIG_DECIMAL;
        } else if (t.contains("clob")) {
            return DbColumnType.CLOB;
        } else if (t.contains("blob")) {
            return DbColumnType.BLOB;
        } else if (t.contains("binary")) {
            return DbColumnType.BYTE_ARRAY;
        } else if (t.contains("float")) {
            return DbColumnType.FLOAT;
        } else if (t.contains("double")) {
            return DbColumnType.DOUBLE;
        } else if (!t.contains("json") && !t.contains("enum")) {
            if (t.contains("date") || t.contains("time") || t.contains("year")) {
                byte var5;
                switch(globalConfig.getDateType()) {
                    case ONLY_DATE:
                        return DbColumnType.DATE;
                    case SQL_PACK:
                        var5 = -1;
                        switch(t.hashCode()) {
                            case 3076014:
                                if (t.equals("date")) {
                                    var5 = 0;
                                }
                                break;
                            case 3560141:
                                if (t.equals("time")) {
                                    var5 = 1;
                                }
                                break;
                            case 3704893:
                                if (t.equals("year")) {
                                    var5 = 2;
                                }
                        }

                        switch(var5) {
                            case 0:
                                return DbColumnType.DATE_SQL;
                            case 1:
                                return DbColumnType.TIME;
                            case 2:
                                return DbColumnType.DATE_SQL;
                            default:
                                return DbColumnType.TIMESTAMP;
                        }
                    case TIME_PACK:
                        var5 = -1;
                        switch(t.hashCode()) {
                            case 3076014:
                                if (t.equals("date")) {
                                    var5 = 0;
                                }
                                break;
                            case 3560141:
                                if (t.equals("time")) {
                                    var5 = 1;
                                }
                                break;
                            case 3704893:
                                if (t.equals("year")) {
                                    var5 = 2;
                                }
                        }

                        switch(var5) {
                            case 0:
                                return DbColumnType.LOCAL_DATE;
                            case 1:
                                return DbColumnType.LOCAL_TIME;
                            case 2:
                                return DbColumnType.YEAR;
                            default:
                                return DbColumnType.LOCAL_DATE_TIME;
                        }
                }
            }

            return DbColumnType.STRING;
        } else {
            return DbColumnType.STRING;
        }
    }

}
