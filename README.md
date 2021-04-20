<p align="center">
<h1  align="center">Vacin'aqui</h1>
  <h3 align="center">   Vaccine queue management software for covid-19</h3>
 <br />
  <p align="center">
   Project for the Computing Solutions Programming and Software Modeling classes
       <br />
    <br />
    Back-end developed by <a href="https://www.linkedin.com/in/levi-melo-dos-santos-5277441a1//">Levi Melo dos Santos</a>
  </p>
</p>

## Index

* [Team](#Team)
* [Proposal](#Proposal)
* [Techs](#Used-Techs)

# Team
- Ariadne Braga - RA: 820142810
- Igor cosmo costa - RA: 820150105
- João Victor Dabus Spiwak da Silva - RA: 820150636
- <a href="https://www.linkedin.com/in/levi-melo-dos-santos-5277441a1//">Levi Melo dos Santos</a> - RA: 820140945
- Lucas Almeida Rocha - RA: 820290346
- Lucas Gomes de Carvalho - RA: 820151785
- Matheus Patrício - RA: 820134204
- Victor Landim - RA: 820146087


# Proposal
Our challenge is to create a software for the management of employees and the vaccine queue

## Requirements:
- The software must be a desktop solution with a graphical interface and database.<br>
- Only authenticated users can have access to its functionalities(Administrators and Attendants).<br>
    - Administrators must have access to the following features.<br>
        - Registration of new administrators and attendants.<br>
        - Registration of people to be vaccinated.<br>
            - Name.<br>
            - Age.<br>
            - One flag indicating whether the person's profession is associated with the health field or not.<br>
            - Address.<br>
            - Vaccination date. Initially null. The software automatically fills in when the person get the vaccin.<br>
        - Removal of administrators and attendants.<br>
        - Generation of vaccination reports. The system should generate the following type report: given a period (with start and end date) chosen by the user, the report should show the average daily vaccination rate for following age groups.
            - age ≥ 90
            - 70 ≤ age < 90
            - 50 ≤ age < 70
            - age < 50
    - Attendants must have access to the following features.<br>
        - Visualization of the queue of people to be vaccinated. The criterion of queue ordering is as follows.<br>
            - 1 - People age equal to 70 or higher.<br>
            - 2 - People whose profession related to the health.<br>
            - 3 - The rest of the people.<br>
        - Vaccination confirmation: When viewing the vaccination queue, the attendant checks who the next person is and applies the vaccine. One time vaccine is applied, it registers in the system that that person has already been vaccinated. The system records vaccination data automatically.

# Used Techs
- Java
- javax.swing...
- mySql

## External Libraries
- mysql-connector-java-8.0.17.jar
- activation-1.1.1.jar
- javax.mail.jar
