#!/usr/bin/env python
import time, random

import time

def generate_reviews():
    review_id = 0
    for index in range(1, 100001):
        review_id += 1
        rating = random.randint(1, 5)
        review_text = "hi there"
        prokey = random.randrange(3000, 3500)
        reviewer_key = random.randint(1000, 90000)
        review_date = time.strftime("%Y-%m-%d %H:%M:%S")
        print '{0}	{1}	{2}	{3}	{4}	"{5}"'.format(review_id, rating, review_text, prokey, reviewer_key, review_date)

def header():
    header = "REVIEWID        RATING  REVIEWTEXT      PROKEY  REVIEWERKEY     REVIEWDATE"
    print header

generate_reviews()
