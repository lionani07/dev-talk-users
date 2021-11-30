#!/bin/bash
set -x

# Create queue SQS
awslocal sqs create-queue --queue-name create_video_queue

set +x
