import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open browser
WebUI.openBrowser('')

// Navigate to the URL
WebUI.navigateToUrl('https://rctiplus.com')

// Maximize the browser window
WebUI.maximizeWindow()

// Click Login button in the Homepage
WebUI.click(findTestObject('Homepage/btn_Login'))

// Input with an unregistered account or using unregistered email
WebUI.setText(findTestObject('Login/textfield_Email'), 'yogatito17@gmail.co.id')
String encryptedPassword = 'vcg/h+Ha/2s80g94S8eTfg=='
WebUI.setEncryptedText(findTestObject('Login/textfield_Password'), encryptedPassword)

// Click Login button
WebUI.click(findTestObject('Login/btn_Login'))

// Verify login the account has been successful
if (WebUI.verifyElementPresent(findTestObject('Homepage/name_userlogin'), 5, FailureHandling.OPTIONAL)) {
	System.out.println('Login Successful')
} else {
	System.out.println('Login Failed')
	String errorMessage = WebUI.getText(findTestObject('Login/txt_LoginErrorMessage'))
	System.out.println(errorMessage)
}