package com.aoher;

import com.aoher.bean.EnterpriseJavaBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class ArquillianTest {

    @EJB
    private EnterpriseJavaBean enterpriseJavaBean;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(EnterpriseJavaBean.class);
    }

    @Test
    public void plainThreadTest() {
        for (int i = 0; i < 10; i++) {
            enterpriseJavaBean.writeToConsole();
        }

        System.out.println("All Done");
    }
}
