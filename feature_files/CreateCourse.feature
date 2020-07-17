
@CreateCourse
Feature: This feauture to automate admin to create course
  I want to use this template for my feature file

  @CreateCourseCheck
  Scenario: To verify whether application allows admin to create course
    Given I launch the application
    Then I enter my username and password
    Then I click the create a course link
    Then Enter valid credential in Title textbox
    Then Enter valid credential in  code textbox
    Then Select Valid credentials from Category list box
    Then Select Valid credentials in Teacher list box
    And Click on Create a course button

  
	@CreateClassCheck
	Scenario: To verify whether application allows admin to create class
    Given I launch the application
    Then I enter my username and password
    Then I click the create a class link
    Then I click on Add classes icon
    Then Enter valid credentials in Name textbox
    Then Enter valid credentials in Description textbox
    Then Select valid credentials in Group permissions list box
    And Click on Add button