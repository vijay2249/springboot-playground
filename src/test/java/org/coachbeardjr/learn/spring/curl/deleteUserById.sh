id=$1
if [ -z "$id" ]; then
  echo "Usage: ./deleteUserById.sh <Id>"
  exit 1
fi

curl -X DELETE http://localhost:8080/users/${id}