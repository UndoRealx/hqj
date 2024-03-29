package com.hqjcloud.upms.main;

import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;

import java.util.List;

/**
 * @ProjectName: hqjcloud
 * @Package: com.hqjcloud.upms.main
 * @ClassName: PaginationPlugin
 * @Description:
 * @Author: lic
 * @CreateDate: 2019/10/15 14:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/15 14:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class PaginationPlugin extends PluginAdapter {

    /**
     * Validate boolean.
     *
     * @param warnings the warnings
     *
     * @return the boolean
     */
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    private static void generate() {
        System.out.println("开始生成表结构...");
        String config = PaginationPlugin.class.getClassLoader().getResource("generator/generatorConfig-B.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
        System.out.println("生成表结构成功...");
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        generate();
    }
}