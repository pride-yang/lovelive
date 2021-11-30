package top.yang.exception;


import top.yang.spring.exception.ResultCode;

public enum SystemCode implements ResultCode {
    IMPORT_FAILURE("S0000", "导入失败"),
    TREE_CODE_IS_NOT_NULL("S0001", "树编码字段不能为空"),
    TREE_PARENT_CODE_IS_NOT_NULL("S0002", "树父编码字段不能为空"),
    TREE_NAME_IS_NOT_NULL("S0003", "树名称字段不能为空"),
    SUB_TABLE_NAME_IS_NOT_NULL("S0004", "关联子表的表名不能为空"),
    SUB_TABLE_FK_NAME_IS_NOT_NULL("S0005", "子表关联的外键名不能为空"),
    TEMPLATE_RENDERING_IS_FALL("S0006", "渲染模板失败"),

    ;
    private final String code;
    private final String message;

    SystemCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
