# Twitter Status

Twitter Status allows users to check out latest 20 twitter status based on a [screen name](https://stackoverflow.com/questions/45951589/twitter-api-what-is-the-difference-between-name-and-screen-name-which-one/)

[Link to App](https://twitterstatus.herokuapp.com/)

## Running Locally

Make sure you have Java and Maven installed.  Also, install the [Heroku CLI](https://cli.heroku.com/).

```sh
$ git clone https://github.com/Cherchercher/TwitterStatus
$ cd TwitterStatus
$ mvn install
$ heroku local:start
```

Your app should now be running on [localhost:5000](http://localhost:5000/).

## Features
1. In addition to users' latest activity, location, and friends/followers stats,	users can also visualize how post counts correlate with like and Retweet counts. 

2. When a data point on graph is clicked, the top Tweet that contributed to most likes and retweets of the month will be returned. 

## Limits

Twitter API allows for 180 requests per 15-min window (user auth)

## Coming Soon (with Twitter Account Activity API Beta Version) : 

1.Users who interacts the most with current user will be returned.  

2.Time of day, and day of week where interactions spike will be returned.
     
