#!/bin/bash

echo "Running tests for /api/search API"
echo -e "\n\n"

BASE_URL="http://localhost:8080/api/search"

limit_output() {
    head -c 200
    echo -e "\n[Output truncated]\n"
}

echo "Test 1: Valid ingredients"
echo -e "\n"
curl -X POST $BASE_URL \
-H "Content-Type: application/json" \
-d '["chicken", "garlic", "onion"]' | limit_output
echo -e "\n\n\n"

echo "Test 2: No ingredients"
echo -e "\n"
curl -X POST $BASE_URL \
-H "Content-Type: application/json" \
-d '[]' | limit_output
echo -e "\n\n\n"

echo "Test 3: Invalid data format"
echo -e "\n"
curl -X POST $BASE_URL \
-H "Content-Type: application/json" \
-d '{"ingredient": "chicken"}' | limit_output
echo -e "\n\n\n"

echo "Test 4: Unexpected data types"
echo -e "\n"
curl -X POST $BASE_URL \
-H "Content-Type: application/json" \
-d '[123, true, null]' | limit_output
echo -e "\n\n\n"

echo "Test 5: Stress test"
echo -e "\n"
curl -X POST $BASE_URL \
-H "Content-Type: application/json" \
-d '["chicken", "garlic", "onion", "salt", "pepper", "tomato", "potato", "basil", "oregano", "thyme", "parsley", "carrot", "celery", "lemon", "butter", "flour", "sugar", "milk", "cream", "cheese"]' | limit_output
echo -e "\n\n\n"

echo "All tests completed."
echo -e "\n\n"
