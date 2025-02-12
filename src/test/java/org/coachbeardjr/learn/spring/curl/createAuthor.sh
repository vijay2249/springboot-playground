curl -X POST http://localhost:8080/authors \
-H "Content-Type: application/json" \
-d "{\"name\": \"Stephen R Covey\", \"biography\": \"7 Habits of Highly Effective People\", \"publisher\": {\"id\": 22}}"