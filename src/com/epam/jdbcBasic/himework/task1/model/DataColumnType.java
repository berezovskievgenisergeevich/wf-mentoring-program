package com.epam.jdbcBasic.himework.task1.model;

public enum DataColumnType {
    ID,
    VARCHAR,
    DECIMAL,
    DATETIME,
    LONGTEXT,
    DOUBLE;


    public static String getId() {
        return "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  PRIMARY KEY (`id`)";
    }
    public static String get(DataColumnType type){
        return type.name()+" NULL";
    }

    public static String getVarchar(String name) {
        return " `" + name + "` VARCHAR(45) NULL";
    }

    public static String getDecimal(String name) {
        return " `" + name + "` DECIMAL(100) NULL";
    }

    public static String getDatetime(String name) {
        return " `" + name + "` DATETIME NULL";
    }

    public static String getLongtext(String name) {
        return " `" + name + "` LONGTEXT NULL";
    }
    public static String getDouble(String name) {
        return " `" + name + "` DOUBLE NULL";
    }


}
