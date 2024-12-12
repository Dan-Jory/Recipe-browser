# Recipe_Browser



## Getting started
In order to run the recipe browser, you must have a version of Java 17 or higher downloaded and installed (To work with spring-boot). We also used PostgreSQL version 16.2, so earlier versions may not work.

First, clone the repo to an IDE so that you can run the program more easily. We used IntelliJ Ultimate, so we recommend that. We also used Maven as our package manager to keep track of our dependencies. Then create a database in PostgreSQL, and using the ssh_recipes_final.sql file in a query, execute the query to populate the database. We suggest you run a simple select query to check it's populated

Next in the application.properties, you must change the top 3 lines to your database's information (The DB Name, the username and password to log in) and save the changes. Then run the Main.java file and the recipe-html.html file, and a tab should open, with the website loaded. The backend may take a few seconds to start up but once it has, you input your ingredients and receive your recipes back from there!

If you wish to build a .jar file you can run mvn clean package, then cd into target and run using java -jar [FILENAME]


Project summary 

This project was largely based on Finlay’s EDR. This can be briefly summarised as follows: 

    Take data from the SSH camera to find ingredients in the student’s fridge 

    Build a large database of recipes to match these ingredients against 

    The student should be able to access this tool via a webpage on the SSH cloud 

For the most part we did not make any changes. However, we did work with a slightly different tech stack, such as using Java SpringBoot in the backend rather than python Django. Our project was successful overall, we managed to build a webpage that allows users to input ingredients, and displays a list of recipes, each with a hyperlink to a website attached to it. The website is very functional, and because of the size of the database returns lots of recipes. 

![alt text] https://imgur.com/a/y6ViIDo 

 

 

How the prototype was created 

Fin: 

I started the project by converting large recipe datasets into neat CSVs using python. I first took recipe NLG, a semi-structured dataset of 2 million recipes. Because recipe NLG is a semi-structured dataset, I needed a cleaner dataset of possible ingredients, and for this I used Kaggle’s ‘what’s cooking’. I built a list of ingredients from What’s cooking by using a python NLP module to separate nouns from adjectives and remove plurals. I then matched this list of ingredients against the recipes in recipe NLG to build an index of ingredients and their associated recipes. I then used this data to create a normalised SQL database which I restricted to 100,000 recipes in order to limit the size to about 50MB. 

Originally, I sent Dan a flat file database so that he could create the backend while I finished finalising the database. So, after I finished the database, I tweaked the backend so that the querying worked with the new database. I also tweaked the API so that it worked with a list of ingredients, rather than exactly three. I then integrated this with the frontend built by Josh and Bill, by calling the REST api, and using the buttons they made to display the list of recipes each attached with a link. 

I also made a few other minor changes. I updated the CSS file to make a red, white and black colour scheme. I made a bash script to test CURL requests.  

 

Dan: I started by building the backend using Spring Boot to act as an intermediary layer between the frontend and the database. Initially, there was no database to work with, but once Fin sent over a draft, I incorporated it into the project. The prototype lacked a frontend, so interactions were conducted via curl commands in the command line. 

 

This post request was received by the controller, which passed the ingredients to the RecipeRepository file which generates an SQL query to send to the database. At the time, it responded with a String but has since been changed to return the recipe’s details. This implementation required spring-boot-starter-web dependency to run the program as a server using Tomcat and to allow it to listen for POST requests. The other 2 primary dependencies were PostgreSQL and spring-boot-starter-data-jpa to communicate with the database and to map the Java objects to the database using Hibernate. 

 

This first implementation was functional but limited in scope. However, for testing purposes, it was enough so I sent off the repo to Josh so he could work on a frontend for it. In the meantime, Fin had improved the backends' code, so I worked on writing some unit tests for it but only had time to implement one. It validates that the SQL Query sent to the database is formatted correctly. This required 3 more dependencies, 1 to implement JUnit, and 2 to capture and analyse the console’s logs to check the Hibernate output.  

 

 

Bill:  

