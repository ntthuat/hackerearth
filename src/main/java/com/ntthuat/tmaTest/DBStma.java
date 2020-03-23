package com.ntthuat.tmaTest;

public class DBStma {

    public static String replaceWildCardLikeString( String str ){
        /*boolean isSqlServer = this.conn.getDBType() ==
conn.SQLServer;*/ //this is code tma
        boolean isSqlServer = false;

        //It is possible the string may have an underscore or percent sign.  These characters should be escaped, so that
        //they are not interpreted as wildcards
        if (isSqlServer){
          str = str.replaceAll("[%_\\[]", "[$0]");
        }
        else{        
          //escape characters (we're using $)          
          str = str.replaceAll("[%_$]","\\$$0");
        }

        // replace * with %
        str = str.replace( '*', '%' );

        // replace ? with _
        str = str.replace( '?', '_' );

        //replace ' with ''
        str = str.replaceAll("'", "''");

        if (isSqlServer){
          return " like '" + str + "' ";
        }
        else{
          return " like UPPER('" + str + "') ESCAPE '$' "; // $ Dai dien cho nhieu ky tu, _ dai dien cho 1 ky tu trong MySQL
        }
      }

    public static void main(String[] args) {
        /*String str = "nguyen thien thuat%_";
        System.out.println(str);
        str = str.replaceAll("[%_$]","\\$$0");; //thay the cac ky tu
% _ [ thanh [%] [_] [[]

//Ket qua nghien cuu tai:

//http://o7planning.org/web/fe/default/vi/document/13982/huong-dan-su-dung-b
ieu-thuc-chinh-quy-java-regex

//http://stackoverflow.com/questions/1545179/using-java-regex-how-can-i-repl
ace-all-when-pattern-contains-left-parenthesis
        System.out.println(str);*/
        String str = "a%";
        System.out.println(str);
        str = replaceWildCardLikeString(str);
        System.out.println(str);
    }
}