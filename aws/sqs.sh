#!/bin/bash
set -x

# Create queue SQS
awslocal sqs create-queue --queue-name delete_video_queue

set +x
