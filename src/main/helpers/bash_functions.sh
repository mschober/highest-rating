#!/bin/bash
PROJ_ROOT=$HOME/IdeaProjects/top-rated-pro
HEADER="REVIEWID        RATING  REVIEWTEXT      PROKEY  REVIEWERKEY     REVIEWDATE"
REVIEWS_FILE_NOT_PROMOTED=$PROJ_ROOT/random_reviews.not_promoted.tsv
REVIEWS_FILE=$PROJ_ROOT/src/test/resources/reviews/random_reviews.tsv

function copies_of_ids(){
  cat $REVIEWS_FILE_NOT_PROMOTED | awk '{ print $5 }' | sort | uniq -c | tee repeated_ids.out
}

function generate_reviews_file(){
  $PROJ_ROOT/src/main/helpers/output_reviews.py > $REVIEWS_FILE_NOT_PROMOTED
  header
  head $REVIEWS_FILE_NOT_PROMOTED
  tail $REVIEWS_FILE_NOT_PROMOTED
}

function view_first(){
  COUNT=${1:-10}
  head -$COUNT $REVIEWS_FILE
}

function view_last(){
  COUNT=${1:-10}
  tail -$COUNT $REVIEWS_FILE
}


function promote_reviews_file(){
  mv $REVIEWS_FILE_NOT_PROMOTED $REVIEWS_FILE
}

function header(){
  echo $HEADER
}

function match_key(){
  grep "	$1	"
}

function count_key(){
  cat $REVIEWS_FILE | match_key $1 | wc -l
}

function key_ratings_list(){
  cat $REVIEWS_FILE | match_key $1 | awk '{ print $2 }'
}

function key_ratings_sum(){
  key_ratings_list $1 | paste -sd+ -
}

function key_average(){
echo $(( $(key_ratings_sum $1) )) / $(( $(count_key $1) ))
echo $(( $(( $(key_ratings_sum $1) )) / $(( $(count_key $1) )) ))
}