We started by organising a group meeting when everyone was free. We met in the library and split up the tasks. Originally, me and Fin were to work on the database and data cleaning, Joshua was to work on the frontend and Dan was to work on the backend. We set up a Whatsapp group chat and a repository on GitHub to ensure we were able to communicate and share code to the best of our abilities. It quickly became clear that setting up the database and cleaning the data didn't require two people working on it, so I got in contact with Joshua and Dan and offered a helping hand. Dan did not require any extra help but Joshua took me up on it. For some reason, Joshua didn't utilise GitHub and sent me through the frontend, which was not a problem. I ensured that I made him aware of any changes or concerns I had regarding the code via WhatsApp and he did the same. 

 

When splitting up the development of the Frontend, it was clear that Joshua was more familiar with the processes required to communicate with the database, so he developed that aspect. I continued making fixes and general improvements within the HTML, JS and CSS files. Later on, once Fin had completed his  

 

 

 

 

250 words on every group member 

Fin: 

Bill – Bill has been a pleasure to work with. He has good communication skills and talked a lot on our group chat. Initally, I worked with him to clean the data using python, although we quickly realised that it would be more useful if he worked on the frontend with Josh instead. He provided regular updates on what him and Josh were doing which was really helpful in seeing what we needed to do before the deadline. He was not hugely experienced in working with frontend design, however he did appear to put in effort, and he would ask for help when he needed it. 

Dan – Dan is probably who I worked most closely with this project. Initially, I needed to create the database so that he could make a working backend. The database took me longer than expected, so I sent Dan a flat file mock database so that he could start to get his backend running. I then updated his backend so that it worked with the new database. Dan’s code was really clean and easy to understand, even as someone who doesn’t have much experience with SpringBoot. I think Dan really played a key role in bringing everything together, especially in terms of file and dependency management. He also has really good communication skills and can make quick and effective decisions. Overall, he played a key role in our group by creating a really robust backend and communicating really well with our group. He also managed the git repository which was really important. 

Josh – Josh spent the majority of his time creating the backend with Bill. I did not work with him too closely, however I did tweak some of his code when I integrated the frontend and the backend. His style is also really clean and easy to work with. I don’t have a huge amount to say because I didn’t work with him especially closely and he was not the most responsive. 

 

Dan: 

Fin: Fin is a gem to work with. He was communicative and his quality of work was excellent. I was worried when the first database was so large so let him know that I thought we should shrink it to speed up the lookups and he happily did so. It showed he was receptive to feedback and was willing to make changes. He had a hand in each part of the program as well as the planning of the project. I think most of our success in the project came from how we first planned and distributed the work. Originally Bill would work on the database cleaning, and Josh on the frontend, which left one of me or Fin to work on the backend. I volunteered, so Fin said he’d help each of us and I think he really did a good job in that aspect as I believe he had a large part in each of the 3.  It was a good idea to have a prospective goal as well as a physical deadline as I think it made sure we were all accountable for our work. This was Fin’s idea. 

 

Josh: I feel like Josh was a very quiet presence on the team. I think in our first meeting, he was sort of pigeonholed into working on the frontend as the other 3 of us didn’t feel confident and he put himself forward, which was a nice sign. However, I think it’s difficult to evaluate exactly how much was done by him specifically because of his lack of communication. I know he and Bill worked on it together, but I’m not sure which parts were done by who. My understanding is that Josh did the foundational work for the frontend, which was fixed and tweaked by Bill.  Either way, I’m happy with the quality of the code and would gladly work again with Josh, but I think more regular updates would make it much clearer what exactly was being done, and whether help was needed.  

 

Bill: Bill is difficult to provide constructive criticism for mostly the same issues as with Josh since they both worked on the frontend and it isn’t clear who worked on what specifically. I do think he was more communicative, however, and did ask for help when needed (e.g. when pushing his code to the repo and merging it). I also think he worked with Fin to create the original database used in the program. I don’t have much criticism that is dissimilar to what I gave Josh. I feel like more communication would’ve benefitted the team, but I don’t think the amount given was detrimental. He did provide regular updates on the group chat and I felt like I vaguely knew what he was doing during the prototype, but I just don’t have specifics. Again I am happy with the result and would happily work with him again. 

 

 

 
