# Appium Automation for SwagLabs Mobile App

## Test Scenario

| Scenario Name | Test Scenario ID| Test Scenario Description |
| :---: | :---: | :---: |
| Login | TS-001 | As a user, I should be able to login using valid username and valid password | 
| Login | TS-002 | As a user, I should not be able to login using valid username and invalid password | 
| Sorting | TS-003 | As a user, I should be able to choose price low to high | 
| Checkout | TS-004| As a user, I should be able to order and checkout multiple products | 

## Pre-requisites
+ [Intellij Idea 2023.2.1](https://www.jetbrains.com/idea/download/other.html)
+ [Java SE Development Kit 20.0.1](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
    - JAVA_HOME
      
      Add a new system variabel:
      
      <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/85f012a5-dca6-459b-b078-ee8ce9563a59">
      <br>
      <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/d5c12c42-3ee1-4106-aaf9-97ab961fcbd0">
      
+ [Android Studio 2023.1.1.26](https://developer.android.com/studio?gclid=CjwKCAiAhJWsBhAaEiwAmrNyq9Uf5oAJCJ7Ve6C5cG5kYlfItd8GFkkI_2dd0c5XCxdCvRgmF8tP3BoCet0QAvD_BwE&gclsrc=aw.ds)
  - ANDROID_HOME
    
     Add a new system variabel:
    
    <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/85f012a5-dca6-459b-b078-ee8ce9563a59">
    <br>
    <img width="464" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/1e0b71fc-3782-4645-887b-f43210ee6bcf">

  - Platform Tools
    
    Add the platform-tools path to the system’s Path variable:
    
    <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/4991914a-13de-440e-a1ef-082fb812702f">
    <br>
    <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/86b7baaf-9228-48bb-8504-d309d22ae826">

+ [Node.js 18.18.0](https://nodejs.org/en/download)
+ npm 9.8.1
  ```powershell
  npm install -g npm
  ```
  Add the npm path to the system’s Path variable:

  <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/4991914a-13de-440e-a1ef-082fb812702f">
  <br>
  <img width="463" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/e18fa69b-978a-4cad-822b-3f5512e83426">

+ Appium 2.2.3
  ```powershell
  npm i --location=global appium
  ```
+ UIAutomator2 Driver for Android
  ```powershell
  appium driver install uiautomator2
  ```
+ Appium Doctor
  ```powershell
  npm install appium-doctor -g
  ```
 
  ```powershell
  Appium-doctor
  ```
+ [SwagLabs.apk](https://drive.google.com/file/d/1YGxFAW0c1bZiZ3PbXhyPvjJFnSB0ZUkq/view)

## Dependencies

+ [Java Client](https://mvnrepository.com/artifact/io.appium/java-client)

    ```powershell
  <dependency>
      <groupId>io.appium</groupId>
      <artifactId>java-client</artifactId>
      <version>9.0.0</version>
  </dependency>
  ```
+ [TestNG](https://mvnrepository.com/artifact/org.testng/testng) for Test Runner
  ```powershell
  <dependency>
      <groupId>org.testng</groupId>
      <artifactId>testng</artifactId>
      <version>7.8.0</version>
      <scope>test</scope>
  </dependency>
  ```
+ [Cucumber Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
  ```powershell
  <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>7.14.1</version>
  </dependency>
  ```
+ [Cucumber TestNG](https://mvnrepository.com/artifact/io.cucumber/cucumber-testng)
  ```powershell
  <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-testng</artifactId>
      <version>7.14.1</version>
  </dependency>
  ```
+ [ExtentReports Cucumber7 Adapter](https://mvnrepository.com/artifact/tech.grasshopper/extentreports-cucumber7-adapter)
  ```powershell
  <dependency>
      <groupId>tech.grasshopper</groupId>
      <artifactId>extentreports-cucumber7-adapter</artifactId>
      <version>1.14.0</version>
  </dependency>
  ```
+ [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
  ```powershell
  <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>4.15.0</version>
  </dependency>
  ```
+ [Selenium API](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-api)
  ```powershell
  <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-api</artifactId>
      <version>4.16.1</version>
      <scope>test</scope>
  </dependency>
  ```
  
## Runner The Tests
<img width="751" alt="image" src="https://github.com/pitears/swaglabs-appium-mobile-automation/assets/125880337/9a099741-4bd8-467f-9c5b-dd06ced6d534">

Here's a brief explanation of each attribute:

+ features: Specifies the path to the directory or file where your feature files are located.
+ glue: Defines the package where your step definitions (StepDef classes) are located.
+ tags: Allows you to run scenarios that are tagged with specific tags. If empty, all scenarios will be considered. For specific features, use tags like @login, @checkout, or @sorting.
+ plugin: Specifies the reporting formats or plugins to generate different types of reports. In this example:
  - "pretty": Prints the output in a human-readable format to the console.
  - "html:reports/cucumber-result/cucumber-reports.html": Generates an HTML report at the specified location.
  - "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:": Integrates with ExtentReports for enhanced reporting.
  - "json:reports/cucumber-result/cucumber-reports.json": Generates a JSON format report.
  - monochrome: When set to true, it makes the console output more readable (removes unnecessary characters).
