package com.ist.svc.common;

public enum Module {

	 USER(10,"用户管理","TM_MGR_USER","LOGIN_NAME"),
	 ROLE(11,"角色管理","TM_MGR_ROLE","ROLE_NAME"),
	 AUTH(12,"资源管理","TM_MGR_AUTH","AUTH_NAME"),
     STB_INFO(13,"设备信息","TM_STB_INFO","COMPANY_NAME"),
     PART_INFO(14,"配件信息","TM_PART_INFO","PART_NAME");

     // 成员变量
     private int type;
     private String name;
     private String table;
     private String column;
     
     // 构造方法
     private Module(int type, String name, String table, String column) {
         this.name = name;
         this.type = type;
         this.table =table;
         this.column =column;
     }
     
     public static String getName(int type) {
         for (Module c : Module.values()) {
             if (c.type == type) {
                 return c.name;
             }
         }
         return null;
     }

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getTable() {
		return table;
	}

	public String getColumn() {
		return column;
	}
     
}
