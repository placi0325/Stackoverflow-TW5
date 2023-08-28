
<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
<div>
<h3 align="center">:ocean:Stackoverflow:ocean:</h3>

  <p align="center">
    This is a full stack project with Java Spring Boot backend and Thymeleaf frontend. The theme is a web application similar to Stackoverflow.
    <br />
    <br />
    ·
    <a href="https://github.com/placi0325/Stackoverflow-TW5/issues">Report Bug :lady_beetle:</a>
    ·
    <a href="https://github.com/placi0325/Stackoverflow-TW5/issues">Request Feature :memo:</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a full stack project with Java Spring Boot backend and Thymeleaf frontend. We created a web application similar to Stackoverflow.
During development we implemented CRUD, database communication/manipulation and basic sign up/log in features.

<p align="right">(<a href="#readme-top">:top:</a>)</p>



### Built With

* [![ThymeLeaf][ThymeLeaf.img]][ThymeLeaf-url]
* [![Spring Boot][SpringBoot.img]][SpringBoot-url]
* [![Postgres][Postgres.img]][Postgres-url]

<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

Please see the core dependencies and installation steps below:

### Prerequisites
1. JAVA
2. MAVEN
3. INTELLIJ
4. POSTGRES SQL


### Installation
1. Clone the repo
   ```sh
   git clone https://github.com/placi0325/Stackoverflow-TW5.git
   ```
2. Install Java version 17 or higher

3. Install Apache Maven or IDE with built-in Maven support
4. Install an integrated development environment(IDE) - IntelliJ IDEA
5. Install PostgreSQL
6. Create a database in PostgreSQL
7. Open the project in IntelliJ from the pom.xml file :open_file_folder:
8. Set the database name, username and password as environment variables as follows: <br>
      :white_check_mark: DATABASE_NAME=_your database name_<br>
      :white_check_mark: DATABASE_USERNAME=_your username_<br>
      :white_check_mark: DATABASE_PASSWORD=_your password_<br>
9. Run the application by the "Run" button in the top right corner or with Shift + F10 shortcut
10. This will start the project which you can reach in your browser, on the following URL: http://localhost:8080/


<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage
 1. Main page listing all questions with details, date and answer count
 2. Feature to sort questions on Main page by alphabet, date or answer count
 3. Feature to add new question
 4. Feature to add new answer (location: question detail page)
 5. Feature to delete question
 6. Feature to Register new user
 7. Feature to Login with user and store session (who is currently logged in is always visible on frontend)
 8. Feature to Logout user

<p align="right">(<a href="#readme-top">:top:</a>)</p>


<!-- CONTRIBUTING -->
## Contributing
This project was made by three Codecool students: Anna Cseke, Péter Jung, László Péterfi.

<!-- CONTACT -->
## Contact

:woman_technologist: Anna Cseke - :email: anna.cseke[at]gmail[dot]com :black_medium_square: [![LinkedIn][linkedin-shield]][linkedin-Anna]<br>
:man_technologist: Péter Jung - :email: jung.peter24[at]gmail[dot]com :black_medium_square: [![LinkedIn][linkedin-shield]][linkedin-Peter]<br>
:man_technologist: László Péterfi - :email: peterfi.laci.0325[at]gmail[dot]com :black_medium_square: [![LinkedIn][linkedin-shield]][linkedin-Laszlo]<br>

Project Link: [https://github.com/placi0325/Stackoverflow-TW5](https://github.com/placi0325/Stackoverflow-TW5)

<p align="right">(<a href="#readme-top">:top:</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[contributors-url]: https://github.com/placi0325/Stackoverflow-TW5/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/placi0325/Stackoverflow-TW5.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-Peter]: https://www.linkedin.com/in/pjung-dev
[linkedin-Anna]: https://www.linkedin.com/in/anna-cseke-847b1963/
[linkedin-Laszlo]: https://www.linkedin.com/in/l%C3%A1szl%C3%B3-p%C3%A9terfi/
[product-screenshot]: images/screenshot.png
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[JavaScript.img]:     https://img.shields.io/badge/JavaScript-323330?style=for-the-badge&logo=javascript&logoColor=F7DF1E
[JavaScript-url]: https://www.javascript.com/
[SpringBoot.img]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[SpringBoot-url]: https://spring.io/projects/spring-boot
[Postgres.img]: https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white
[Postgres-url]: https://www.postgresql.org/
[ThymeLeaf.img]: https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white
[ThymeLeaf-url]: https://www.thymeleaf.org/
