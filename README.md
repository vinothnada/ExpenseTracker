# ExpenseTracker
The expense tracking and budgeting application.

## Features 
- Allow a user to see a list of recent transactions 
- Allow a user to enter a new transaction. At a minimum, this should include the amount, whether it is an income or expense transaction, and which category it falls under. A more advanced application will allow the user to enter a note and to specify whether it is recurring) 
- Allow the user to edit/delete transactions 
- Allow the user to see a list of categories. The application should come with some preset categories. An advanced application will allow the user to add new categories. 
- Allow the user to enter a budget, specifying amounts for each category. 
- Allow the user to track their progress against their budget by seeing how much they have spent in each category against the budget for that category, as well as overall spending against the overall budget.


## How to start
First, install maven dependencies
```shell
mvn install
```
You can run unit tests
```shell
mvn test
```
Then you can create the executable App JAR file
```shell
mvn compile
mvn package
```
## Reports
To generate unit test and coverage report
```shell
mvn test
```
also, you can get a vulnerability and static code analysis using the following command. This project uses JCoCo for code coverage, owasp dependency check and maven-pmd for static code analysis. 
```shell
mvn verify
```

## Contributors
- @ipmanlk Navinda Dissanayake
- @vinothnada Vinothan Nadarajah
- @asirihewage Asiri Hewage

## How to contribute
We welcome your contributions to enhance the product features. 
Please fork the project and make pull requests.

## Change Log
**v0.0.1** : Initial version

**v1.0.0** : First stable release

## License
MIT