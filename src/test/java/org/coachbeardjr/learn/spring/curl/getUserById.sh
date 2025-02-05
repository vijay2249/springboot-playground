id=$1
if [ -z "$id" ]; then
  echo "Usage: ./getUserById.sh <Id>"
  exit 1
fi

curl http://localhost:8080/users/${id}