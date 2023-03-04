@tag
Feature: AddEmpolyee
  I want to use this template validate Add Employee

  @tag1
  Scenario: Check New Empolyee Registration With Valid Inputs
  Given i open browser with url "http://orangehrm.qedgetech.com"
  Then i should see login page
  When i enter username as "Admin"
  And i enter password as "Qedge123!@#"
	And i click login
  Then i should see admin module
  When i goto add employee page
  And i enter firstname as "Teja"
  And i enter lastname as "Demo"
  And i click save
  And i goto employee list
  And i search new employee created
  Then i see registered employee in employee list
  When i click logout
 	Then i should see login page
	When i close browser
 
  
  

