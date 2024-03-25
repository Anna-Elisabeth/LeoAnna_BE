# Dolphinity - Open Source React.js Accessible E-Commerce Application

## Description

This project is build on top of Open Source code, this repository contains our Back-End code and is built on https://github.com/Craigm84/Everest_BE.

For end-to-end functionality, please also refer to our Front-End repository https://github.com/Anna-Elisabeth/LeoAnna_FE, which is built on https://github.com/Liliano-Balde/Everest_FE.

The project remit is to fix bugs, find/make improvements and add features.

### Key Features
- Minor Improvements:
  - Basket totals fixed to two decimal places
  - Fixed item update bug, where description update field refered to item name input field
  - Checkout page added
  - Addressed minor errors flagged in console
  - Updated component name conventions for consistency

- Major Improvements:
  - Refactored SQL schema and data
  - Robust Testing in line with industry standards   
  - Improved login functionality
  - Admin and basket interfaces updated for better organisation
 
- New Features:
  - Accessibility:
    - Aria and HTML5 landmarks applied
    - Utilisation of `react-axe`
    - [Utilisation of Microsoft Accessibility Insights Edge Extension](https://microsoftedge.microsoft.com/addons/detail/accessibility-insights-fo/ghbhpcookfemncgoinjblecnilppimih)
    - [Utilisation of Microsoft Accessibility Insights for Windows Software](https://accessibilityinsights.io/downloads/)
    - Implementation of industry standard accessible font Verdana (sans serif)
    - Rebranding and revamp of styling to meet industry accessibility standards, and to make accessibility the focus of our application

### Contribuitions and Ongoing Development
  This project remains Open Source and all contribuitions/suggestions are welcome, with a focus on:
  - Working towards WCAG 2.1 Level AA standard
  - Improve user authentication
  - Search bar functionality
  - Full separation between user types (different users have their respective logins and baskets)
  - Mobile friendly features
  To contribute, please note, our preferred workflow is the fork-pull request model.

### Current Contributors
  - https://github.com/Anna-Elisabeth
  - https://github.com/Liliano-Balde

### Getting Started
  - Back-End Prerequisites:
    - Relational database management system (e.g. MySql, H2)
    - IDE (e.g. Eclipse, IntelliJ IDEA)
    - Spring Boot
    - Maven dependencies:
      - Springdoc OpenAPI Starter for Spring Web MVC (SWagger)
      - Selenium Java
      - Spring Boot Starter Data JPA
      - Spring Boot Starter Validation
      - Spring Boot Starter Test
      - H2 Database
      - MySQL Connector Java
      - Spring Boot DevTools  



