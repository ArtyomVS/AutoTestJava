package lesson6.PageObjectByCrm;

public class iFrameTest extends BaseTest {
    public void writeFrame() {
        createNewProjectPage.iFrame("//iframe[contains(@id, 'planning')]");
        createNewProjectPage.iFrame("//iframe[contains(@id, 'requirementsManagement')]");
        createNewProjectPage.iFrame("//iframe[contains(@id, 'development')]");
        createNewProjectPage.iFrame("//iframe[contains(@id, 'testing')");
    }
}
