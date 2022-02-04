# UIAutomationWithTestNG
#base : set the driver and application property file in this package
@pages : Identify all web elements in Page Factory Model\
@tests: All Tests Class are written here and BaseTest Class is used Set Up the BeforeClass, Before Method and AfterClass and AfterMethod and this class will be extends with Test Class
@datautil: Having Classes for get the Data
@extentsreports: Having Classes for extents related
@listeners: Having Classes for TestNG listeners and retry concepts
@logs: Having Classes for Log4J methods
@uiactions: Having Classes for Actions for Webelements

@data: Store Test Data
@application.properties : Set the URL and Browser here to driver the automation
@TestNG.xml: To run test we can use this file and need to configure every Test Class and Test Groups in this file only