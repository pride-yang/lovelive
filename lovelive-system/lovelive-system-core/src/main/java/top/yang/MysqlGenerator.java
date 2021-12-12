package top.yang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import top.yang.string.StringUtils;

/**
 * @author PrideYang
 */
public class MysqlGenerator {

    private static final String API = "lovelive-system-api";
    private static final String CORE = "lovelive-system-core";

    public static void main(String[] args) {

        String[] tables = new String[]{"sys_role", "sys_notice", "sys_dict_type", "sys_dict_data", "sys_dept" };
        for (String s : tables) {
            createComponent(s);
            createController(s);
//            createDomain(s);
            createManager(s);
            createService(s);
            createManagerImpl(s);
        }
    }

    public static void createComponent(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.component;\n"
                + "\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n");
        stringBuffer.append("import top.yang.domain.entity.").append(underlineToHump(table, false)).append(";\n");
        stringBuffer.append("import org.springframework.stereotype.Component").append(";\n");
        stringBuffer.append("import top.yang.mapper.").append(underlineToHump(table, false)).append("Mapper;\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */\n");
        stringBuffer.append("@Component\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("Component extends BaseJdbcComponent<").append(underlineToHump(table, false))
                .append("Mapper, ")
                .append(underlineToHump(table, false)).append(", Long>{\n");
        stringBuffer.append("\n");
        stringBuffer.append("    @Autowired\n");
        stringBuffer.append("    private ").append(underlineToHump(table, false)).append("Mapper ").append(underlineToHump(table, true)).append("Mapper;");
        stringBuffer.append("\n");
        stringBuffer.append("\n");
        stringBuffer.append("    @Override\n");
        stringBuffer.append("    protected ").append(underlineToHump(table, false)).append("Mapper getRepository() {\n");
        stringBuffer.append("        return ").append(underlineToHump(table, true)).append("Mapper;");
        stringBuffer.append("    }");
        stringBuffer.append("\n");
        stringBuffer.append("}");
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/component/" + underlineToHump(table, false) + "Component.java",
                stringBuffer.toString());
    }

    public static void createController(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.controller;\n"
                + "\n"
                + "import org.springframework.beans.BeanUtils;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Controller;\n"
                + "import org.springframework.web.bind.annotation.RequestMapping;\n");
        stringBuffer.append("import top.yang.web.controller.BaseController;\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */\n");
        stringBuffer.append("@Controller\n");
        stringBuffer.append("@RequestMapping()\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("Controller extends BaseController {\n");
        stringBuffer.append("\n");
        stringBuffer.append("}");
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/controller/" + underlineToHump(table, false) + "Controller.java",
                stringBuffer.toString());
    }

    public static void createManager(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.manager;\n");

        stringBuffer.append("import top.yang.domain.entity.").append(underlineToHump(table, false)).append(";\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */\n");
        stringBuffer.append("public interface ").append(underlineToHump(table, false)).append("Manager extends BaseManager<").append(underlineToHump(table, false))
                .append(", Long> {\n");
        stringBuffer.append("\n");
        stringBuffer.append("}");
        writeFile(System.getProperty("user.dir") + File.separator + API + "/src/main/java/top/yang/manager/" + underlineToHump(table, false) + "Manager.java",
                stringBuffer.toString());
    }

    public static void createManagerImpl(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.manager.impl;\n");
        stringBuffer.append("import top.yang.component.").append(underlineToHump(table, false)).append("Component;\n");
        stringBuffer.append("import top.yang.manager.").append(underlineToHump(table, false)).append("Manager;\n");
        stringBuffer.append("import top.yang.domain.entity.").append(underlineToHump(table, false)).append(";\n");
        stringBuffer.append("import org.springframework.stereotype.Component;\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */\n");

        stringBuffer.append("@Component\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("ManagerImpl extends BaseManagerImpl<").append(underlineToHump(table, false))
                .append("Component, ")
                .append(underlineToHump(table, false)).append(", Long> implements ").append(underlineToHump(table, false)).append("Manager {\n");
        stringBuffer.append("\n}");
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/manager/impl/" + underlineToHump(table, false) + "ManagerImpl.java",
                stringBuffer.toString());
    }

    public static void createService(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.service;\n");
        stringBuffer.append("\n");
        stringBuffer.append("import top.yang.domain.entity.").append(underlineToHump(table, false)).append(";\n");
        stringBuffer.append("import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Service;" + "\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */");
        stringBuffer.append("@Service\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("Service {\n");
        stringBuffer.append("\n");
        stringBuffer.append("}");
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/service/" + underlineToHump(table, false) + "Service.java",
                stringBuffer.toString());
    }


    public static void createDomain(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.domain.entity.").append(underlineToHump(table, false)).append("\n");
        stringBuffer.append("import java.util.Date;" + "\n");
        stringBuffer.append("import lombok.Data;" + "\n");
        stringBuffer.append("import org.springframework.data.annotation.Id;" + "\n");
        stringBuffer.append("import org.springframework.data.relational.core.mapping.Table;" + "\n");
        stringBuffer.append("top.yang.domain.pojo.BaseEntity;" + "\n");
        stringBuffer.append("\n/**\n * @author PrideYang\n */\n");
        stringBuffer.append("@Data\n@Table(\"").append(table).append("\")");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("extends BaseEntity {\n\n\n");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/love_system", "root", "yzh19981204mysql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select column_name,data_type,column_comment,column_key  from information_schema.columns where table_schema=" + "love_system" + " and table_name=" + table
                            + ";");

            while (resultSet.next()) {
                String columnName = resultSet.getString("column_name");
                String dataType = resultSet.getString("data_type");
                String columnComment = resultSet.getString("column_comment");
                String columnKey = resultSet.getString("column_key");
                if (StringUtils.equalsAnyIgnoreCase(columnName, "create_time", "update_time")) {
                    continue;
                }
                stringBuffer.append("  /**\n");
                stringBuffer.append("   * ").append(columnComment).append("\n");
                stringBuffer.append("  /**\n");
                if ("".equals(columnKey)) {
                    stringBuffer.append("  @Id\n");
                }
                stringBuffer.append("  private ").append(getFieldType(dataType)).append(" ").append(underlineToHump(columnName, true)).append("\n");
            }
            stringBuffer.append("}");
            writeFile(System.getProperty("user.dir") + File.separator + API + "/src/main/java/top/yang/domain/entity/" + underlineToHump(table, false) + ".java",
                    stringBuffer.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getFieldType(String fieldType) {
        if (StringUtils.equalsAnyIgnoreCase(fieldType, "varchar", "longtext", "text")) {
            return "String";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "int")) {
            return "Integer";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "bigint")) {
            return "Long";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "datetime", "date", "timestamp")) {
            return "Date";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "blob")) {
            return "byte[]";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "float")) {
            return "Float";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "double")) {
            return "Double";
        } else {
            return "";
        }
    }

    /**
     * 下划线转驼峰 user_name  ---->  userName house.user_name  ---->  UserName userName   --->  userName
     *
     * @param table 带有下划线的名字
     * @return 驼峰字符串
     */
    private static String underlineToHump(String table, boolean first) {
        //截取下划线分成数组
        char[] charArray = table.toCharArray();
        //判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0, l = charArray.length; i < l; i++) {
            //判断当前字符是否是"_",如果跳出本次循环
            if (charArray[i] == 95) {
                underlineBefore = true;
            } else if (underlineBefore) {
                //如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(charArray[i] -= 32);
                underlineBefore = false;
            } else { //不是"_"后的字符就直接追加
                buffer.append(charArray[i]);
            }
        }
        if (first) {
            return buffer.toString();
        } else {
            return StringUtils.convertToCamelCase(buffer.toString());
        }

    }

    private static void writeFile(String path, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
