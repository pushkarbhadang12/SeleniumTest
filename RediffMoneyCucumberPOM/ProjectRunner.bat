set projectLocation=C:\Users\pushk\eclipse-workspace\RediffMoneyCucumberPOM

cd %projectLocation%

set classpath=%projectLocation%\*

java org.testng.TestNG %projectLocation%\testng.xml

pause