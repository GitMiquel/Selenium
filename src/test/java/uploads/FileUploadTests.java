package uploads;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    /**
     * Test checking the upload of a file by entering the file path into the input field directly
     * then checking the correct file has been uploaded
     */

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickUploadFile();
        uploadPage.uploadFile("/1/2/3/file");
        assertEquals(uploadPage.getUploadedFiles(), "file", "Incorrect File Upload");
    }
}