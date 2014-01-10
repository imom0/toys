#!/bin/bash

SOUNDS_DIR="/System/Library/Sounds/"
WORK_INTERVAL=25
REST_INTERVAL=5

# work
say "start work"
sleep 60
for i in `seq $(($WORK_INTERVAL-1)) 1`
do
	if [ $(($i % 5)) -eq "0" ]; then
		say "$i minutes left" &
	else
		say -v Whisper tick tick &
	fi
	echo "$i minutes left"
	sleep 60
done
afplay "$SOUNDS_DIR"Ping.aiff
sleep 3
say "work finished"
sleep 2

# rest
say "start rest"
sleep $(($REST_INTERVAL*60))
say "rest finished"
