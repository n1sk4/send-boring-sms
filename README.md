# Send boring SMS messages -> **send_it** 


<img src="https://user-images.githubusercontent.com/92214769/173541651-ec3bb26e-a009-449d-ac4c-5aadb38cef20.jpg" alt="drawing" width="75"/>

About
=====
This app was a single day project to see how SMS API works in Android Native.

I had an issue where I had to send parking SMS messages each day I would work from office.
Some times I would forget, so I made this app to deal with tasks for SMS parking.

The design of this app had in mind to automate sending SMS messages perticulary for SMS parking. 
This can be used to setup automated tasks or notifications.

Application
===========
The app Main Activity is comprised of a RecyclerView object that contains rows of SMS templates.
The row can be expanded to show more info and to edit the data inside.

<img src="https://user-images.githubusercontent.com/92214769/173253570-6afee2b2-665b-40b6-8182-74bf956b4aa5.jpg" alt="drawing" width="200"/>


<img src="https://user-images.githubusercontent.com/92214769/173253588-5fb50236-596c-4665-800a-5e425ff29ac0.jpg" alt="drawing" width="200"/>

Adding new SMS
--------------

Adding a new item can be acomplished by selecting the add icon on top (from the menu).
The item has Title, Phone number and Message as the main features, and afterwards the user can set 
reminders or repetitive tasks. Lets say something like an alarm clock but for lazy SMS messages.

<img src="https://user-images.githubusercontent.com/92214769/173253592-185b9d75-5de7-4a0e-854e-f3c9adae4518.jpg" alt="drawing" width="200"/>

<img src="https://user-images.githubusercontent.com/92214769/173253595-04cddcde-cedb-47bb-b1aa-6060eb265d13.jpg" alt="drawing" width="200"/>

Possibilites are endless. You can put automatic SMS messages for friends (or family) birthdays, 
frequent parking SMS, or something only you can imagine or think of.

Setting up tasks / notifications
--------------------------------
Repeating tasks and/or notifications can be set by clicking on the *Set notification* text.
New window pops up, opening a new Activity for setting up the notifications and repeating tasks.

In the spinner object you can select between a few different options:
* as of 14.6.2022.:
  - Send once
  - Send on time
  - Send on time and date
  - **TODO**: Notification only option 
  - 
<img src="https://user-images.githubusercontent.com/92214769/173526146-72d78727-c846-44d9-a6b1-fae439f228bb.jpg" alt="drawing" width="200"/> <img src="https://user-images.githubusercontent.com/92214769/173523996-c203d49d-e1f1-4e1d-9118-5175100becd6.jpg" alt="drawing" width="200"/>


After the type of task has been selected, you can continue by selecting time and date.
This is done by clicking on the image buttons which then open Date picker and Time picker respectivly.

<img src="https://user-images.githubusercontent.com/92214769/173525160-b4e89a7d-b92d-4952-b421-c741615ab6aa.jpg" alt="drawing" width="200"/> <img src="https://user-images.githubusercontent.com/92214769/173525179-7f79b9fd-8372-4254-9aba-f9363d16b223.jpg" alt="drawing" width="200"/>

If you want notifications for reminding you to send the SMS, or that the time of the sending is neigh, you can click on the Notifications button.

<img src="https://user-images.githubusercontent.com/92214769/173525793-d7457e63-e49c-4eb9-9947-d371acbf67b5.jpg" alt="drawing" width="200"/> <img src="https://user-images.githubusercontent.com/92214769/173525810-0eaee3f4-95f1-4648-9ac5-f10cc2db2915.jpg" alt="drawing" width="200"/>

When you're done, just click on the checkmark button and you're finnished with the setup. 
