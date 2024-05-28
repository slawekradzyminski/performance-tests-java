#!/bin/bash

# URL of the API endpoint
ENDPOINT_URL="http://localhost:8025/api/v2/messages"

# Use curl to send a GET request and pipe the response to jq to extract the total number of messages
TOTAL_MESSAGES=$(curl -s $ENDPOINT_URL | jq '.total')

# Check if the total number of messages is greater than 200
if [ "$TOTAL_MESSAGES" -gt 200 ]; then
    echo "Verification passed: There are more than 200 messages. Total messages: $TOTAL_MESSAGES"
    exit 0
else
    echo "Verification failed: There are not more than 200 messages. Total messages: $TOTAL_MESSAGES"
    exit 1
fi
