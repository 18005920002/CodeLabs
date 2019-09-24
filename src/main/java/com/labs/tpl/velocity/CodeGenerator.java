package com.labs.tpl.velocity;

import com.google.common.base.CaseFormat;
import com.labs.common.util.DateUtils;
import com.labs.dictionary.dao.DictionaryDao;
import com.labs.dictionary.vo.CodeMeta;
import com.labs.dictionary.vo.ColumnVO;
import com.labs.dictionary.vo.EngineConfig;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 代码生成器
 *
 * @author tanyun.zheng
 * @version v1.0 2019/4/26 13:30
 */
public class CodeGenerator {

    private Velocity v;

    public CodeGenerator(Velocity v){
        this.v = v;
    }

    /**
     * 生成类文件
     */
    public void getCodeText(EngineConfig config,CodeMeta codeMeta,String suffix){
        Template template = null;
        try
        {
            template = Velocity.getTemplate(codeMeta.getTplName());
            VelocityContext context = new VelocityContext();
            codeMeta.setCreateTime(DateUtils.formatDate(new Date(),"yyyy/MM/dd HH:mm"));
            codeMeta.setLowerCamelEntity(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,codeMeta.getUpperCamelEntity()));
            context.put("meta",codeMeta);
            FileWriter fw = new FileWriter(config.getCodeLocation()+"/"+codeMeta.getUpperCamelEntity()+suffix);
            template.merge(context, fw );
            fw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getSQLMapper(EngineConfig config,CodeMeta codeMeta,String suffix){
        Template template = null;
        try
        {
            template = Velocity.getTemplate(codeMeta.getTplName());
            VelocityContext context = new VelocityContext();
            codeMeta.setCreateTime(DateUtils.formatDate(new Date(),"yyyy/MM/dd HH:mm"));
            codeMeta.setLowerCamelEntity(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,codeMeta.getUpperCamelEntity()));
            context.put("meta",codeMeta);

            List<ColumnVO> columns = getColums(codeMeta.getTableName());
            String namespace = codeMeta.getUpperCamelEntity()+"Dao";
            String insertText = getInsertText(columns,codeMeta.getTableName());
            String selectText = getSelectText(columns,codeMeta.getTableName());
            String selectOneText = getSelectOneText(columns,codeMeta.getTableName());
            String updateText = getUpdateText(columns,codeMeta.getTableName());
            String deleteOneText = getDeleteOneText(columns,codeMeta.getTableName());
            context.put("namespace",namespace);
            context.put("selectText",selectText);
            context.put("selectOneText",selectOneText);
            context.put("insertText",insertText);
            context.put("updateText",updateText);
            context.put("deleteOneText",deleteOneText);


            FileWriter fw = new FileWriter(config.getCodeLocation()+"/"+codeMeta.getTableName()+suffix);
            template.merge(context, fw );
            fw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getEntityClass(EngineConfig config,CodeMeta codeMeta,String suffix){
        Template template = null;
        try
        {
            template = Velocity.getTemplate(codeMeta.getTplName());
            VelocityContext context = new VelocityContext();
            codeMeta.setCreateTime(DateUtils.formatDate(new Date(),"yyyy/MM/dd HH:mm"));
            codeMeta.setLowerCamelEntity(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,codeMeta.getUpperCamelEntity()));

            List<ColumnVO> columns = getColums(codeMeta.getTableName());
            String entityCodeText = getEntityText(columns,codeMeta.getTableName());
            context.put("meta",codeMeta);
            context.put("entityCodeText",entityCodeText);

            FileWriter fw = new FileWriter(config.getCodeLocation()+"/"+codeMeta.getUpperCamelEntity()+suffix);
            template.merge(context, fw );
            fw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getConvertClass(EngineConfig config,CodeMeta codeMeta,String suffix){
        Template template = null;
        try
        {
            template = Velocity.getTemplate(codeMeta.getTplName());
            VelocityContext context = new VelocityContext();
            codeMeta.setCreateTime(DateUtils.formatDate(new Date(),"yyyy/MM/dd HH:mm"));
            codeMeta.setLowerCamelEntity(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,codeMeta.getUpperCamelEntity()));

            List<ColumnVO> columns = getColums(codeMeta.getTableName());
            String convertText = beanCopy(columns,codeMeta.getUpperCamelEntity(),codeMeta.getUpperCamelEntity()+"DTO");
            context.put("meta",codeMeta);
            context.put("convertText",convertText);

            FileWriter fw = new FileWriter(config.getCodeLocation()+"/"+codeMeta.getUpperCamelEntity()+suffix);
            template.merge(context, fw );
            fw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ColumnVO> getColums(String tableName) {
        DictionaryDao dictionaryDao = new DictionaryDao();
        List<ColumnVO> columns =  dictionaryDao.getColumns(tableName);
        return columns;
    }

    public String getSelectText(List<ColumnVO> columns,String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT \n");
        int len = columns.size();
        for(int i=0;i<len;i++){
            buffer.append("    ").append(columns.get(i).getColumnName()).append(" as ");
            String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columns.get(i).getColumnName());
            buffer.append(colName);
            if(i!=len-1){
                buffer.append(",\n");
            }
        }
        buffer.append(" \nFROM ").append(tableName).append(" \nWHERE 1=1");

        for(int i=0;i<len;i++){
            String columnName = columns.get(i).getColumnName();
            String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columnName);
            buffer.append("    \n<isNotEmpty prepend=\"AND\" property=\"").append(fieldName).append("\">\n").append(columnName).append("=");

            buffer.append("#").append(fieldName).append("#\n</isNotEmpty>");
        }
        return buffer.toString();
    }

    public String getSelectOneText(List<ColumnVO> columns,String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT \n");
        int len = columns.size();
        for(int i=0;i<len;i++){
            buffer.append("    ").append(columns.get(i).getColumnName()).append(" as ");
            String colName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columns.get(i).getColumnName());
            buffer.append(colName);
            if(i!=len-1){
                buffer.append(",\n");
            }
        }
        buffer.append(" \nFROM ").append(tableName).append(" \nWHERE id=#id#\n");
        return buffer.toString();
    }

    public String getEntityText(List<ColumnVO> columns,String tableName) {
        String className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,tableName);
        StringBuffer buffer = new StringBuffer("");
        int len = columns.size();
        for(int i=0;i<len;i++){

            ColumnVO col = columns.get(i);
            String comments = col.getColumnComment();
            String colName = col.getColumnName();
            String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,colName);
            String dataType = getType(col.getDataType());

            buffer.append("/**\n").append(" * ").append(columns.get(i).getColumnComment()).append("\n */\n");
            buffer.append("private ").append(dataType).append(" ").append(fieldName).append(";\n");
        }
        return buffer.toString();
    }

    public String getUpdateText(List<ColumnVO> columns,String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("UPDATE ").append(tableName).append(" \nSET ");
        int len = columns.size();

        for(int i=0;i<len;i++){
            String columnName = columns.get(i).getColumnName();
            String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columnName);
            buffer.append("    ").append(columnName).append("=")
                    .append("#").append(fieldName).append("#");
            if(i!=len-1){
                buffer.append(",\n");
            }
        }
        buffer.append(" \nWHERE id=#id#");
        return buffer.toString();
    }

    public String getDeleteOneText(List<ColumnVO> columns,String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("DELETE FROM  ").append(tableName).append(" \n WHERE id=#id# ");
        return buffer.toString();
    }

    public String getInsertText(List<ColumnVO> columns,String tableName) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("INSERT INTO ").append(tableName).append("\n(\n");
        int len = columns.size();
        for(int i=0;i<len;i++){
            buffer.append("    ").append(columns.get(i).getColumnName());
            if(i!=len-1){
                buffer.append(",\n");
            }

        }
        buffer.append("\n) VALUES (\n");

        for(int i=0;i<len;i++){
            String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columns.get(i).getColumnName());
            buffer.append("    ").append("#").append(fieldName).append("#");
            if(i!=len-1){
                buffer.append(",\n");
            }
        }
        buffer.append("\n)\n");
        buffer.append("<selectKey keyProperty=\"id\" resultClass=\"long\">\n" +
                "            SELECT LAST_INSERT_ID() AS id\n" +
                "        </selectKey>");
        return buffer.toString();
    }



    /**
     * 值拷贝
     * @return
     */
    public String beanCopy(List<ColumnVO> columns,String fromType,String toType){
        //实体-->DTO
        StringBuffer buffer = new StringBuffer("public void xxx2Xxx (").append(fromType)
                .append(" s,").append(toType).append(" d){\n");
        int len = columns.size();
        for(int i=0;i<len;i++){
            String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,columns.get(i).getColumnName());
            String upperFieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,columns.get(i).getColumnName());
            buffer.append("    ")
                    .append("d.set").append(upperFieldName).append("(s.get").append(upperFieldName)
                    .append("());\n");
        }
        buffer.append("}\n");
        return buffer.toString();
    }

    /**
     * 数据类型映射
     * @param type
     * @return
     */
    private String getType(String type){
        /**
         * bigint
         * varchar
         * smallint
         * datetime
         * int
         * tinyint
         * text
         * timestamp
         * decimal
         * date
         * char
         */
        String returnType="";

        if(type.equalsIgnoreCase("bigint")){
            returnType = "Long";
        }
        if(type.equalsIgnoreCase("varchar") || type.equalsIgnoreCase("text")){
            returnType = "String";
        }
        if(type.equalsIgnoreCase("smallint") || type.equalsIgnoreCase("int")){
            returnType = "Integer";
        }
        if(type.equalsIgnoreCase("datetime") || type.equalsIgnoreCase("timestamp") ||type.equalsIgnoreCase("date")){
            returnType = "Date";
        }
        if(type.equalsIgnoreCase("tinyint") || type.equalsIgnoreCase("char")){
            returnType = "Byte";
        }
        if(type.equalsIgnoreCase("decimal")){
            returnType = "BigDecimal";
        }
        return returnType;
    }

    public static void main(String[] args) throws Exception{

        Properties properties = new Properties();
        properties.load(CodeGenerator.class.getClassLoader().getResourceAsStream("code_engine.properties"));
        EngineConfig config = new EngineConfig();
        config.setTplLocation((String)properties.get("tpl.location"));
        config.setCodeLocation((String)properties.get("code.location"));

        Properties p = new Properties();
        p.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        p.setProperty("input.encoding","UTF-8");
        p.setProperty("output.encoding","UTF-8");
        Velocity v = new Velocity();
        v.init(p);

        final String AUTHOR=(String)properties.get("author");
        final String DAO_TEMPLATE_NAME="tpls/dao.vm";
        final String SERVICE_TEMPLATE_NAME="tpls/service.vm";
        final String CONTROLLER_TEMPLATE_NAME="tpls/controller.vm";
        final String SQL_MAPPER_TEMPLATE_NAME="tpls/mapper.vm";
        final String ENTITY_TEMPLATE_NAME="tpls/entity.vm";
        final String CONVERTER_TEMPLATE_NAME="tpls/converter.vm";


        final String TABLE_NAME = "t_shop_assets_order_item";
        final String ENTITY_NAME = "ShopAssetsOrderItem";
        final String ENTITY_COMMENT = "门店资产申请单明细";
        final String PACKAGE_NAME = "com.lucky.stock.order.assets";

        CodeGenerator eng = new CodeGenerator(v);
        //生成Dao模板
        CodeMeta codeMeta = new CodeMeta();
        codeMeta.setAuthor(AUTHOR);
        codeMeta.setTplName(DAO_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setPackageName(PACKAGE_NAME);
        eng.getCodeText(config,codeMeta,"Dao.java");

        //生成服务接口
        codeMeta.setTplName(SERVICE_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setEntityCommnet(ENTITY_COMMENT);
        codeMeta.setPackageName(PACKAGE_NAME);
        eng.getCodeText(config,codeMeta,"Service.java");

        //生成Controller
        codeMeta.setTplName(CONTROLLER_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setEntityCommnet(ENTITY_COMMENT);
        codeMeta.setPackageName(PACKAGE_NAME);
        eng.getCodeText(config,codeMeta,"Controller.java");

        //生成SQL Mapper
        codeMeta.setTplName(SQL_MAPPER_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setTableName(TABLE_NAME);
        //codeMeta.setEntityCommnet(ENTITY_COMMENT);
        eng.getSQLMapper(config,codeMeta,"_sql.xml");

        //生成实体类
        codeMeta.setTplName(ENTITY_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setEntityCommnet(ENTITY_COMMENT);
        codeMeta.setTableName(TABLE_NAME);
        codeMeta.setPackageName(PACKAGE_NAME);
        eng.getEntityClass(config,codeMeta,".java");

        //生成值拷贝类
        codeMeta.setTplName(CONVERTER_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setEntityCommnet(ENTITY_COMMENT);
        codeMeta.setTableName(TABLE_NAME);
        codeMeta.setPackageName(PACKAGE_NAME);
        eng.getConvertClass(config,codeMeta,"Converter.java");


    }
}
