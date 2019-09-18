package cn.shutdown.rulesHello;

import cn.shutdown.pojo.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesHello {
    public static void main(String[] args) {
        KieServices kss = KieServices.get();
        KieContainer kc = kss.getKieClasspathContainer();
        //是从kmodule.xml中取的 session
        KieSession ks = kc.newKieSession("testhelloworld");
        Person p = new Person();
        p.setName("小明");
        p.setAge("18");
        ks.insert(p);
        int count = ks.fireAllRules();
        System.out.println("共执行了" + count + "条规则");
        System.out.println(p);
        ks.dispose();
    }
}
