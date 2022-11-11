# cst-339
CLC Repository for CST-339

Within the CLCWorkspace, the CLC Marketplace Springboot Web App project exists.

The project uses Spring Web, Spring MVC, Spring Framework, and Thymeleaf templates.

The following files serve the current purpose:

-   HomeController.java, a homepage controller that accepts GET requests at localhost:8080/ and presents the homepage

-   ShirtModel.java, a model with a constructer that allows for "shirt" objects to be created with a size, color, and stock

-   clc-logo.png, a logo file for "The CLC Marketplace" which is a placeholder name that we can keep or change as a group

-   home.html, the HTML view for the homepage that includes a table of shirts in the "shirts" table, a header title, and fragments from the Thymeleaf templates

-   common.html, a Common thymeleaf template with fragments that can be shared between pages like the navbar, logo, copyright footer, and site header

-   defaultTemplate.html, a default template to be applied to pages that do not override the Header and Footer Thymeleaf fragements