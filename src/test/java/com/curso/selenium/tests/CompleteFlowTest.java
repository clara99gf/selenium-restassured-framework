package com.curso.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.curso.selenium.listeners.TestListener;
import com.curso.selenium.pages.AdminPage;
import com.curso.selenium.pages.DashboardPage;
import com.curso.selenium.pages.LeavePage;
import com.curso.selenium.pages.LoginPage;
import com.curso.selenium.pages.MyInfoPage;
import com.curso.selenium.utils.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestListener.class)
public class CompleteFlowTest {

    @BeforeEach
    public void setup(){
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testFullNavigation(){
        LoginPage login = new LoginPage();
        DashboardPage dashboard = login.loginAs("Admin", "admin123");

        AdminPage admin = dashboard.goToAdmin();
        assertTrue(admin.isAt(),"No se encuentra en la página de Admin");

        MyInfoPage myInfo = dashboard.goToMyInfo();
        assertTrue(myInfo.isAt(),"No se encuentra en la página de My Info");

        LeavePage leave = dashboard.goToLeave();
        assertTrue(leave.isAt(),"No se encuentra en la página de Leave");
    }


    @AfterEach
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
