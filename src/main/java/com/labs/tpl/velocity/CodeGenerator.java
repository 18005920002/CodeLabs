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
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public void initVelocity() throws Exception{
        //Velocity.init();
        VelocityContext context = getContext();
        Template template = null;
        try
        {
            template = Velocity.getTemplate("sql.vm");
        }
        catch( ResourceNotFoundException rnfe )
        {
            // couldn't find the template
        }
        catch( ParseErrorException pee )
        {
            // syntax error: problem parsing the template
        }
        catch( MethodInvocationException mie )
        {
            // something invoked in the template
            // threw an exception
        }
        catch( Exception e )
        {}


        //System.out.println(sw.getBuffer().toString());
    }

    public static VelocityContext getContext() {
        return null;
    }



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

    public static void main(String[] args) throws Exception{

        Properties properties = new Properties();
        properties.load(CodeGenerator.class.getClassLoader().getResourceAsStream("code_engine.properties"));
        EngineConfig config = new EngineConfig();
        config.setTplLocation((String)properties.get("tpl.location"));
        config.setCodeLocation((String)properties.get("code.location"));

        Properties p = new Properties();
        p.setProperty("resource.loader.file.path", config.getTplLocation());
        p.setProperty("input.encoding","UTF-8");
        p.setProperty("output.encoding","UTF-8");
        Velocity v = new Velocity();
        v.init(p);

        final String AUTHOR=(String)properties.get("author");
        final String DAO_TEMPLATE_NAME="dao.vm";
        final String SERVICE_TEMPLATE_NAME="service.vm";

        final String ENTITY_NAME = "ShopCheckTask";
        final String ENTITY_COMMENT = "门店盘点任务";

        CodeGenerator eng = new CodeGenerator(v);

        CodeMeta codeMeta = new CodeMeta();
        codeMeta.setAuthor(AUTHOR);
        codeMeta.setTplName(DAO_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        eng.getCodeText(config,codeMeta,"Dao.java");

        codeMeta.setTplName(SERVICE_TEMPLATE_NAME);
        codeMeta.setUpperCamelEntity(ENTITY_NAME);
        codeMeta.setEntityCommnet(ENTITY_COMMENT);
        eng.getCodeText(config,codeMeta,"Service.java");
    }
}
