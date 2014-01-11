#!/bin/bash

SOUNDS_DIR="/System/Library/Sounds/"
WORK_INTERVAL=25
REST_INTERVAL=5

function alert {
	if [ "$2" != "silent" ]; then
		say $1 &
	fi
	echo $1
}

# work
alert "start work"
sleep 60
for i in `seq $(($WORK_INTERVAL-1)) 1`
do
	if [ $(($i % 5)) -eq "0" ]; then
		alert "$i minutes left"
	else
		say -v Whisper tick tick &
		alert "$i minutes left" silent
	fi
	sleep 60
done
afplay "$SOUNDS_DIR"Ping.aiff
sleep 1
alert "work finished"
sleep 1

# rest
alert "start rest"
sleep $(($REST_INTERVAL*60))
alert "rest finished"
