@tag
Feature: User registration
  I want to use this template validate user registration

  @tag1
  Scenario: Check New User Registration With Valid Inputs
  Given i open browser with url "http://orangehrm.qedgetech.com"
  Then i should see login page
  When i enter username as "Admin"
  And i enter password as "Qedge123!@#"
	And i click login
  Then i should see admin module
  When i goto add user page
  And i select user role as "ESS"
  And i enter employee name as "Teja Demo"
  And i enter uname as "TejaDemoe"
  And i enter pword as "Qedge!@#123"
  And i search new user created
  Then i see registered user in user list
  When i click logout
 	Then i should see login page
	When i close browser
	
	
