curl -X POST http://localhost:8080/reviews \
-H "Content-Type: application/json" \
-d "{\"bookId\": 7, \"reviewerName\":\"jarvis\", \"comment\":\"awesome\", \"rating\": 5}"