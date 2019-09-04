package vip.wicp.ruhome;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MPGenerator {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setIdType(IdType.UUID);
        gc.setOutputDir("src/main/java");
        gc.setFileOverride(true); //是否覆盖，默认false
        gc.setOpen(false); //是否打开输出目录，默认true
        gc.setAuthor("pengyu");
        gc.setBaseColumnList(true);//默认false
        gc.setBaseResultMap(true); // 默认false
        generator.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/ruhome?useSSL=false&serverTimezone=Asia/Shanghai");
        dsc.setUsername("root");
        dsc.setPassword("root");
        generator.setDataSource(dsc);


        // 包名配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("vip.wicp.ruhome.system");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setXml("mapper/xml");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        generator.setPackageInfo(pc);


        // 表策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("biz_article");
        strategy.setSkipView(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
//        strategy.setSuperEntityClass(BaseEntity.class) ; // 生成的实体要继承的类
        strategy.setTablePrefix("biz_"); // 指定表前缀后，生成的实体不会带该前缀
        generator.setStrategy(strategy);



        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
         String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return "mapper/xml/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        generator.setCfg(cfg);


        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null); // 设置为null，表示不生成controller
//        templateConfig.setEntity(null);
//        templateConfig.setMapper(null);
//        templateConfig.setXml(null);
//        templateConfig.setService(null);
//        templateConfig.setServiceImpl(null);
        generator.setTemplate(templateConfig);


        generator.execute();










    }

}

