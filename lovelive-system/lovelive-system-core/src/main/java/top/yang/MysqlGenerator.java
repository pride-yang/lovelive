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
import lombok.SneakyThrows;
import top.yang.string.StringUtils;

/**
 * @author PrideYang
 */
public class MysqlGenerator {

    private static final String API = "lovelive-system/lovelive-system-api";
    private static final String CORE = "lovelive-system/lovelive-system-core";

    public static void main(String[] args) {

        String[] tables = new String[]{"sys_menu", "sys_menu", "sys_role", "sys_user", "sys_config", "sys_dict_data", "sys_dict_type"};
        for (String s : tables) {
            createController(s);
            createDomain(s);
            createDto(s);
            createRepository(s);
            createManager(s);
            createService(s);
            createConver(s);
            createRes(s);
        }
    }

    private static void createRes(String table) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("package top.yang.domain.entity;").append("\n");
        stringBuffer.append("import java.util.Date;" + "\n");
        stringBuffer.append("import lombok.Data;" + "\n");

        stringBuffer.append("@Data").append("\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append(" {\n\n\n");
        getFields(table, stringBuffer);
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/response/" + underlineToHump(table, false) + "Res.java",
                stringBuffer.toString());
    }

    public static void createRepository(String table) {
        String stringBuffer = "package top.yang.mapper;\n"
                + "\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import top.yang.domain.entity." + underlineToHump(table, false) + ";\n"
                + "import top.yang.repository.BaseJdbcRepository;" + ";\n"
                + "@Mapper\n"
                + "public interface " + underlineToHump(table, false) + "Repository extends BaseJdbcRepository<"
                + underlineToHump(table, false) + ", Long>{\n"
                + "\n"
                + "\n"
                + "}";
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/mapper/" + underlineToHump(table, false) + "Repository.java",
                stringBuffer);
    }


    public static void createController(String table) {

        String stringBuffer = "package top.yang.controller;\n"
                + "\n"
                + "import org.springframework.beans.BeanUtils;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Controller;\n"
                + "import org.springframework.web.bind.annotation.RequestMapping;\n"
                + "import top.yang.web.controller.BaseController;\n"
                + "@Controller\n"
                + "@RequestMapping()\n"
                + "public class " + underlineToHump(table, false) + "Controller extends BaseController {\n"
                + "\n"
                + "}";
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/controller/" + underlineToHump(table, false) + "Controller.java",
                stringBuffer);
    }

    public static void createManager(String table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package top.yang.manager;\n");
        stringBuffer.append("import top.yang.manager.").append(underlineToHump(table, false)).append("Manager;\n");
        stringBuffer.append("import top.yang.domain.entity.").append(underlineToHump(table, false)).append(";\n");
        stringBuffer.append("import top.yang.domain.dto.").append(underlineToHump(table, false)).append("Dto;\n");
        stringBuffer.append("import org.springframework.stereotype.Component;\n");

        stringBuffer.append("@Component\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("Manager {\n");
        stringBuffer.append("\n}");
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/manager/" + underlineToHump(table, false) + "ManagerImpl.java",
                stringBuffer.toString());
    }

    public static void createService(String table) {
        String stringBuffer = "package top.yang.service;\n"
                + "\n"
                + "import top.yang.domain.entity." + underlineToHump(table, false) + ";\n"
                + "import top.yang.domain.dto." + underlineToHump(table, false) + "Dto;\n"
                + "import org.springframework.beans.factory.annotation.Autowired;\n"
                + "import org.springframework.stereotype.Service;" + "\n"
                + "\n/**\n * @author PrideYang\n */"
                + "@Service\n"
                + "public class " + underlineToHump(table, false) + "Service {\n"
                + "\n"
                + "}";
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/service/" + underlineToHump(table, false) + "Service.java",
                stringBuffer);
    }

    public static void createConver(String table) {

        String stringBuffer = "package top.yang.convers;\n" + "\n" + "import java.util.List;\n" + "import org.mapstruct.Mapper;\n" + "import org.mapstruct.Mapping;\n"
                + "import org.mapstruct.factory.Mappers;\n" + "import top.yang.domain.dto.PageResult;\n" + "import top.yang.domain.dto."
                + underlineToHump(table, false)
                + "Dto;\n" + "import top.yang.domain.entity." + underlineToHump(table, false) + ";\n" + "import top.yang.response."
                + underlineToHump(table, false) + "Res;\n" + "\n" + "/**\n" + " * @author pride\n" + " */\n" + "@Mapper\n"
                + "public interface " + underlineToHump(table, false) + "Conver {\n" + "\n" + "    " + underlineToHump(table, false)
                + "Conver INSTANCE = Mappers.getMapper(" + underlineToHump(table, false) + "Conver.class);\n" + "\n" + "    "
                + underlineToHump(table, false) + "Dto entityToDto(" + underlineToHump(table, false) + " entity);\n" + "\n" + "    "
                + underlineToHump(table, false) + "Res dtoToRes(" + underlineToHump(table, false) + "Dto dto);\n" + "\n" + "    List<"
                + underlineToHump(table, false) + "Dto> entityToDtoList(List<" + underlineToHump(table, false) + "> entities);\n" + "\n"
                + "    List<" + underlineToHump(table, false) + "Res> dtoToResList(List<" + underlineToHump(table, false) + "Dto> dtos);\n"
                + "\n" + "    PageResult<" + underlineToHump(table, false) + "Dto> entityToDtoPage(PageResult<" + underlineToHump(table, false)
                + "> pageResult);\n" + "\n" + "    PageResult<" + underlineToHump(table, false) + "Res> dtoToResPage(PageResult<"
                + underlineToHump(table, false) + "Dto> pageResult);\n" + "\n" + "\n" + "}";
        writeFile(System.getProperty("user.dir") + File.separator + CORE + "/src/main/java/top/yang/conver/" + underlineToHump(table, false) + "Conver.java",
                stringBuffer);
    }

    public static void createDomain(String table) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("package top.yang.domain.entity;").append("\n");
        stringBuffer.append("import java.util.Date;" + "\n");
        stringBuffer.append("import lombok.Data;" + "\n");
        stringBuffer.append("import org.springframework.data.annotation.Id;" + "\n");
        stringBuffer.append("import org.springframework.data.relational.core.mapping.Table;" + "\n");
        stringBuffer.append("import top.yang.domain.pojo.BaseEntity;" + "\n");

        stringBuffer.append("@Data\n@Table(\"").append(table).append("\")\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append(" extends BaseEntity {\n\n\n");
        getFields(table, stringBuffer);
        writeFile(System.getProperty("user.dir") + File.separator + API + "/src/main/java/top/yang/domain/entity/" + underlineToHump(table, false) + ".java",
                stringBuffer.toString());
    }

    private static void getFields(String table, StringBuilder stringBuffer) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/love_system", "root", "yzh19981204mysql");
            Statement statement = connection.createStatement();
            String s = "select column_name,data_type,column_comment,column_key  from information_schema.columns where table_schema= 'love_system' and table_name= \'" + table
                    + "\' ;";
            ResultSet resultSet = statement.executeQuery(
                    s);
            System.out.println(s);
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
                stringBuffer.append("  **/\n");
                if ("PRI".equals(columnKey)) {
                    stringBuffer.append("  @Id\n");
                }
                stringBuffer.append("  private ").append(getFieldType(dataType)).append(" ").append(underlineToHump(columnName, true)).append(";\n");
            }
            stringBuffer.append("}");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createDto(String table) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("package top.yang.domain.dto").append(";\n");
        stringBuffer.append("import java.util.Date;" + "\n");
        stringBuffer.append("import lombok.Data;" + "\n");
        stringBuffer.append("@Data\n");
        stringBuffer.append("public class ").append(underlineToHump(table, false)).append("Dto extends BaseDto {\n\n\n");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/love_system", "root", "yzh19981204mysql");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select column_name,data_type,column_comment,column_key  from information_schema.columns where table_schema= 'love_system' and table_name= \'" + table
                            + "\' ;");

            while (resultSet.next()) {
                String columnName = resultSet.getString("column_name");
                String dataType = resultSet.getString("data_type");
                String columnComment = resultSet.getString("column_comment");
                if (StringUtils.equalsAnyIgnoreCase(columnName, "create_time", "update_time")) {
                    continue;
                }
                stringBuffer.append("  /**\n");
                stringBuffer.append("   * ").append(columnComment).append("\n");
                stringBuffer.append("  **/\n");
                stringBuffer.append("  private ").append(getFieldType(dataType)).append(" ").append(underlineToHump(columnName, true)).append(";\n");
            }
            stringBuffer.append("}");
            writeFile(System.getProperty("user.dir") + File.separator + API + "/src/main/java/top/yang/domain/dto/" + underlineToHump(table, false) + "Dto.java",
                    stringBuffer.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    private static String getFieldType(String fieldType) {
        if (StringUtils.equalsAnyIgnoreCase(fieldType, "char", "varchar", "longtext", "text")) {
            return "String";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "int")) {
            return "Integer";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "bigint")) {
            return "Long";
        } else if (StringUtils.equalsAnyIgnoreCase(fieldType, "datetime", "date", "timestamp")) {
            return "LocalDateTime";
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

    @SneakyThrows
    private static void writeFile(String path, String content) {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
