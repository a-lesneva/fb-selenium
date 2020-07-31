# fb-selenium

1. Tests for login page are located in "fb/src/facebook/login.java" class
2. The tests are running using Chrome Version 84.0.4147.105 only (as an assumption)
3. I have included ChromeDriver 83.0.4103.39 to the folder to make it easier and not to worry about chromedriver path
4. I was using in-built Eclipse test runner to run the only test file. 
   I think a better way to support scalability is to use maven and run the tests via command line.

Not inlcuded in the repository:
4. External JARs files should be added manually. I took them for Java from here: https://www.selenium.dev/downloads/
5. I was using Eclipse and had to add TestNG library manually via 'Install New Software' option.
