# Twitter Status

Twitter Status allows users to check out latest 20 twitter status based on a screen name
[Link to App](https://hidden-reef-17988.herokuapp.com/)

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/heroku/java-getting-started.git
$ cd java-getting-started
$ mvn install
$ heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Features
1. In addition to users' latest activity, location, and friends/followers stats,	users can also visualize how post counts correlate with like and Retweet counts. 

2. When a data point on graph is clicked, the top Tweet that contributed to most likes and retweets of the month will be returned. 

##Limits

Twitter API allows for 180 requests per 15-min window (user auth)

## Coming Soon (with Twitter Account Activity API Beta Version) : 

1.Users who interacts the most with current user will be returned.  

2.Time of day, and date of time where interactions spike will be returned.
     
